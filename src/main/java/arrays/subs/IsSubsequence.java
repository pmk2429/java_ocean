package arrays.subs;

public class IsSubsequence {
    private static boolean isSubsequence(String s, String t) {
        int M = s.length(), N = t.length();
        int i = 0, j = 0;

        while (i < M && j < N) {
            // move both pointers or just the right pointer
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == M;
    }

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
