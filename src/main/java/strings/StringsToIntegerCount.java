package strings;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * String text = "1,2,3,4,1,2,3,4,1,2,3,4,1,2";
 */
public class StringsToIntegerCount {

    private static Map<Integer, Integer> getFrequency(String str) {
        if (str == null) return null;
        // split the String into numbers using ',' delimiter
        String[] numString = str.trim().split(",");

        // LinkedHashMap to maintain the insertion order of elements (as requirement given in question)
        Map<Integer, Integer> numFreq = new LinkedHashMap<>();

        // loop through the numString array which is a String array and then parse it one by one
        for (String s : numString) {
            Integer currNum = Integer.parseInt(s);
            // if the num is already in the Map, increment the count, else add it to Map
            numFreq.put(currNum, numFreq.getOrDefault(currNum, 0) + 1);
        }

        return numFreq;
    }

    private static void printNumberFrequency(Map<Integer, Integer> numFreqMap) {
        numFreqMap.forEach((key, value) -> System.out.println(key + " is present " + value + " times"));
    }

    public static void main(String[] args) {
        String text = "1,2,3,4,1,2,3,4,1,2,3,4,1,2";
        Map<Integer, Integer> freqMap = getFrequency(text);
        printNumberFrequency(freqMap);
    }
}
