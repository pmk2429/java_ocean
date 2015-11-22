package frequencyDistribution;

/**
 * WordFrequency class is used to find the max repeated words from a file
 * 
 */

import java.util.*;
import java.io.*;

import pattern.*;

public class WordFrequency {

	public static void main(String[] args) {
		Scanner input = null, inputString = null;
		boolean EOP = false;
		WordFrequency wordObj = new WordFrequency();
		try {
			while (!EOP) {
				System.out
						.println("Enter your choice to find repeated words from:");
				System.out.println("1) File\n2) Text");
				System.out.print("> ");
				input = new Scanner(System.in);
				String inputChoice = input.next();

				if (inputChoice.equals("file") || inputChoice.equals("File")) {
					if (args.length == 0) {
						System.out.println("Input file not found");
					} else if (args.length > 0) {
						String inputFile = args[0];
						Map<String, Integer> mapWords = new HashMap<String, Integer>();

						// Get the maximum word count for a word in a file.
						mapWords = wordObj
								.calculateMaxRepeatedWordsFromFile(inputFile);
						wordObj.printMaxWord(mapWords);
						// input.close();
					}
				} else if (inputChoice.equals("text")
						|| inputChoice.equals("Text")) {
					System.out
							.println("\nEnter the string to find the max repeated words:");
					System.out.print("> ");
					inputString = new Scanner(System.in);
					String inputWords = inputString.nextLine();
					Map<String, Integer> wordMap = new HashMap<String, Integer>();
					wordMap = wordObj
							.calculateMaxRepeatedWordsFromText(inputWords);
					wordObj.printMaxWord(wordMap);
				} else {
					System.out
							.println("-------------------------------------------------");
					System.out
							.println("Enter your choice to find repeated words from:");
					System.out.println("1) File\n2) Text");
					System.out.print("> ");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			EOP = true;
		} finally {
			try {
				input.close();
				inputString.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// method to find maximum repeated words from a String or Text.
	public Map<String, Integer> calculateMaxRepeatedWordsFromText(
			String inputString) {
		PatternMatchDemo patternObj = new PatternMatchDemo();
		int maxCount = 0;
		String maxWord = "";
		Map<String, Integer> mapData = new HashMap<String, Integer>();
		Map<String, Integer> mapWord = new HashMap<String, Integer>();
		String[] words = patternObj.splitStringToWords(inputString);
		try {
			int count = 1;
			for (int i = 0; i < words.length; i++) {
				if (mapData.containsKey(words[i])) {
					mapData.put(words[i], mapData.get(words[i]) + 1);
				} else {
					mapData.put(words[i], count);
				}
			}
			maxCount = Collections.max(mapData.values());
			Iterator<Map.Entry<String, Integer>> iterator = mapData.entrySet()
					.iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, Integer> entry = iterator.next();
				if (entry.getValue().equals(maxCount)) {
					maxWord = entry.getKey();
				}
			}
			mapWord.put(maxWord, maxCount);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return mapWord;
	}

	private void printMaxWord(Map<String, Integer> mapWords) {
		Iterator<Map.Entry<String, Integer>> iterator = mapWords.entrySet()
				.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			System.out.println("\n---> Word '" + entry.getKey() + "' appeared "
					+ entry.getValue() + " times in the file <---\n");
		}
	}

	/**
	 * calculateMaxRepeatedWordsFromFile() method takes an input File as a
	 * parameter and reads each line of the file in order to find the maximum
	 * word count for all the words present in the file.
	 * 
	 * The method first checks whether the input file is proper or not. If file
	 * is proper, then it will revoke the I/O stream for processing each line in
	 * file and each word in the line.
	 * 
	 * Then after, a Map is defined which checks whether the word just read is
	 * contained in the Map or not. If the Map contains the just read word from
	 * file then it will put that word in Map with an incremented counter for
	 * the count every time word is encountered in file. If the word does not
	 * exist in the Map then it will simply put the word in the Map with the
	 * counter equals 1 for each new word encountered while reading file.
	 * 
	 * @param inputFile
	 * @return
	 */
	public Map<String, Integer> calculateMaxRepeatedWordsFromFile(
			String inputFile) {
		PatternMatchDemo patternObj = new PatternMatchDemo();
		int maxCount = 0;
		String maxWord = "";
		BufferedReader br = null;
		String[] arrayWords = null;
		Map<String, Integer> mapData = new HashMap<String, Integer>();
		Map<String, Integer> mapWord = new HashMap<String, Integer>();
		try {
			String words = "", line = "", allData = "";
			int count = 1;
			File textFile = new File(inputFile);
			br = new BufferedReader(new FileReader(textFile));
			// Read each line from a file
			while ((line = br.readLine()) != null) {
				// Make a String for entire data in the file.
				// Note--> String data variable will contain all types of data.
				allData += line + " ";
			}
			/**
			 * Now, entire data of words will be converted in to corresponding
			 * Array of String using Pattern.split(regex) method of Pattern
			 * class.
			 * 
			 * splitStringToWords(String) method is defined in the
			 * PatternMatcherDemo class which checks for the Regex containing
			 * only the words.
			 */

			arrayWords = patternObj.splitStringToWords(allData);

			// Loop through the entire String array until its length
			// and for each loop check its availability in HashMap.
			for (int i = 0; i < arrayWords.length; i++) {
				if (mapData.containsKey(arrayWords[i])) {
					mapData.put(arrayWords[i], mapData.get(arrayWords[i]) + 1);
				} else {
					mapData.put(arrayWords[i], count);
				}
			}
			/**
			 * Collections.max(map) is used to find the maximum count for the
			 * Map variable depending on its value or its key defined as
			 * parameter in the max() method. It will return an int value for
			 * the highest count and will be used to get the key of the
			 * corresponding values in HashMap.
			 */
			maxCount = Collections.max(mapData.values());
			Iterator<Map.Entry<String, Integer>> iterator = mapData.entrySet()
					.iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, Integer> entry = iterator.next();
				// check for the key in the HashMap.
				if (entry.getValue().equals(maxCount)) {
					maxWord = entry.getKey();
				}
			}
			// Finally, store the value in the new HashMap variable and return
			// it.f
			mapWord.put(maxWord, maxCount);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return mapWord;
	}
}
