package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntro {

    private static ArrayList<String> list = new ArrayList<String>() {
        {
            add("One");
            add("OneAndOnly");
            add("Derek");
            add("Change");
            add("factory");
            add("justBefore");
            add("Italy");
            add("Italy");
            add("Thursday");
            add("");
            add("");
        }
    };

    private static void filter(String alphabet) {
        Stream<String> stream = list.stream().filter(element -> element.contains(alphabet));
        System.out.println(stream.collect(Collectors.toList()));
    }

    private static void exists(String alphabet) {
        boolean isExist = list.stream().anyMatch(element -> element.contains(alphabet));
        System.out.println(isExist);
    }

    private static void matching(String alphabet) {
        boolean isValid = list.stream().anyMatch(element -> element.contains("h")); // true
        boolean isValidOne = list.stream().allMatch(element -> element.contains("h")); // false
        boolean isValidTwo = list.stream().noneMatch(element -> element.contains("h")); // false
        System.out.println(isValid);
        System.out.println(isValidOne);
        System.out.println(isValidTwo);

        Stream.empty().allMatch(Objects::nonNull); // true
        Stream.empty().anyMatch(Objects::nonNull); // false
    }

    private static void reduction() {
        List<Integer> integers = Arrays.asList(1, 1, 1);
        Integer reduced = integers.stream().reduce(21, Integer::sum);
        System.out.println(reduced);
    }

    public static void main(String[] args) {
        filter("a");
        exists("d");
        reduction();
    }
}
