package strings;

public class MergeStrings {

    private static String interleave(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int i = 0, j = 0;

        StringBuilder result = new StringBuilder();

        while (i < m || j < n) {
            if (i < m) {
                result.append(word1.charAt(i++));
            }
            if (j < n) {
                result.append(word2.charAt(j++));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(interleave("4567", "d"));
        System.out.println(interleave("abc", "xyz"));
        System.out.println(interleave("ab", "pqrs"));
    }
}
