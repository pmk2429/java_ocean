package strings;

import java.util.HashSet;
import java.util.Set;

public class AllVowels {

    private static boolean containsAllVowels(String str) {
        boolean containsAllVowels;

        Set<Character> vowels = new HashSet<>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};

        int vowelSize = vowels.size();
        int found = 0;
        for (char c : str.toCharArray()) {
            if (vowels.remove(c)) {
                found++;
            }
        }

        containsAllVowels = found == vowelSize;

        return containsAllVowels;
    }

    public static void main(String[] args) {
        System.out.println(containsAllVowels("Pavitra"));
        System.out.println(containsAllVowels("Sequoia"));
    }
}
