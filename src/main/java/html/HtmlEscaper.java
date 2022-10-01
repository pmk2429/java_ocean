package html;

import java.util.stream.Collectors;

public class HtmlEscaper {

    public static String escapeHTML(String str) {
        return str.codePoints().mapToObj(c -> c > 127 || "\"'<>&".indexOf(c) != -1
                ? "&#" + c + ";"
                : new String(Character.toChars(c)))
            .collect(Collectors.joining());
    }


    public static void main(String[] args) {

    }
}
