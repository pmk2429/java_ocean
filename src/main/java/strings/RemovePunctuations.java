package strings;

/**
 * Removing punctuations from a given string
 * <p>
 * Given a string, remove the punctuation from the string if the given character is a punctuation character as
 * classified by the current C locale. The default C locale classifies these characters as punctuation:
 * <p>
 * !"#$%&'()*+,-./:;?@[\]^_`{|}~
 * Examples:
 * <p>
 * Input : %welcome' to @mukrash#
 * Output : welcome to mukrash
 * <p>
 * Input : Hello!!!, he said ---and went.
 * Output : Hello he said and went
 */
public class RemovePunctuations {

    private static String removePunctuations(String str) {
        return str != null && str.trim().length() > 0 ? str.replaceAll("\\p{Punct}", "") : null;
    }

    public static void main(String[] args) {
        String str = "%welcome' to @mukrash#";
        System.out.println(removePunctuations(str));
    }
}
