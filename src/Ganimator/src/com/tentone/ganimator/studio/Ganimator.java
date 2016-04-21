package com.tentone.ganimator.studio;

import javax.swing.JOptionPane;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.tentone.ganimator.Animation;
import com.tentone.ganimator.Frame;
import com.tentone.ganimator.Sprite;
import com.tentone.ganimator.TextureManager;

class Ganimator implements ApplicationListener
{
	//Editor Version
	public static String version="V0.4.0 Alpha 201508";
	
	//Texture Path
	public static TextureManager texture_manager;
	
	//Animation Control
	public static boolean animation_playing;
	public static float time_base=1f/120f;
	public static float animation_play_speed=1f;
	
	//Bone Selection Control
	public static boolean bone_selected;
	public static int[] working_bone;
	
	//Data operations flag
	enum Operation{None,ReloadTextures,LoadFile};
	public static Operation data_operation; //If !=0 used to call stuff that need to be on ogl context
	public static String data_arg_string; //Argument for op calls
	
	//Working Animation
	public static Animation animation;
	
	//Camera
	private static OrthographicCamera camera,overlayCamera;
	private static SpriteBatch batch,overlayBatch;
	private static BitmapFont overlayFont;
	private static ShapeRenderer shape;
	
	//Render Canvas
	public static LwjglAWTCanvas canvas;
	
	//File loaded info
	public static String file_loaded;
	public static boolean file_by_argument;
	
	public Ganimator(String[] args)
	{
		if(args.length>0)
		{
			file_by_argument=true;
			file_loaded=args[0];
		}
		else
		{
			file_by_argument=false;
			file_loaded="";
		}
	}
	
