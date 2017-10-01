package com.privalia.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

public class File {

	static final Logger logger = Logger.getLogger(File.class);

	private File() {
		throw new IllegalStateException("Utility class");
	}

	public static void create(String path, String line) throws IOException {
		try (FileWriter fileWriter = new FileWriter(path, true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
			bufferedWriter.write(line);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
}
