package com.privalia.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.apache.log4j.Logger;

public class FileWriterUtil {

	static final Logger logger = Logger.getLogger(FileWriterUtil.class);
	static File file = null;
	
	static {
		
	}

	private FileWriterUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static void write(String path, String line) throws IOException {
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
	
	public static void writeWithNio(String fileName, String line) throws IOException {
		create(fileName);
		Path path = Paths.get(fileName);
		try(BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.APPEND)) {
			writer.write(line);
			writer.newLine();
			writer.flush();
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	public static boolean create (String fileName) throws IOException {
		try {
			boolean hasFileCreated = false;
			File file = new File(fileName);
			if (!file.exists()){
				hasFileCreated = file.createNewFile();
			}
			return hasFileCreated;
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
}
