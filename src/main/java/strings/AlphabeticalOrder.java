package strings;

public class AlphabeticalOrder {
    private static boolean isAlphabeticalOrder(String s) {
        int n = s.length();

        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) > s.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String pmk = "pavitra";
        System.out.println(isAlphabeticalOrder(pmk));
    }
}
