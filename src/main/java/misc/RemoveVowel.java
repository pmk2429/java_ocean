package misc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveVowel {

    static String remVowel(String str) {
        Character[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> set = new HashSet<>(Arrays.asList(vowels));
        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < sb.length(); i++) {
            if (set.contains(sb.charAt(i))) {
                sb.replace(i, i + 1, "");
                i--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "Square - A FinTech Company for digital age";
        System.out.println(remVowel(str));
    }
}
