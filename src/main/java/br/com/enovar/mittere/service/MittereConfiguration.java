package br.com.enovar.mittere.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MittereConfiguration {
	
	private static final String CONFIG_FILE = "mittere.properties";
	
	private static final String KEY_USERNAME = "username";
	
	private static final String KEY_PASSWORD = "password";
	
	private static String username;
	
	private static String password;
	
	static {
		Properties properties = loadProperties();
		String username = properties.getProperty(KEY_USERNAME);
		String password = properties.getProperty(KEY_PASSWORD);
		
		configureWithUsernameAndPassword(username, password);
	}
	
	private static Properties loadProperties() {
		InputStream stream = MittereConfiguration.class
			.getResourceAsStream(CONFIG_FILE);
		
		if (stream == null) {
			stream = MittereConfiguration.class
				.getResourceAsStream("/" + CONFIG_FILE);
		}
		
		Properties properties = new Properties();
		
		try {
			properties.load(stream);
		} catch (IOException exception) {
			throw new PropertiesFileNotFoundException("Properties file not found", exception);
		}
		
		return properties;
	}
	
	public static void configureWithUsernameAndPassword(String username, String password) {
		MittereConfiguration.username = username;
		MittereConfiguration.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
}
