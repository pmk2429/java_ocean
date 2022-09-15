package strings;

public class StringOperations {
    public static void main(String[] args) {
        System.out.println("Output for replaceAllChar(): "
            + repalceAllChar("pavitra mukund kansara", "a", "*"));
        System.out.println("Output for deleteAllNonDigit(): "
            + deleteAllNonDigit("#21sadfs23$&%^(!9@!"));
        System.out.println("Output for replaceCharAt(): "
            + replaceCharAt("Amazon Google Apple Salesforce", 10, '$'));
        System.out.println("Output for removeChar(): "
            + removeChar("Amazon Google Apple Salesforce", 'a'));
        System.out.println("Output for removeCharAt(): "
            + removeCharAt("Amazon Google Apple Salesforce", 5));
    }

    private static String removeCharAt(String s, int i) {
        return s.substring(0, i) + s.substring(i + 1);
    }

    private static String removeChar(String s, char c) {
        StringBuilder buf = new StringBuilder(s);
        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur != c)
                buf.setCharAt(current++, cur);
        }
        return buf.toString();
    }

    private static String replaceCharAt(String s, int i, char c) {
        StringBuilder buf = new StringBuilder(s);
        buf.setCharAt(i, c);
        return buf.toString();
    }

    private static String deleteAllNonDigit(String s) {
        return s.replaceAll("\\D", "");
    }

    public static String repalceAllChar(String s, String f, String r) {
        return s.replace(f, r);
    }
}
