package numbers;

/**
 * Created by Pavitra on 4/23/2016.
 */
public class LargestPower {
    public static void main(String[] args) {
        System.out.println(nearestPowerOfTwo(64));
    }

    public static int nearestPowerOfTwo(int number) {
        int powerNum = 2;
        int finalNum = 0;

        if (number == 1) {
            return 1;
        }
        else if (number == 2) {
            return 2;
        }
        else {
            while (true) {
                if (powerNum <= number) {
                    powerNum = powerNum * 2;
                }
                else {
                    finalNum = powerNum / 2;
                    break;
                }
            }
        }
        return finalNum;
    }
}
