package com.tentone.ganimator.studio;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Configuration
{
	//Configuration Values
	public static int fps_lock; // 0->Off, 1->60, 2->120
	public static int explorer_pos; // 0->Right , 1->Left
	public static String texture_path;
	
	//Load configuration file
	public static void loadConfigFile(File file) throws Exception
	{
		Scanner sc = new Scanner(file);
		texture_path=sc.nextLine();
		fps_lock = Integer.parseInt(sc.nextLine());
		explorer_pos = Integer.parseInt(sc.nextLine());
		sc.close();
	}
	
	//Save configuration file
	public static void saveConfigFile(File file) throws Exception
	{
		PrintWriter pw = new PrintWriter(file);
		pw.println(texture_path);
		pw.println(fps_lock);
		pw.println(explorer_pos);
		pw.close();
	}
	
	//Create new configuration file with default settings
	public static void newConfigFile(File file)
	{
		texture_path="";
		fps_lock=0;
		explorer_pos=0;
		try
		{
			saveConfigFile(file);
		}
		catch(Exception e){}
	}
}
