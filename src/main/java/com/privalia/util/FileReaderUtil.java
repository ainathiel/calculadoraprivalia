package com.privalia.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;

public class FileReaderUtil {
	static final Logger logger = Logger.getLogger(FileWriterUtil.class);

	private FileReaderUtil() {

	}

	public static CharBuffer readWithNio(String fileName) throws IOException {
		CharBuffer line = null;
		Path path = Paths.get(fileName);
		try (SeekableByteChannel byteChannel = Files.newByteChannel(path);) {
			ByteBuffer byteBuffer = ByteBuffer.allocate(100);			
			Charset charset = Charset.forName("US-ASCII");
			while (byteChannel.read(byteBuffer) > 0) {
				byteBuffer.rewind();
				line = charset.decode(byteBuffer);
				byteBuffer.flip();
			}
		}
		return line;
	}
	
	public static String read(String fileName) throws IOException {
		String line = null;
		try(FileReader fileReader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(fileReader);) {
			line = bufferedReader.readLine();
		}
		
		return line;
	}
}
