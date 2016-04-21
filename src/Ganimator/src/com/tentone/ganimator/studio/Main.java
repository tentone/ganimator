package com.tentone.ganimator.studio;

import java.awt.BorderLayout;
import java.io.File;

import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas;

public class Main
{
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		//Load Editor Configuration File
		try
		{
			Configuration.loadConfigFile(new File("config"));
			
		}
		catch(Exception e)
		{
			Configuration.newConfigFile(new File("config"));
		}
		
		Interface.ini();
		Ganimator.canvas = new LwjglAWTCanvas(new Ganimator(args));

		//Poll until all components are ready
		while(true)
		{
			try
			{
				Ganimator.canvas.getCanvas().setSize(Interface.container.size().width,Interface.container.size().height);
				Interface.container.add(Ganimator.canvas.getCanvas(),BorderLayout.CENTER);
				break;
			}
			catch(Exception e){}
		}
		
		//Set Interface Visible
		Interface.self.setVisible(true);
	}
}
