package com.nagarro.seleniumAssignment.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static Properties prop = null;
	public static File file = null;
	public static FileInputStream fis = null;

	// Static block to initialize class variables
	public ConfigReader() {
		{
			file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
			try {
				fis = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			prop = new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
	}

	public String getProperty(String key) {
		// TODO Auto-generated method stub
		return prop.getProperty(key);
	}
	
	
	

}