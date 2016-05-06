package numbers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * Created by Pavitra on 5/6/2016.
 */
public class CountingBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        System.out.println(Arrays.toString(countBits(num)));

        // finally close the scanner
        scanner.close();
    }

    /**
     * Returns the total ones for each binary representation
     *
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        int[] arrayOnes = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            if (i == 0) {
                arrayOnes[i] = i;
            } else {
                int sumOfOnes = 0;
                int loopNum = i;
                while (loopNum > 0) {
                    int temp = loopNum % 2;
                    if (temp == 1) sumOfOnes++;
                    loopNum = loopNum / 2;
                }
                arrayOnes[i] = sumOfOnes;
            }
        }
        return arrayOnes;
    }
}
