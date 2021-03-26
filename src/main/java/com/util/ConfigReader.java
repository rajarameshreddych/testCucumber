package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties config;

	/**
	 * This method is used to load config properties file`
	 * @return
	 */
	public Properties init_Config() {
		
		config = new Properties();
		
		try {
			FileInputStream fip = new FileInputStream("./src/test/resources/com/config/config.properties");
			config.load(fip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return config;

	}
}