	@Override
	public void create()
	{	
		//Initialize Camera
		iniCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		iniOverlay(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		
		//Initialize Mouse Input Handler
		MouseInput.ini(camera);
		
		try
		{
			texture_manager=new TextureManager(Configuration.texture_path);
		}
		catch(Exception e){}
		
		//Initialize ShapeRenderer
		shape = new ShapeRenderer();
		
		//Initialize Control Variables
		bone_selected=false;
		working_bone=null;
		animation_playing=false;
		
		//Operation Calls inside the render thread
		data_operation=Operation.None; //1->Add Bone from interface values | 2-> Load external file
		data_arg_string=null; //String argument to be used on data op calls
		
		//Start new Empty animation
		newAnimation();
		
		//If some file has been passed by argument
		if(file_by_argument)
		{
			try
			{
				animation.loadFile(file_loaded);
			}
			catch (Exception e){}
		}
		
		//Update Interface
		Interface.updateInterface();
		
		//Create Input Processor to Handle Mouse Scrolling Event
		Gdx.input.setInputProcessor(new InputAdapter()
		{
			//Mouse Scrolled
			public boolean scrolled(int amount)
			{
				try
				{
					if(camera.zoom>=0.1f && camera.zoom<=10f)
					{
						if(camera.zoom<=1f)
						{
							camera.zoom+=amount*0.03f;
						}
						else
						{
							camera.zoom+=amount*0.2f;
						}
					}
					
					//Correct Camera zoom
					if(camera.zoom<0.10f)
					{
						camera.zoom=0.10f;
					}
					else if(camera.zoom>10f)
					{
						camera.zoom=10f;
					}
				}
				catch(Exception e){}
				
				return false;
			}
		});
		
		//Animation Update Timer
		Timer.schedule(new Task()
		{
			@Override
			public void run()
			{
				update();
			}
		},0f,time_base);
	}

	
	public void update()
	{
		if(animation_playing)
		{
			animation.update(time_base*animation_play_speed);
			Interface.updateTimeBar();
		}
		
		//TODO DEBUG STUFF REMOVE THIS
		/*if(Gdx.input.isKeyPressed(Keys.UP))
		{
			animation.setScale(animation.getScale().x+0.05f, animation.getScale().y+0.05f);
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN))
		{
			animation.setScale(animation.getScale().x-0.05f, animation.getScale().y-0.05f);
		}*/
	}
	
	@Override
	public void render()
	{
		//Process Operation calls
		processOperationCalls();
		
		//Update Input values
		MouseInput.update();
		
		//Update Camera Movement
		updateCameraPosition();
		
		//Collect Input and process changes in animation
		processAnimationChanges();
		
		//Clear Screen
		Gdx.gl.glClearColor(0.4f,0.4f,0.4f,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//Draw Grid
		drawGrid();
		
		//Render Animation
		startFrame();
		animation.draw(batch);
		if(bone_selected && !Gdx.input.isKeyPressed(Input.Keys.A))
		{
			int i=0;
			while(i<working_bone.length)
			{
				animation.bone[working_bone[i]].sprite.setColor(1f, 0.2f, 0.2f, 0.3f);
				animation.bone[working_bone[i]].sprite.draw(batch);
				animation.bone[working_bone[i]].sprite.setColor(1f, 1f, 1f, 1f);
				i++;
			}
		}
		endFrame();

		//Draw Working Bone Box
		if(bone_selected)
		{
			int i=0;
			while(i<working_bone.length)
			{
				drawBoneBox(working_bone[i]);
				i++;
			}
		}
		
		//Render Overlay
		drawOverlay();
		
		//Delay next frame if needed
		if(Configuration.fps_lock!=0)
		{
			try
			{
				if(Configuration.fps_lock==1) //Lock to 60 FPS
				{
					Thread.sleep((long)(16));
				}
				else if(Configuration.fps_lock==2) //Lock to 120FPS
				{
					Thread.sleep((long)(8));
				}
			}
			catch(Exception e){}
		}
	}

	//Process changes in animation
	public static void processAnimationChanges()
	{
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT) && bone_selected && !animation_playing)
		{
			float time=animation.getTime();
			
			int i=0;
			while(i<working_bone.length)
			{
				int frame_index = animation.bone[working_bone[i]].getFrame(time);
				
				//Change Position
				if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
				{
					//Change existent bone
					if(frame_index!=-1)
					{
						animation.bone[working_bone[i]].key_frame[frame_index].pos.add(MouseInput.position_dif);
					}
					else
					{
						Frame frame = animation.bone[working_bone[i]].getActualFrame().clone();
						frame.time=time;
						frame.pos.add(MouseInput.position_dif);
						animation.bone[working_bone[i]].addKeyFrame(frame);
					}
				}
				
				//Change Size
				if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
				{
					if(frame_index!=-1)
					{
						animation.bone[working_bone[i]].key_frame[frame_index].size.add(MouseInput.position_dif);
					}
					else
					{
						Frame frame = animation.bone[working_bone[i]].getActualFrame().clone();
						frame.time=time;
						frame.size.add(MouseInput.position_dif);
						animation.bone[working_bone[i]].addKeyFrame(frame);
					}
				}
				
				//Change Origin
				if(Gdx.input.isKeyPressed(Input.Keys.ALT_LEFT))
				{
					if(frame_index!=-1)
					{
						animation.bone[working_bone[i]].key_frame[frame_index].ori.x=MouseInput.position.x-animation.bone[working_bone[i]].key_frame[frame_index].pos.x;
						animation.bone[working_bone[i]].key_frame[frame_index].ori.y=MouseInput.position.y-animation.bone[working_bone[i]].key_frame[frame_index].pos.y;
					}
					else
					{
						Frame frame = animation.bone[working_bone[i]].getActualFrame().clone();
						frame.time=time;
						frame.ori.set(MouseInput.position);
						animation.bone[working_bone[i]].addKeyFrame(frame);
					}
				}
				
				//Change X Size
				if(Gdx.input.isKeyPressed(Input.Keys.X))
				{
					if(frame_index!=-1)
					{
						animation.bone[working_bone[i]].key_frame[frame_index].size.x+=MouseInput.position_dif.x;
					}
					else
					{
						Frame frame = animation.bone[working_bone[i]].getActualFrame().clone();
						frame.time=time;
						frame.size.x+=(MouseInput.position_dif.x);
						animation.bone[working_bone[i]].addKeyFrame(frame);
					}
				}
				
				//Change Y Size
				if(Gdx.input.isKeyPressed(Input.Keys.Y))
				{
					if(frame_index!=-1)
					{
						animation.bone[working_bone[i]].key_frame[frame_index].size.y+=MouseInput.position_dif.y;
					}
					else
					{
						Frame frame = animation.bone[working_bone[i]].getActualFrame().clone();
						frame.time=time;
						frame.size.y+=(MouseInput.position_dif.y);
						animation.bone[working_bone[i]].addKeyFrame(frame);
					}
				}
				
				//Rotate
				if(Gdx.input.isKeyPressed(Input.Keys.R))
				{
					if(frame_index!=-1)
					{
						animation.bone[working_bone[i]].key_frame[frame_index].rotation-=(MouseInput.position_dif.x)*0.6f;
					}
					else //Create new Frame
					{
						Frame frame = animation.bone[working_bone[i]].getActualFrame().clone();
						frame.time=time;
						frame.rotation-=(MouseInput.position_dif.x)*0.6f;
						animation.bone[working_bone[i]].addKeyFrame(frame);
					}
				}
				
				//Change Alpha
				if(Gdx.input.isKeyPressed(Input.Keys.A))
				{
					if(frame_index!=-1)
					{
						animation.bone[working_bone[i]].key_frame[frame_index].alpha+=(MouseInput.position_dif.x)*0.003f;
						
						//Limit alpha Values
						if(animation.bone[working_bone[i]].key_frame[frame_index].alpha>1)
						{
							animation.bone[working_bone[i]].key_frame[frame_index].alpha=1f;
						}
						else if(animation.bone[working_bone[i]].key_frame[frame_index].alpha<0)
						{
							animation.bone[working_bone[i]].key_frame[frame_index].alpha=0f;
						}
					}
					else //Create new Frame
					{
						Frame frame = animation.bone[working_bone[i]].getActualFrame().clone();
						frame.time=time;
						frame.alpha+=(MouseInput.position_dif.x)*0.003f;
						if(frame.alpha>1)
						{
							frame.alpha=1f;
						}
						else if(frame.alpha<0)
						{
							frame.alpha=0f;
						}
						animation.bone[working_bone[i]].addKeyFrame(frame);
					}
				}
				i++;
			}
			//Update Animation Status
			animation.setTime(time);
		}

		if(MouseInput.left.just_released)
		{
			Interface.updateFrameList();
		}
		
		//Create new empty frame
		if(Gdx.input.isKeyPressed(Input.Keys.C) && bone_selected && !animation_playing)
		{
			float time=animation.getTime();
			
			int i=0;
			while(i<working_bone.length)
			{
				int frame_index = animation.bone[working_bone[i]].getFrame(time);
				
				if(frame_index==-1)
				{
					Frame frame = animation.bone[working_bone[i]].getActualFrame().clone();
					frame.time=time;
					animation.bone[working_bone[i]].addKeyFrame(frame);
					Interface.updateFrameList();
				}
				i++;
			}
		}
	}
	
