package com.privalia.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.apache.log4j.Logger;

public class Config {
	static final Logger logger = Logger.getLogger(File.class);

	private Config() {
		throw new IllegalStateException("Utility class");
	}

	@MethodInfo(author = "Nilla", revision = 1, comments = "Get config", date = "01/10/2017")
	public static String getValue(String key) throws IOException {
		Properties properties = new Properties();
		String fileName = "config.properties";
		ClassLoader classLoader = Config.class.getClassLoader();
		URL resource = classLoader.getResource(fileName);

		try (FileInputStream fileInputStream = new FileInputStream(resource.getFile())) {
			properties.load(fileInputStream);
			return properties.getProperty(key);
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
}
