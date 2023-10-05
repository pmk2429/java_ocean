package strings;

public class HanaStringUtils {

    public static char getChar(byte[] val, int index) {
        return (char) (val[index] & 0xff);
    }

    public static String trim(byte[] value) {
        int len = value.length;
        int st = 0;
        while ((st < len) && ((value[st] & 0xff) <= ' ')) {
            st++;
        }
        while ((st < len) && ((value[len - 1] & 0xff) <= ' ')) {
            len--;
        }
        return ((st > 0) || (len < value.length)) ? new String(value, st, len - st) : null;
    }

    public static int indexOfNonWhitespace(byte[] value) {
        int left = 0;
        int length = value.length;
        while (left < length) {
            char ch = getChar(value, left);
            if (ch != ' ' && ch != '\t' && !Character.isWhitespace(ch)) {
                break;
            }
            left++;
        }
        return left;
    }

    public static int lastIndexOfNonWhitespace(byte[] value) {
        int length = value.length;
        int right = length;
        while (0 < right) {
            char ch = getChar(value, right - 1);
            if (ch != ' ' && ch != '\t' && !Character.isWhitespace(ch)) {
                break;
            }
            right--;
        }
        return right;
    }

    private static boolean isEmpty(String str) {
        return str.length() == 0;
    }

    private static boolean isDelimiter(final char ch, final char[] delimiters) {
        if (delimiters == null) {
            return Character.isWhitespace(ch);
        }

        for (char delimiter : delimiters) {
            if (ch == delimiter) {
                return true;
            }
        }
        return false;
    }

    private static String initials(final String str, final char... delimiters) {
        if (isEmpty(str)) {
            return str;
        }
        if (delimiters != null && delimiters.length == 0) {
            return "";
        }
        final int strLen = str.length();
        final char[] buf = new char[strLen / 2 + 1];
        int count = 0;
        boolean lastWasGap = true;
        for (int i = 0; i < strLen; i++) {
            final char ch = str.charAt(i);
            if (isDelimiter(ch, delimiters)) {
                lastWasGap = true;
            }
            else if (lastWasGap) { // last char was delimiter
                buf[count++] = ch;
                lastWasGap = false;
            }
        }
        return new String(buf, 0, count);
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static void main(String[] args) {
        String pmk = "Pavitra Mukund Kansara";
        System.out.println(initials(pmk, ' '));
    }
}
