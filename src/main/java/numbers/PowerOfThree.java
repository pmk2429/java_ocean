package numbers;

/**
 * Power of 3
 * <p>
 * There exists a constant time (pretty fast) method for integers of limited size (e.g. 32-bit integers).
 * <p>
 * Note that for an integer N that is a power of 3 the following is true:
 * <p>
 * For any M <= N that is a power of 3, M divides N.
 * For any M <= N that is not a power 3, M does not divide N.
 * The biggest power of 3 that fits into 32 bits is 3486784401 (3^20). This gives the following code:
 * <p>
 * bool isPower3(std::uint32_t value) {
 * return value != 0 && 3486784401u % value == 0;
 * }
 * Similarly for signed 32 bits it is 1162261467 (3^19):
 * <p>
 * bool isPower3(std::int32_t value) {
 * return value > 0 && 1162261467 % value == 0;
 * }
 * In general the magic number is:
 * <p>
 * 3^floor(log_3 MAX) == pow(3, floor(log(MAX) / log(3)))
 * <p>
 * Careful with floating point rounding errors, use a math calculator like Wolfram Alpha to calculate the constant. For example for 2^63-1 (signed int64) both C++ and Java give 4052555153018976256, but the correct value is 4052555153018976267.
 * <p>
 * Created by Pavitra on 5/1/2016.
 */
public class PowerOfThree {
    public static void main(String[] args) {
        System.out.println("Loop: " + isPowerOfThree(729));
        System.out.println("Signed: " + isPowerOfThreeSigned(1162261467));
        System.out.println("Unsigned: " + isPowerOfThreeUnsigned(2147483647));
    }

    public static boolean isPowerOfThree(Integer n) {
        if (n == 1) {
            return true;
        }

        boolean check = false;
        if (n % 10 == 1 || n % 10 == 3 || n % 10 == 7 || n % 10 == 9) {
            for (int power = 3; power < n; power *= 3) {
                if (power * 3 == n) {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }

    /**
     * Returns power of 3 without loop for signed 32 bits. (0 - 1162261467) for 32-bit integers
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThreeSigned(int n) {
        return n != 0 && 1162261467 % n == 0;
    }

    /**
     * Returns power of 3 without loop for unsigned 32 bits. (0 - 3486784401L) for 32-bit unsigned numbers
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThreeUnsigned(int n) {
        return n != 0 && 3486784401L % n == 0;
    }
}
