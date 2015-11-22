package file;

/**
 * PatternMatch class is used to match categories of data from one file
 * and match with data in another file.
 */

import java.util.*;
import java.io.*;

public class PatternMatch {
	public static void main(String[] args) {
		PatternMatch patternObj = new PatternMatch();
		Map<String, String> mapEntry = new HashMap<String, String>();
		Map<String, Integer> mapCount = new HashMap<String, Integer>();
		String inputFile1 = "", inputFile2 = "";
		if (args[0].length() == 0) {
			System.out.println("Input File 1 not found!!!");
		} else if (args[1].length() == 0) {
			System.out.println("Input File 2 not found!!!");
		} else {
			if (args[1].length() > 0 && args[1].length() > 0) {
				inputFile1 = args[0];
				inputFile2 = args[1];
				mapEntry = patternObj.readFromKeyFile(inputFile1);
				mapCount = patternObj.compareKeysWithDataFile(mapEntry,
						inputFile2);
				boolean output = patternObj.printMatchPatternToFile(mapCount);
				// patternObj.printMatchPattern(mapCount);
				if (output == true) {
					System.out
							.println("Matched Data written to file successfully!!!");
				} else {
					System.out
							.println("Error ===> Writing mapped data to output file!!!");
				}
			}

		}
	}

	/**
	 * This method receives mapCount which contains all the matching lines and
	 * its keys as Key-Value pairs and will print each map entry to the output
	 * file.
	 * 
	 * @param mapCount
	 * @return
	 */
	private boolean printMatchPatternToFile(Map<String, Integer> mapOfEntries) {
		System.out.println("Writing mapped entries to output file...\n");
		boolean outputToFile = false;
		FileWriter fileWriterObj = null;
		try {
			File file = new File("firstfilename_CSI.out");
			fileWriterObj = new FileWriter(file);
			if (!file.exists()) {
				file.createNewFile();
			}
			Set setMap = mapOfEntries.entrySet();
			Iterator iter = setMap.iterator();
			while (iter.hasNext()) {
				Map.Entry<String, Integer> entryMap = (Map.Entry) iter.next();
				// print each entry in Map to output file
				fileWriterObj.write(entryMap.getKey() + " : "
						+ entryMap.getValue());
				fileWriterObj.write("\n");
			}
			outputToFile = true;
		} catch (IOException e) {
			outputToFile = false;
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fileWriterObj != null) {
					fileWriterObj.close();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return outputToFile;
	}

	/**
	 * Test method to check the Map entries
	 * 
	 * @param mapCount
	 */
	private void printMatchPattern(Map<String, Integer> mapCount) {
		Set set = mapCount.entrySet();
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			Map.Entry entryMap = (Map.Entry) iter.next();
			System.out.println(entryMap.getKey() + " : " + entryMap.getValue());
		}
	}

	/**
	 * Method to read from the First file and build a Map of entries containing
	 * entire file and the categoryKey values which will be compared with all
	 * the Entries in sample file.
	 * 
	 * @param inputFile1
	 * @return
	 */
	public Map<String, String> readFromKeyFile(String inputFile1) {
		System.out.println("Reading Data from Main input file...\n");
		PatternMatch patternObj = new PatternMatch();
		/**
		 * mapEntries contains all the entries of category and its corresponding
		 * Lines from file
		 */
		Map<String, String> mapEntries = new HashMap<String, String>();

		File file1 = new File(inputFile1);
		BufferedReader br = null;
		int count = 1;
		String line = "", categoryKey = "";
		try {
			br = new BufferedReader(new FileReader(file1));
			while ((line = br.readLine()) != null) {
				// get the category.xxxxxxxx string for each line.
				categoryKey = patternObj.getCategoryKey(line);
				mapEntries.put(categoryKey, line);
			}
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
		// finally retunr mapEntries map object.
		return mapEntries;
	}

	/**
	 * This method splits the entire line into a Strinfg array and then returns
	 * the categoryB.xxxxxxx substring for each line.
	 * 
	 * @param line
	 * @return
	 */
	public String getCategoryKey(String line) {
		if (line != null) {
			String[] categoryKey = line.split(" ");
			return categoryKey[2];
		} else {
			return null;
		}

	}

	/**
	 * This method receives mapEntries as an argument and for each entry Key in
	 * the mapEntry Map, it will check for all the corresponding entries in the
	 * sample file. If a match is found then a new map is created which will
	 * store the number(key) before comma in the sample line as value and entire
	 * line from the 1st file as Key.
	 * 
	 * @param mapEntry
	 * @param inputFile2
	 * @return mapEntries which will have key(number before comma) as value and
	 *         entire line from first file.
	 */
	public Map<String, Integer> compareKeysWithDataFile(
			Map<String, String> mapEntry, String inputFile2) {
		System.out
				.println("Comparing categoryB.xxxxxx with sample Data file...\n");
		Map<String, Integer> mapMatchedEntries = new HashMap<String, Integer>();
		File file2 = new File(inputFile2);
		BufferedReader br = null;
		String line = "", keyMatch = "";
		int key = 0;
		try {
			br = new BufferedReader(new FileReader(file2));
			while ((line = br.readLine()) != null) {
				keyMatch = line.substring(2, line.length());
				key = Integer.parseInt(line.substring(0, 1));
				if (mapEntry.containsKey(keyMatch)) {
					mapMatchedEntries.put(mapEntry.get(keyMatch), key);
				}
			}
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
		return mapMatchedEntries;
	}
}
