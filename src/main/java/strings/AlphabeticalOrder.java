package strings;

public class AlphabeticalOrder {
    private static boolean isAlphabeticalOrder(String s) {
        int n = s.length();

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
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
