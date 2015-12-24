package com.tentone.ganimator.studio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class MouseInput
{
	//Mouse Absolute Position
	private static Vector2 position_absolute;
	
	//Mouse Position relative to camera
	public static Vector2 position;
	public static Vector2 position_last;
	public static Vector2 position_dif;
	
	//Mouse Buttons
	public static Button left, right, middle;

	//Camera
	private static OrthographicCamera camera;
	
	protected MouseInput(){}
	
	public static void ini(OrthographicCamera cam)
	{
		position_absolute = new Vector2(0,0);
		position = new Vector2(0,0);
		position_last = new Vector2(0,0);
		position_dif = new Vector2(0,0);
		
		left = new Button();
		right = new Button();
		middle = new Button();
		
		camera = cam;
	}
	
	public static void update()
	{
		//Update Button Status
		left.update(Gdx.input.isButtonPressed(Input.Buttons.LEFT));
		right.update(Gdx.input.isButtonPressed(Input.Buttons.RIGHT));
		middle.update(Gdx.input.isButtonPressed(Input.Buttons.MIDDLE));
		
		//Mouse Position Update
		position_last.set(position_absolute);
		position_absolute.set(Gdx.input.getX(),Gdx.graphics.getHeight()-Gdx.input.getY());
		position.set(Gdx.input.getX()*camera.zoom+camera.position.x-camera.viewportWidth*camera.zoom/2,(Gdx.graphics.getHeight()-Gdx.input.getY())*camera.zoom+camera.position.y-camera.viewportHeight*camera.zoom/2);
		position_dif.set((position_absolute.x-position_last.x)*camera.zoom,(position_absolute.y-position_last.y)*camera.zoom);
	}
	
}

//Auxiliary class to help control mouse input
class Button
{
	public boolean just_pressed;
	public boolean just_released;
	public boolean is_pressed;
	
	public Button()
	{
		just_pressed = false;
		just_released = false;
		is_pressed = false;
	}
	
	public void update(boolean button_pressed)
	{
		just_released = is_pressed && !button_pressed;
		is_pressed = button_pressed;
	}
}