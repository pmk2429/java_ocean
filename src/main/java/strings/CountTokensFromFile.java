package strings;

/**
 * CountTokensFromFile.java program is used to count the number of characters,
 * words and lines in a particular String or file.
 * When this class is called, it returns the count of all the three types.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CountTokensFromFile {
    public static void main(String[] args) {
        if (args.length <= 0) {
            System.out.println("File not found");
        }
        else {
            countTokens(args[0]);
        }
    }

    private static void countTokens(String file) {
        try {
            int characterCount = 0, wordCount = 0, lineCount = 0;
            String line = "";
            File inputFile = new File(file);
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if (Character.isLetterOrDigit(ch)) {
                        ++characterCount;
                    }
                    if (Character.isWhitespace(ch)) {
                        ++wordCount;
                    }
                }
                ++lineCount;
            }
            System.out.println("Characters: " + characterCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Lines: " + lineCount);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
