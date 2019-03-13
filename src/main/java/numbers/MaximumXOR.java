package numbers;

/**
 * Find a value whose XOR with given number is maximum
 * <p>
 * Given a value X, the task is to find the number Y which will give maximum value possible when XOR with X.
 * (Assume X to be 8 bits) Maximum possible value of X and Y both is 255.
 * <p>
 * Example 1:
 * ----------
 * Input:  X = 2
 * Output: 253
 * Binary Representation of X = 00000010
 * Binary Representation of Y = 11111101
 * Maximum XOR value: 11111111
 * Example 2:
 * ----------
 * Input:  X = 200
 * Output: 55
 */
public class MaximumXOR {

  /**
   * In order to find the maximum XOR value, we need to complement all the bits set in X to that in Y. So for all the
   * bits that are set in X, it should be unset in Y and all those unset in X should be set in Y because for XOR
   * operation, 1^0 = 1 or 0^1 = 1.
   * <p>
   * Considering that the integer is represented in 8 bits.
   *
   * @param X
   * @return
   */
  private static int maximumXOR(int X) {
    int num_of_bits = 8;
    // represent the number in 8 bits - 256
    int moved_bits = (1 << num_of_bits);
    // subtract 1 to get complement of the number in bits
    int subtract_bits = (moved_bits - 1);
    // perform XOR operation
    int xor_op = subtract_bits ^ X;
    return xor_op;
  }

  public static void main(String[] args) {
    int X = 80;
    System.out.println(maximumXOR(X));
  }
}
