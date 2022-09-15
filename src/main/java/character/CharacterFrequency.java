package character;

/**
 * DuplicateChars Class is implemented to find the count of each character
 * in a given string.
 * This class uses a simple technique for finding the frequency distribution
 * of each character using a HashMap.
 * The operations performed by this class takes a constant time to evaluate
 * the frequency distribution of each Character in the input String.
 * Finally, TreeMap is used to sort the HashMap in ascending order of the alphabets
 * while printing the characters after the count has been evaluated.
 */

import java.util.*;

public class CharacterFrequency {

    @SuppressWarnings("resource")
    public static void main1(String[] args) {
        System.out.println("Enter the string to count frequency of each characters:");
        System.out.print("> ");
        Scanner input = new Scanner(System.in);
        String inputText = input.nextLine();

        CharacterFrequency dcObj = new CharacterFrequency();
        // Pass the input string as parameter to findDuplicateNumbers()
        Map<Character, Integer> charMap = dcObj.findDuplicateCharacters(inputText);
        // Print the character count of each characters;
        // dcObj.printFrequencyCount(charMap);

        // print specific character from HashMap.
        System.out.println("\nEnter char to know count from above String: ");
        System.out.print("> ");
        input = new Scanner(System.in);
        String ch = input.next();

        int count = charMap.get(ch.charAt(0));
        System.out.println("\nCount-> " + count);

        input.close();
    }

    /**
     * <h1>findDuplicateCharacters(String)</h1>A method that counts the
     * frequency of each character in String. <br />
     * <p>
     * It will take input text String as an argument and uses a HashMap to store
     * the Characters and corresponding count in the HashMap. For each
     * characters, the count in the HashMap is initiated by 1 and after every
     * encounter of the Character in the input string, the count is incremented
     * by 1. By iterating until the end of string or until String length, the
     * HashMap stores all the Characters and its corresponding count.
     * </p>
     *
     * @param inputText
     * @return
     */
    private Map<Character, Integer> findDuplicateCharacters(String inputText) {
        Map<Character, Integer> charMap = new HashMap<>();
        int count = 1;
        for (int i = 0; i < inputText.length(); i++) {
            if (charMap.containsKey(inputText.charAt(i))) {
                charMap.put(inputText.charAt(i), charMap.get(inputText.charAt(i)) + 1);
            }
            else {
                charMap.put(inputText.charAt(i), count);
            }
        }
        return charMap;
    }

    public void printFrequencyCount(Map<Character, Integer> charMap) {

        // Sorting the HashMap by passing HashMap as an argument to TreeMap
        Map<Character, Integer> sortedMap = new TreeMap<Character, Integer>(charMap);
        // Getting the Entry set for each entries in the HashMap.
        Set<?> setMap = sortedMap.entrySet();

        // Applying an Iterator to the entry Set obtained.
        Iterator<?> iter = setMap.iterator();

        System.out.println("\nCharacter \t:\t Count");
        while (iter.hasNext()) {
            // Map.Entry will map all the keys and values together.
            @SuppressWarnings("unchecked")
            Map.Entry<Character, Integer> mapCharacters = (Map.Entry<Character, Integer>) iter.next();
            System.out.println(mapCharacters.getKey() + "\t\t:\t\t" + mapCharacters.getValue());
        }
    }

    // Capital case characters
    private static void charFrequency(String str) {
        char[] allChars = str.toCharArray();
        int[] charFreq = new int[256];

        for (char c : allChars) {
            charFreq[c]++;
        }

        Arrays.stream(charFreq).filter(i -> i > 0).forEach(System.out::println);
    }

    public static void main(String[] args) {
        String pavitra = "pavitra";
        charFrequency(pavitra);
    }
}
