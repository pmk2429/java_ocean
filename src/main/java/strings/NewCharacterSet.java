package strings;

/**
 * Change string to a new character set
 * <p>
 * Given a 26 letter character set, which is equivalent to character set of English alphabet i.e. (abcd….xyz)
 * and act as a relation. We are also given several sentences and we have to translate them with the help of given new character set.
 * <p>
 * Examples:
 * <p>
 * New character set : qwertyuiopasdfghjklzxcvbnm
 * Input : "utta"
 * Output : geek
 * <p>
 * Input : "egrt"
 * Output : code
 */
public class NewCharacterSet {

    private static final String CHAR_SET = "qwertyuiopasdfghjklzxcvbnm";
    private static String HASHED_STRING = "";

    private static void hash(String charSet) {

    }

    private static String convertString(String str) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int nC = str.charAt(i) - (char) 'a';
            output.append(nC);
        }
        return output.toString();
    }

    public static void main(String[] args) {
        String input = "a";
        System.out.println(convertString(input));
    }
}
