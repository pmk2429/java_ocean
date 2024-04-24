package arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Find the largest number possible from a set of given numbers where the numbers append to each other in any order
 * to form the largest number.
 * <p>
 * Input:  { 10, 68, 75, 7, 21, 12 }
 * Output: 77568211210
 */
public class FindLargestPossibleNumberFromArray {
    private static String findLargestNumber(List<Integer> nums) {
        nums.sort((a, b) -> (String.valueOf(b) + a).compareTo(String.valueOf(a) + b));

        return nums.stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 68, 97, 9, 21, 12);

        String largestNumber = findLargestNumber(numbers);
        System.out.println("The largest number is " + largestNumber);
    }
}
