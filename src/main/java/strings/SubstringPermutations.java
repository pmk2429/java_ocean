package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find all unique letter combinations within the word �digital� that are 3 letters or more.
 * <p>
 * This program will find all possible subsets of a Particular String and then will find all possible permutations
 * of a each substring
 * <p>
 * Created by Pavitra on 11/12/2015.
 */
public class SubstringPermutations {

    public List<String> getSubstrings(String originalString, int sizeOfSubString) {
        String subString;
        int i, c, length;
        List<String> listOfSubstrings = new ArrayList<>();

        length = originalString.length();

        for (c = 0; c < length; c++) {
            for (i = 1; i <= length - c; i++) {
                if (i >= sizeOfSubString) {
                    subString = originalString.substring(c, c + i);
                    listOfSubstrings.add(subString);
                }
            }
        }
        return listOfSubstrings;
    }

    /**
     * Method to get Permutations of a Given String
     *
     * @param str
     * @return
     */
    public Set<String> stringPermutation(String str) {
        // HashSet doesn't allow duplicates and so adding duplicate value to it will not be inserted at all.
        Set<String> result = new HashSet<>();

        // possible checks
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            result.add("");
            return result;
        }


        //MAIN LOGIC FOR PERMUTATION

        // get the First char of the String.
        char firstChar = str.charAt(0);
        // get the remainder String and do the permutation. By passing '1' returns the remainder String.
        String rem = str.substring(1);
        // store the result in Set to avoid duplicate String.
        Set<String> words = stringPermutation(rem);
        // loop through the Set and add the first char to each String to produce all possible permutations.
        // KEEP LOOPING
        for (String newString : words) {
            for (int i = 0; i <= newString.length(); i++) {
                result.add(addChar(newString, firstChar, i));
            }
        }
        return result;

    }

    /**
     * Method to add a char to a given String.
     *
     * @param str
     * @param c
     * @param j
     * @return
     */
    public static String addChar(String str, char c, int j) {
        String first = str.substring(0, j);
        String last = str.substring(j);
        return first + c + last;
    }


    // main point of execution
    public static void main(String[] args) {
        // get all Substring of size greater than 3. -> HARD CODED. can be made dynamic.
        List<String> substrings = new SubstringPermutations().getSubstrings("digital", 3);

        Set<String> temp = new HashSet<>();
        Set<String> uniqueCombinationStrings = new HashSet<>();

        // once you get all the Substrings, simple get the permutations of Each SubString
        for (int i = 0; i < substrings.size(); i++) {
            // get permutations for corresponding substring.
            temp = new SubstringPermutations().stringPermutation(substrings.get(i));
//            // finally add all element of LongestContinuousNumber set to the uniqueCombinationStrings Set.
            uniqueCombinationStrings.addAll(temp);

//            System.out.println(substrings.get(i));
        }

        System.out.println(uniqueCombinationStrings.size());
        System.out.println(uniqueCombinationStrings);
    }

}