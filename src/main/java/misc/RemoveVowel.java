package misc;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveVowel {

    static String remVowel(String str) {
        Character[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> set = Arrays.stream(vowels).collect(Collectors.toSet());
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
        String str = "PayPal - A FinTech Company for digital age";
        System.out.println(remVowel(str));
    }
}