	//Process Camera Movement
	public static void updateCameraPosition()
	{
		if(Gdx.input.isButtonPressed(Input.Buttons.MIDDLE))
		{
			camera.position.x -= MouseInput.position_dif.x;
			camera.position.y -= MouseInput.position_dif.y;
		}
		camera.update();
	}
	
	//Process External Operation Call
	public void processOperationCalls()
	{
		if(data_operation!=Operation.None)
		{
			if(data_operation==Operation.ReloadTextures)//TextureManager Load Textures
			{
				try
				{
					texture_manager.loadTextures();
					animation.reloadTextures();
					Interface.updateTextureList();
				}
				catch(Exception e){}
			}
			else if(data_operation==Operation.LoadFile)//Load External File
			{
				try
				{
					loadAnimation(data_arg_string);
					Interface.updateInterface();
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "Failed to Load File\n("+e+")");
				}
			}
			data_operation=Operation.None;
		}
	}

	public static void setAnimationTime(float time)
	{
		if(animation!=null)
		{
			animation.setTime(time);
		}
	}
	
	public static void setWorkingBone(int wb)
	{
		bone_selected=true;
		working_bone = new int[1];
		working_bone[0]=wb;
		Interface.setTimeBarTime();
	}
	
	//Draw Grid
	public static void drawGrid()
	{
		int grid_size=12;
		int grid_size_double=grid_size*2;
		
		float size_y=Gdx.graphics.getHeight()+2*grid_size;
		float size_x=Gdx.graphics.getWidth()+2*grid_size;
		
		float ori_x=Gdx.graphics.getWidth()/2f-camera.position.x/camera.zoom;
		float ori_y=Gdx.graphics.getHeight()/2f-camera.position.y/camera.zoom;
		
		
		float x=ori_x%grid_size-grid_size;
		float y=ori_y%grid_size-grid_size;
		if((int)(ori_x/grid_size)%2==0)
		{
			x-=grid_size;
		}
		
		if((int)(ori_y/grid_size)%2==0)
		{
			y-=grid_size;
		}
		
		//Draw Background Grid
		shape.setColor(Color.GRAY);
		shape.begin(ShapeType.Filled);
		
		int i=0,j=0;
		while(i<=size_y)
		{
			j=0;
			while(j<=size_x)
			{
				shape.box(x+j,y+i,0,grid_size,grid_size,0);
				j+=grid_size_double;
			}
			i+=grid_size;
			
			j=0;
			while(j<=size_x)
			{
				shape.box(x+j+grid_size,y+i,0,grid_size,grid_size,0);
				j+=grid_size_double;
			}
			i+=grid_size;
		}
		shape.end();
	
		
		//Draw X and Y Lines
		shape.setColor(Color.BLACK);
		shape.begin(ShapeType.Line);
		shape.line(0,ori_y,size_x,ori_y);
		shape.line(ori_x,0,ori_x,size_y);
		shape.end();
	}
	
	//Draw Bone Sprite Box, Origin, and Corners
	public static void drawBoneBox(int i)
	{
		if(i>-1)
		{
			Frame temp = animation.getBones()[i].getActualFrame();
			float[] vertex = ((Sprite) (animation.getBones()[i].sprite)).getVertices();
			
			Vector2[] square = new Vector2[4];
			square[0]=new Vector2(vertex[SpriteBatch.X1],vertex[SpriteBatch.Y1]);
			square[1]=new Vector2(vertex[SpriteBatch.X2],vertex[SpriteBatch.Y2]);
			square[2]=new Vector2(vertex[SpriteBatch.X3],vertex[SpriteBatch.Y3]);
			square[3]=new Vector2(vertex[SpriteBatch.X4],vertex[SpriteBatch.Y4]);
			
			//Ini ShapeRenderer
			shape.setProjectionMatrix(camera.combined);
			shape.begin(ShapeType.Line);
			
			//Draw Bounding Box
			shape.setColor(Color.YELLOW);
			shape.line(square[0],square[1]);
			shape.line(square[1],square[2]);
			shape.line(square[2],square[3]);
			shape.line(square[0],square[3]);
			
			//Draw Corner Dots
			shape.setColor(Color.BLUE);
			shape.circle(square[0].x,square[0].y,5f*camera.zoom,8);
			shape.circle(square[1].x,square[1].y,5f*camera.zoom,8);
			shape.circle(square[2].x,square[2].y,5f*camera.zoom,8);
			shape.circle(square[3].x,square[3].y,5f*camera.zoom,8);
			
			//Draw Origin
			shape.setColor(Color.CYAN);
			shape.circle(temp.pos.x+temp.ori.x,temp.pos.y+temp.ori.y,5f*camera.zoom,8);
			
			//End and Dispose ShapeRenderer
			shape.end();
		}
	}
	
	//Calculates Angle Between Point a and Point b in degrees
	public static float angleBetweenPoints(float ax, float ay, float bx, float by)
	{
		return (float)Math.toDegrees(Math.atan2(ax-bx,ay-by));
	}
	
	//Calculates Distance Between Point a and Point b
	public static float distanceBetweenPoints(float ax, float ay, float bx, float by)
	{
		return Vector2.dst(ax,ay,bx,by);
	}
	
	//Convert Angle from Degrees to Radian
	public static float radToDeg(float angle)
	{
		return angle*0.01745329251f;
	}
	
	//Creates a new Animation
	public static void newAnimation()
	{
		bone_selected=false;
		working_bone=null;
		
		Interface.setTimeBarTime();
		animation = new Animation(texture_manager);
	}
	
	//Loads new Animation into editor
	public static void loadAnimation(String file) throws Exception
	{
		bone_selected=false;
		working_bone=null;
		
		animation_playing=false;
		animation.loadFile(file);
	}
	
	//Called before drawing on SpriteBatch
	public static void startFrame()
	{
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
	}
	
	//End SpriteBatch draw
	public static void endFrame()
	{
		batch.end();
	}
	
	//Initialize Camera Variables and SpriteBatch
	public static void iniCamera(float x, float y)
	{
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false,x,y);
		camera.position.set(0f,0f,0f);
		camera.update();
	}
	
	//Set new Camera Size
	public static void setCameraSize(float x, float y)
	{
		Vector3 temp = new Vector3(camera.position);
		camera.setToOrtho(false,x,y);
		camera.update();
		camera.position.set(temp);
		overlayCamera.setToOrtho(false,x,y);
		overlayCamera.update();
	}
	
	//Initialize Overlay
	public static void iniOverlay(float x, float y)
	{
		overlayBatch = new SpriteBatch();
		overlayFont = new BitmapFont();
		overlayCamera = new OrthographicCamera();
		overlayCamera.setToOrtho(false,x,y);
		overlayCamera.update();
		overlayFont.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		overlayFont.setScale(1f);
	}
	
	//Overlay Draw function
	public static void drawOverlay()
	{
		//Draw Box
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		shape.setProjectionMatrix(overlayCamera.combined);
		shape.begin(ShapeType.Filled);
		shape.setColor(0f, 0f, 0f, 0.5f);
		shape.rect(5f, 5f, 200f, 110f);
		shape.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
		
		//Draw Text
		overlayBatch.setProjectionMatrix(overlayCamera.combined);
		overlayBatch.begin();
		overlayFont.draw(overlayBatch,"Mouse Position:"+(int)MouseInput.position.x+"X,"+(int)MouseInput.position.y+"Y",10f,105f);
		overlayFont.draw(overlayBatch,"Time:"+animation.getTime()+"s",10f,85f);
		overlayFont.draw(overlayBatch,"Camera Zoom:"+(int)(100/camera.zoom)+"%",10f,65f);
		overlayFont.draw(overlayBatch,"FPS:"+Gdx.graphics.getFramesPerSecond(), 10f,45f);
		overlayFont.draw(overlayBatch,"Window Size:"+Gdx.graphics.getWidth()+"X"+Gdx.graphics.getHeight()+"Y",10f,25f);
		overlayBatch.end();
	}
	
	@Override
	public void dispose()
	{
		batch.dispose();
		overlayBatch.dispose();
		overlayFont.dispose();
		shape.dispose();
		texture_manager.dispose();
		shape.dispose();
	}
	
	@Override
	public void pause(){}
	@Override
	public void resize(int width, int height){}
	@Override
	public void resume(){}
}
