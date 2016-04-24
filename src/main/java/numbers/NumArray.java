package numbers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * <p>
 * Created by Pavitra on 4/23/2016.
 */
public class NumArray {
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public NumArray() {
        this.nums = null;
    }


    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] finalArray = new NumArray().getArrayFromProperties();
//        NumArray numArray = new NumArray(finalArray);
//        System.out.println(numArray.sumRange(1111, 2222));
//        System.out.println(numArray.sumRange(2, 5));
//        System.out.println(numArray.sumRange(0, 5));
        new NumArray().getArrayFromProperties();
    }

    public int[] getArrayFromProperties() {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            String filename = "largearray.properties";
            input = getClass().getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                return null;
            }
            prop.load(input);

            String array = prop.getProperty("largearray");
            System.out.println(array);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

