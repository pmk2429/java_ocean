package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavitra on 5/7/2016.
 */
public class PowerSet {
    static String str = "abc"; //our string
    static List<String> powerSet = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < str.length(); i++) { //traverse through all characters
            subsets("", i);
        }

        powerSet.add("{ }");

        System.out.println(powerSet.size());
        for (int i = 0; i < powerSet.size(); i++) {
            System.out.println(powerSet.get(i));
        }
    }

    /**
     * Recursively calls the functions by retaining the current element
     *
     * @param newSubstring
     * @param index
     */
    static List<String> subsets(String newSubstring, int index) {
        String temp = "" + str.charAt(index); //very important, create a variable on each stack
        temp = newSubstring + temp; //append the subset so far
        //System.out.println(temp); //print
        powerSet.add(temp);

        /**
         * For all the indexes from index+1...length build recursive subsets
         */
        for (int i = index + 1; i < str.length(); i++)
            subsets(temp, i); //call recursively

        return powerSet;
    }
}
