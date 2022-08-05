package numbers;

/**
 * Created by Pavitra on 4/23/2016.
 */
public class LargestPower {
    public static void main(String[] args) {
        System.out.println(nearest_power_of_two(64));
    }

    public static int nearest_power_of_two(int number) {
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
