package guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;

/**
 * Created by Pavitra on 11/22/2015.
 */
public class GuavaTest {
    public static void main(String[] args) {
        // And/or ease of use
        String input = "This invoice has an id of 192/10/10";
        CharMatcher charMatcher = CharMatcher.DIGIT.or(CharMatcher.is('/'));
        String output = charMatcher.retainFrom(input);
        System.out.println(output);

        // Negation
        String input2 = "DO NOT scream at me!";
        CharMatcher charMatcher2 = CharMatcher.JAVA_LOWER_CASE.or(CharMatcher.WHITESPACE).negate();
        String output2 = charMatcher2.retainFrom(input2);
        System.out.println(output2);

        // Ranges
        CharMatcher charMatcher3 = CharMatcher.inRange('m', 's').or(CharMatcher.is('a').or(CharMatcher.WHITESPACE));
        String output3 = charMatcher3.retainFrom(input2);
        System.out.println(output3);

        // Joiner/Splitter
        String[] fantasyGenres = {"Space Opera", "Horror", "Magic realism", "Religion"};
        String joined = Joiner.on(", ").join(fantasyGenres);
        System.out.println(joined);


    }
}
