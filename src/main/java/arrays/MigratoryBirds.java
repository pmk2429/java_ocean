package arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given an array of bird sightings where every element represents a bird type id, determine the id of the most
 * frequently sighted type. If more than 1 type has been spotted that maximum amount, return the smallest of their ids.
 * <p>
 * Example
 * -------
 * There are two each of types  and , and one sighting of type . Pick the lower of the two types seen twice: type
 * Input: 1 4 4 4 5 3
 * Output: 4
 * The different types of birds occur in the following frequencies:
 * Type :  bird
 * Type :  birds
 * Type :  bird
 * Type :  birds
 * Type :  bird
 * The type number that occurs at the highest frequency is type , so we print  as our answer.
 * <p>
 * Input: 1 2 3 4 5 4 3 2 1 3 4
 * Output : 3
 * Explanation:
 * The different types of birds occur in the following frequencies:
 * Type 1:2
 * Type 2:2
 * Type 3:3
 * Type 4:3
 * Type 5:1
 * Two types have a frequency of , and the lower of those is type .
 */
public class MigratoryBirds {

    public static int migratoryBirdsUsingSet(int[] arr) {
        int birdType = Integer.MAX_VALUE;
        int preCount = Integer.MIN_VALUE;
        Set<Integer> birdTypes = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        for (Integer bird : birdTypes) {
            int count = (int) Arrays.stream(arr).filter(i -> i == bird).count();
            if (count > preCount) {
                birdType = bird;
                preCount = count;
            }
            else if (count == preCount) {
                birdType = Integer.min(birdType, bird);
            }
        }
        return birdType;
    }

    public static void main(String[] args) {
        int[] birds1 = {1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4};
        System.out.println(migratoryBirdsUsingSet(birds1));
        int[] birds2 = {1, 4, 4, 4, 5, 3};
        System.out.println(migratoryBirdsUsingSet(birds2));
        int[] birds3 = {1, 1, 1, 2, 5, 2, 4, 5, 2, 7, 4};
        System.out.println(migratoryBirdsUsingSet(birds3));
    }
}
