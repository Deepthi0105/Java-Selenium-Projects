package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro; // object creation

	public ReadConfig() { // create constructor
		File src = new File("configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("app_url");
		return url;
	}

	public String getUserName() {
		String username = pro.getProperty("user_name");
		return username;
	}

	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}

	public String getChromePath() {
		String chrome_path = pro.getProperty("chromepath");
		return chrome_path;
	}

	public String getIePath() {
		String ie_path = pro.getProperty("iepath");
		return ie_path;
	}

	public String getFireFoxPath() {
		String fire_fox = pro.getProperty("firefoxpath");
		return fire_fox;
	}
}