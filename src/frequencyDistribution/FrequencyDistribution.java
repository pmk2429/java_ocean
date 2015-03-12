package frequencyDistribution;

/**
 * FrequencyDistribution class finds the frequency of each character in the 
 * text input file or the input string.
 * It deploys a readFromFile() method which reads the input text from the file
 * and then after reading the text from file, it will pass the input text
 * to the method in order to find the frequency for the file.
 * 
 * The findFrequency() method uses a HashMap<Character,Integer> in order to 
 * distribute all the letters read from file or input and then stores all 
 * of them into HashMap as they are encountered in the input text.
 * As each character is encountered, the corresponding Integer count value 
 * is initiated with 1 count and incremented for every encounter of the
 * same character in the text.
 */

import java.util.*;
import java.io.*;

public class FrequencyDistribution {

	static FrequencyDistribution fd = new FrequencyDistribution();
	public HashMap<Character, Integer> charactersMap = new HashMap<Character, Integer>();
	LinkedList<CharactersList> charactersList = new LinkedList<CharactersList>();
	CharactersList cl = new CharactersList();
	int existingCharacterCount;
	public static boolean check;

	public static void main(String[] args) {
		boolean EOP = false;
		Scanner input = null, inputText = null;
		int flag;
		try {
			while (!EOP) {
				System.out
						.println("Enter your choice of input for Counting Frequency Distribution: \n1) file.\n2) text.");
				System.out.print("> ");
				input = new Scanner(System.in);
				String inputChoice = input.next();
				if (inputChoice.equals("file")) {
					if (args.length < 0) {
						System.out.println("Input FILE not found!!!");
					} else {
						String textFromFile = readFromFile(args[0]);
						// Pass the input text to the method to calculate
						// frequency.
						fd.findFrequency(textFromFile, 1);
					}
				} else if (inputChoice.equals("text")) {
					System.out.println("\nEnter text to process: \n> ");
					inputText = new Scanner(System.in);
					// Read the input text from the file and pass it onto
					// findfrequency method.
					String textFromInput = inputText.nextLine();
					fd.findFrequency(textFromInput, 2);
				} else {
					System.out
							.println("\nSorry! Invalid input. Please try again!!!");
					System.out.println("> ");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			EOP = true;
		} finally {
			try {
				input.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// Method to read text from input file.
	private static String readFromFile(String file) {
		String textFromFile = "";
		try {
			File inputFromFile = new File(file);
			BufferedReader br = new BufferedReader(
					new FileReader(inputFromFile));

			// Keep reading from file intil EOF is reached in the file!
			String line = "";
			while ((line = br.readLine()) != null) {
				textFromFile += line;
			}
			// when reading from file is finished, close the reader to
			// deallocate memory
			br.close();

			return textFromFile;
		} catch (IOException ioex) {
			System.out.println(ioex.getMessage());
			ioex.printStackTrace();
		} catch (Exception e) {
			System.out.println("An error occured with file!!!");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Using a HashMap to count the frequency of number of characters makes it
	 * more Time efficient of the order of O(1).
	 * 
	 * @param text
	 */
	public void findFrequency(String text, int flag) {
		int choice = flag;
		cl.initcharactersMap();
		int count = 0;
		charactersMap = CharactersList.charactersMap;
		int countSame = 0;

		// Loop through entire TEXT(file) until end.
		for (int i = 0; i < text.length(); i++) {

			// Compare the encountered char to the char in HashMap
			if (charactersMap.containsKey(text.charAt(i))) {

				// Check if the letter now encountered is already added to
				// LinkedList or not.
				if (this.checkCharacterAvailability(text.charAt(i))) {
					/**
					 * If the encountered char is available in the list, then
					 * get its count.
					 */
					countSame = getExistingCharacterCount();

					System.out.println("Count for " + text.charAt(i) + ": "
							+ countSame);

				} else {
					charactersList.add(new CharactersList(text.charAt(i),
							++count));
					// print test:
					// System.out.println(charactersList.size());
					System.out.println("Count for " + text.charAt(i) + ": "
							+ charactersList.getLast().getFrequencyCount());
					count = 0;
				}
			} else {
				System.out.println("Character Not foud");
			}
		}

		// End of loop which iterates through the entire text input!
		this.printFrequencyOfCharacters(charactersList, choice);

	}

	/**
	 * Method to print the entire FREQUENCY Count of Characters
	 * 
	 * Process the PRINT function as per the flag displayed! if(choice == 1)
	 * //which is input from FILE ---------> then output print to FILE else
	 * //which is text input ---------> then print on console.
	 * 
	 * @param charactersList
	 */
	public void printFrequencyOfCharacters(
			LinkedList<CharactersList> charactersList, int flag) {
		LinkedList<CharactersList> displayList = charactersList;
		int choice = flag;
	}

	// special case to check if the LinkedList contains Character or not!
	public boolean checkCharacterAvailability(char checkCharacter) {
		for (int i = 0; i < charactersList.size(); i++) {
			if (charactersList.get(i).getCharacterRead() == checkCharacter) {
				check = true;
				charactersList.get(i).setFrequencyCount(
						charactersList.get(i).getFrequencyCount() + 1);
				int countChar = charactersList.get(i).getFrequencyCount();
				setExistingCharactercount(countChar);
				break;
			} else {
				check = false;
			}
		}
		return check;
	}

	public void setExistingCharactercount(int count) {
		existingCharacterCount = count;
	}

	public int getExistingCharacterCount() {
		return existingCharacterCount;
	}

	/**
	 * This method returns the count of the character inserted at last by
	 * looping through the linked list and getting the last char.
	 * 
	 * @param count
	 * @return
	 */
	/*
	 * public int getLatestCharCount(char latestCharacter){ char character =
	 * latestCharacter;
	 * 
	 * }
	 */

	/*
	 * another method to process char by char from String
	 * 
	 * public scanEachChar(String text){ int arraySize = text.length(); char
	 * []charToRead = new char[arraySize];
	 * 
	 * Looping through entire text gets once Character per iteration. for(int
	 * i=0; i<text.length(); i++){ charToRead[i] = text.charAt(i); } for(int
	 * j=0; j<arraySize; j++){ System.out.println(charToRead[j].toString()); } }
	 */
}
