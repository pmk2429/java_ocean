package encoding;

/**
 * 
 * FileReader for text files in your system’s default encoding (for example, 
 * files containing Western European characters on a Western European computer).
 * FileInputStream for binary files and text files that contain ‘weird’ characters.
 * 
 * If you want to read a binary file, or a text file containing ‘weird’ characters 
 * (ones that your system doesn’t deal with by default), you need to use 
 * FileInputStream instead of FileReader. Instead of wrapping FileInputStream 
 * in a buffer, FileInputStream defines a method called read() that lets you fill 
 * a buffer with data, automatically reading just enough bytes to fill the buffer 
 * (or less if there aren’t that many bytes left to read).
 */

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class BinaryData {
	public static void main(String[] args) {
		BinaryData binaryObj = new BinaryData();
		if (args.length == 0) {
			System.out.println("Input file not found");
		}
		if (args.length > 0) {
			String inputFile = args[0];
			//binaryObj.readBinaryDataFromFile(inputFile);
			//binaryObj.readBinaryData(inputFile);
			binaryObj.stringToBinary();
		}
	}

	// IMP function
	private void stringToBinary() {
		String s = "";
		byte[] bytes = s.getBytes();
		StringBuilder binary = new StringBuilder();
		for (byte b : bytes) {
			int val = b;
			for (int i = 0; i < 8; i++) {
				binary.append((val & 128) == 0 ? 0 : 1);
				val <<= 1;
			}
			binary.append(' ');
		}
		System.out.println("'" + s + "' to binary: " + binary);

	}

	private void readBinaryDataFromFile(String inputFile) {
		try {
			String binaryData = "";
			FileInputStream fileinputstream = new FileInputStream(inputFile);
			FileWriter fileWritter = new FileWriter("HTML.txt", true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);

			int total = 0;
			int nRead = 0;
			int numberBytes = fileinputstream.available();
			byte bytearray[] = new byte[numberBytes];

			while ((nRead = fileinputstream.read(bytearray)) != -1) {
				binaryData = new String(bytearray);
				// System.out.println(new String(bytearray));
				total += nRead;
			}

			bufferWritter.write(binaryData);

			fileinputstream.close();
			bufferWritter.close();
			// System.out.println("Read " + total + " bytes");
			System.out.println("Done");

		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private void readBinaryData(String inputFile) {
		try {
			String result = "";
			for (int i = 0; i < inputFile.length(); i += 8) {
				result += (char) Integer.parseInt(
						inputFile.substring(i, i + 8), 2);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
