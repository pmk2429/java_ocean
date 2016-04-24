package guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Pavitra on 11/22/2015.
 */
public class GuavaTest {

    // instead of doing this,
    Map<String, Map<Long, List<String>>> map1 = new HashMap<String, Map<Long, List<String>>>();
    // you can do this
    Map<String, Map<Long, List<String>>> map2 = Maps.newHashMap();
    // It's also easy to populate maps:
    ImmutableMap<String, String> map = ImmutableMap.of("key1", "value1", "key2", "value2");

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

        // join by skipping nulls
        String[] fantasyGenresNulls = {"Space Opera", null, "Horror", "Magic realism", null, "Religion"};
        String joinedNoNulls = Joiner.on(", ").skipNulls().join(fantasyGenresNulls);
        String joinedNulls = Joiner.on(", ").useForNull("NULL").join(fantasyGenresNulls);
        System.out.println(joinedNoNulls);
        System.out.println(joinedNulls);

        // join Maps with Key-Value pairs
        Map<Integer, String> map = new HashMap();
        map.put(1, "Space Opera");
        map.put(2, "Horror");
        map.put(3, "Magic realism");
        String joinedMap = Joiner.on(", ").withKeyValueSeparator(" -> ").join(map);
        System.out.println(joinedMap);

        // Iterator instead of Arrays
        String iteratorInput = "Some very stupid data with ids of invoces like 121432, 3436534 and 8989898 inside";
        Iterable<String> splitted = Splitter.on(' ').split(iteratorInput);
        System.out.println(splitted);

        // Variable length splitting for each 'column'
        String variableSplitInput = "A  1  1  1  1\n" +
                "B  1  2  2  2\n" +
                "C  1  2  3  3\n" +
                "D  1  2  5  3\n" +
                "E  3  2  5  4\n" +
                "F  3  3  7  5\n" +
                "G  3  3  7  5\n" +
                "H  3  3  9  7";
        Iterable<String> varSplitted = Splitter.fixedLength(3).trimResults().split(variableSplitInput);
        System.out.println(varSplitted);


    }
}
