package arrays.subs;

public class IsSubsequence {
    private static boolean isSubsequence(String s, String t) {
        int M = s.length(), N = t.length();
        int i = 0, j = 0;

        while (i < M && j < N) {
            // move both pointers or just the right pointer
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == N;
    }

    public static void main(String[] args) {
        String s = "ahbgdc", t = "abc";
        System.out.println(isSubsequence(s, t));
    }
}
