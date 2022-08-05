package arrays;

/**
 * Suppose you have a long flowerbed in which some plots are planted and some are not. However, flowers cannot
 * be planted in adjacent plots - they would compete for water and both would die.
 * <p>
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty),
 * and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 * <p>
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * <p>
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * <p>
 * Note:
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 */
public class PlaceFlowers {

    private static boolean plantFlowers(int[] flowerbed, int n) {
        // check the value of n between 1 and 20000
        if (n < 0 || n > 20000) {
            return false;
        }

        // check the value of n relative to size of flowerbed
        if (n > flowerbed.length) {
            return false;
        }

        int maxAvailable = 0;
        int potsAvailable = 0;
        // find # of pots empty according to the no-adjacent-rule
        for (int value : flowerbed) {
            if (value == 0) {
                maxAvailable++;
                if (maxAvailable == 3 || (potsAvailable > 0 && maxAvailable == 2)) {
                    potsAvailable++;
                    maxAvailable = 0;
                }
            }
            else {
                maxAvailable = 0;
            }
        }
        return n <= potsAvailable;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 0, 1};
        int n = 2;
        System.out.println(plantFlowers(flowerbed, n));
    }
}
