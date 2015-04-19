package input_output;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class StdIn {

	// no need to instantiate this class.
	private StdIn() {
	}

	private static Scanner scanner;

	// assume Unicode UTF-8 encoding
	private static final String CHARSET_NAME = "UTF_8";

	// assuming language = English
	private static final Locale LOCALE = Locale.US;

	// the default token separator; we maintain the invariant that this value is
	// held by scanner's delimiter between calls
	private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

	// makes whitespace chars significant
	private static final Pattern EMPTY_PATTERN = Pattern.compile("");

	// entire input
	private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");

	public static boolean isEmpty() {
		return !scanner.hasNext();
	}

	public static boolean hasNextLine() {
		return scanner.hasNextLine();
	}

	public static boolean hasNextChar() {
		scanner.useDelimiter(EMPTY_PATTERN);
		boolean result = scanner.hasNext();
		scanner.useDelimiter(WHITESPACE_PATTERN);
		return result;
	}

	public static String readLine() {
		String line;
		try {
			line = scanner.nextLine();
		} catch (Exception e) {
			line = null;
		}
		return line;
	}

	public static char readChar() {
		scanner.useDelimiter(EMPTY_PATTERN);
		String ch = scanner.next();
		assert (ch.length() == 1) : "Internal (Std)In.readChar() error!" + " Please check API";
		scanner.useDelimiter(WHITESPACE_PATTERN);
		return ch.charAt(0);
	}

	/**
	 * Reads and returns the remainder of the input, as a string.
	 * 
	 * @return the remainder of the input, as a string
	 */
	public static String readAll() {
		if (!scanner.hasNextLine()) {
			return "";
		}
		String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
		scanner.useDelimiter(WHITESPACE_PATTERN); // but let's do it anyway
		return result;
	}

	public static String readString() {
		return scanner.next();
	}

	/**
	 * 
	 * <h1>readInt()</h1>Reads the next token from standard input, parses it as
	 * an integer, and returns the integer.
	 * <p>
	 * </p>
	 * 
	 * @return the next integer on standard input
	 * @throws InputMismatchException
	 *             if the next token cannot be parsed as an <tt>int</tt>
	 */
	public static int readInt() {
		return scanner.nextInt();
	}

	/**
	 * <h1>readDouble()</h1>Reads the next token from standard input, parses it
	 * as a double, and returns the double.
	 * 
	 * @return the next double on standard input
	 * @throws InputMismatchException
	 *             if the next token cannot be parsed as a <tt>double</tt>
	 */
	public static double readDouble() {
		return scanner.nextDouble();
	}

	/**
	 * <h1>readFloat()</h1>Reads the next token from standard input, parses it
	 * as a float, and returns the float.
	 * 
	 * @return the next float on standard input
	 * @throws InputMismatchException
	 *             if the next token cannot be parsed as a <tt>float</tt>
	 */
	public static float readFloat() {
		return scanner.nextFloat();
	}

	/**
	 * <h1>readLong()</h1>Reads the next token from standard input, parses it as
	 * a long integer, and returns the long integer.
	 * 
	 * @return the next long integer on standard input
	 * @throws InputMismatchException
	 *             if the next token cannot be parsed as a <tt>long</tt>
	 */
	public static long readLong() {
		return scanner.nextLong();
	}

	/**
	 * <h1>readShort()</h1>Reads the next token from standard input, parses it
	 * as a short integer, and returns the short integer.
	 * 
	 * @return the next short integer on standard input
	 * @throws InputMismatchException
	 *             if the next token cannot be parsed as a <tt>short</tt>
	 */
	public static short readShort() {
		return scanner.nextShort();
	}

	/**
	 * <h1>readByte()</h1>Reads the next token from standard input, parses it as
	 * a byte, and returns the byte.
	 * 
	 * @return the next byte on standard input
	 * @throws InputMismatchException
	 *             if the next token cannot be parsed as a <tt>byte</tt>
	 */
	public static byte readByte() {
		return scanner.nextByte();
	}

	/**
	 * Reads the next token from standard input, parses it as a boolean, and
	 * returns the boolean.
	 * 
	 * @return the next boolean on standard input
	 * @throws InputMismatchException
	 *             if the next token cannot be parsed as a <tt>boolean</tt>:
	 *             <tt>true</tt> or <tt>1</tt> for true, and <tt>false</tt> or
	 *             <tt>0</tt> for false, ignoring case
	 */
	public static boolean readBoolean() {
		String s = readString();
		if (s.equalsIgnoreCase("true"))
			return true;
		if (s.equalsIgnoreCase("false"))
			return false;
		if (s.equals("1"))
			return true;
		if (s.equals("0"))
			return false;
		throw new InputMismatchException();
	}

	/**
	 * Reads all remaining tokens from standard input and returns them as an
	 * array of strings.
	 * 
	 * @return all remaining tokens on standard input, as an array of strings
	 */
	public static String[] readAllStrings() {
		// we could use readAll.trim().split(), but that's not consistent
		// because trim() uses characters 0x00..0x20 as whitespace
		String[] tokens = WHITESPACE_PATTERN.split(readAll());
		if (tokens.length == 0 || tokens[0].length() > 0)
			return tokens;

		// don't include first token if it is leading whitespace
		String[] decapitokens = new String[tokens.length - 1];
		for (int i = 0; i < tokens.length - 1; i++)
			decapitokens[i] = tokens[i + 1];
		return decapitokens;
	}

}
