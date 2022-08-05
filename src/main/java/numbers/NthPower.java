package numbers;

/**
 * Created by Pavitra on 11/7/2015.
 */
public class NthPower {
    public static void main(String[] args) {
        double[] nums = {2.2, 3.3, 4.4, 5.5, 6.6};
        System.out.println(NthPower.geometricMean(nums));
    }

    private static double geometricMean(double[] nums) {
        int size = nums.length;
        double product = 1.0;
        for (double num : nums) {
            product = product * num;
        }
        System.out.println("Product: " + product);

        double geoMean = Math.pow(product, 1.0 / size);
        return geoMean;
    }
}
