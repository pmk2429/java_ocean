package strings;

public class RemoveCharFromString {

    /**
     * <h1>removeCharFromString(String, char)</h1> method is used to remove the
     * specified char from the String. This method converts the input String
     * into a Character Array and then it iterates each element of the Character
     * Array to check whether the specified char is in the Character Array or
     * not. If match is found then the char is replaced with a null and a count
     * is incremented to make sure how many characters were replaced(removed).
     * Otherwise, the message is printed that the specified character was not
     * found in the String.
     */
    private static char[] removeAllOccurencesOfCharFromString(String original, char character) {
        int count = 0;
        char[] stringArray = original.toCharArray();
        for (int i = 0; i < stringArray.length; i++) {
            if (character == stringArray[i]) {
                stringArray[i] = '*';
                count++;
            }
        }
        if (count > 0) {
            System.out.print("\n> '" + character + "' was Successfully removed from String.\n");
        }
        else if (count == 0) {
            System.out.print("\n> Sorry! '" + character + "' was not found in input String.\n");
        }
        return stringArray;
    }


    private static String removeChar(String original, char character) {
        StringBuilder sb = new StringBuilder();
        for (char c : original.toCharArray()) {
            if (character != c) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "pavitramkansara";
        System.out.println(removeChar(str, 'a'));
    }
}