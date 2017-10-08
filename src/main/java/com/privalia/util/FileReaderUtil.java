package com.privalia.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class FileReaderUtil {
	static final Logger logger = Logger.getLogger(FileWriterUtil.class);

	private FileReaderUtil() {

	}

	public static List<String> readWithNioUsingNewByteChannel(String fileName) throws IOException {
		List<String> lines = new ArrayList<>();
		Path path = Paths.get(fileName);
		try (SeekableByteChannel byteChannel = Files.newByteChannel(path);) {
			ByteBuffer byteBuffer = ByteBuffer.allocate(512);
			Charset charset = Charset.forName("UTF-8");
			while (byteChannel.read(byteBuffer) > 0) {
				byteBuffer.rewind();
				lines.add(charset.decode(byteBuffer).toString());
				byteBuffer.flip();
			}
		}
		return lines;
	}

	public static List<String> readWithNio(String fileName) throws IOException {
		List<String> lines = new ArrayList<>();

		try (RandomAccessFile file = new RandomAccessFile(fileName, "rw");
				FileChannel fileChannel = file.getChannel();) {
			ByteBuffer byteBuffer = ByteBuffer.allocate(512);
			StringBuilder line = new StringBuilder();

			while (fileChannel.read(byteBuffer) > 0) {
				byteBuffer.flip();
				for (int i = 0; i < byteBuffer.limit(); i++) {
					char ch = ((char) byteBuffer.get());
					if (ch == '\n') {
						String stringLine = line.toString();
						lines.add(stringLine);
						line = new StringBuilder();
					} else {
						line.append(ch);
					}
				}
				byteBuffer.clear();
			}
			return lines;
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	public static String read(String fileName) throws IOException {
		String line = null;
		try (FileReader fileReader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(fileReader);) {
			line = bufferedReader.readLine();
		}

		return line;
	}
}
