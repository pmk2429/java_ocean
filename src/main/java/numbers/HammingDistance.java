package numbers;

/**
 * WAP to find Hamming distance between two Integers.
 * Given two integers, the task is to find the hamming distance between two integers.
 * Hamming Distance between two integers is the number of bits which are different at same position in both numbers.
 * <p>
 * Example 1:
 * ----------
 * Input: n1 = 9, n2 = 14
 * Output: 3
 * 9 = 1001, 14 = 1110
 * No. of Different bits = 3
 * Example 2:
 * ----------
 * Input: n1 = 4, n2 = 8
 * Output: 2
 */
public class HammingDistance {

    // find number of different bits
    private static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int setBits = 0;

        while (xor > 0) {
            setBits += xor & 1;
            xor >>= 1;
        }
        return setBits;
    }

    public static void main(String[] args) {
        int x1 = 9;
        int x2 = 14;
        System.out.println(hammingDistance(x1, x2));
    }
}
