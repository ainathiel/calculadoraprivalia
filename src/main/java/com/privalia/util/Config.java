package com.privalia.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.apache.log4j.Logger;

public class Config {
	static final Logger logger = Logger.getLogger(FileWriterUtil.class);
	static Properties properties = null;

	static {
		properties = new Properties();
		String fileName = "config.properties";
		ClassLoader classLoader = Config.class.getClassLoader();
		URL resource = classLoader.getResource(fileName);
		try (FileInputStream fileInputStream = new FileInputStream(resource.getFile())) {
			properties.load(fileInputStream);
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}

	private Config() {
		throw new IllegalStateException("Utility class");
	}

	public static String getValue(String key) {
		return properties.getProperty(key);
	}
}
