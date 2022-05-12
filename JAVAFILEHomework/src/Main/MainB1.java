package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MainB1 {
	public static void main(String[] args) throws IOException {
		File file = new File("alo.txt");
		if (!file.exists()) {
			file.createNewFile();
		}

		writeFile(file);
		System.out.print(readFile(file));

		appendFile(file);
		System.out.print(readFile(file));
	}

	private static void writeFile(File file) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		String s = " Hello Trung tam java - file";
		fileOutputStream.write(s.getBytes());
		fileOutputStream.close();
	}

	private static String readFile(File file) throws IOException {
		String s = "";
		FileInputStream fileInputStream = new FileInputStream(file);

		int c = fileInputStream.read();

		while (c != -1) {
			s += (char) c;
			c = fileInputStream.read();
		}

		fileInputStream.close();
		return s;
	}

	private static void appendFile(File file) throws IOException {
		String s = readFile(file) + " I am here.";
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(s);
		fileWriter.close();
	}
}