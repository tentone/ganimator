package com.tentone.ganimator;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

//Ganimator Interface to Suport animations in LIBGDX
public interface Animatable
{
	//Set Object Rotation in degrees
	public void setRotation(float degree);
	//Set Object Origin Position
	public void setOrigin(float x, float y);
	//Set Object Color in RGBA
	public void setColor(float r, float g, float b, float a);
	//Set Object alpha (0 to 1)
	public void setAlpha(float alpha);
	//Set Object Position
	public void setPosition(float x, float y);
	//Set Object Size
	public void setSize(float x, float y);
	//Change Object Texture
	public void setTexture(Texture texture);
	//Draw Object to a SpriteBatch
	public void draw(Batch batch);
}
