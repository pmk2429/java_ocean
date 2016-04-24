package numbers;

import java.util.ArrayList;

/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * <p>
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * <p>
 * Note: you may assume that n is not less than 2.
 * <p>
 * Created by Pavitra on 4/21/2016.
 */
public class IntegerBreak {
    public static void main(String[] args) {
        //System.out.println(new IntegerBreak().integerBreak(10));
        new IntegerBreak().integerBreak(5);
    }

    /**
     * Returns the list of largest product
     *
     * @param n
     * @return
     */
    public void integerBreak(int n) {
        // first break n in to an array of integers [2,n-1]
        int totalNums = n - 2;
        int[] arrInteger = new int[totalNums];
        for (int i = 2, j = 0; i < n && j < totalNums; i++, j++) {
            arrInteger[j] = i;
        }
        //System.out.println(Arrays.toString(arrInteger));

        // once we have the array of Integers below n, make list of all the subsets possible
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arrInteger.length; i++) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();

            //get sets that are already in result
            for (ArrayList<Integer> a : result) {
                temp.add(new ArrayList<>(a));
            }

            //add S[i] to existing sets
            for (ArrayList<Integer> a : temp) {
                a.add(arrInteger[i]);
            }

            //add S[i] only as a set
            ArrayList<Integer> single = new ArrayList<>();
            single.add(arrInteger[i]);
            temp.add(single);

            result.addAll(temp);
        }

        //add empty set
        result.add(new ArrayList<>());

        ArrayList<ArrayList<Integer>> finalSubsets = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).size() >= 2) {
                if (sumOfArray(result.get(i)) <= n) {
                    finalSubsets.add(result.get(i));
                }
            }
        }

        // now we have all the subsets with size >= 2

    }

    public static int sumOfArray(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
