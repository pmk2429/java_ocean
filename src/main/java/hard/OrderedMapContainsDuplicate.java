package hard;

import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
 * absolute difference between nums[i] and nums[j] is at most(<=) t and the absolute difference between i and j is at
 * most(<=) k.
 * <p>
 * Example 1:
 * ----------
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * <p>
 * Example 2:
 * ----------
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * <p>
 * Example 3:
 * ----------
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 * <p>
 * ~!@#HARD:REVISE
 */
public class OrderedMapContainsDuplicate {

    /**
     * This problem requires to maintain a window of size k of the previous values that can be queried for value ranges.
     * The best data structure to do that is Binary Search Tree because it self-balances the height of the tree.
     * As a result maintaining the tree of size k will result in time complexity O(N lg K).
     * In order to check if there exists any value of range abs(nums[i] - nums[j]) to simple queries can be executed
     * both of time complexity O(lg K)
     */
    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        TreeSet<Integer> selfBalancingTree = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // Find the successor of current element
            Integer ceiling = selfBalancingTree.ceiling(nums[i]);
            if (ceiling != null && ceiling <= nums[i] + t) {
                return true;
            }

            // Find the predecessor of current element
            Integer floor = selfBalancingTree.floor(nums[i]);
            if (floor != null && floor >= nums[i] - t) {
                return true;
            }

            selfBalancingTree.add(nums[i]);

            if (selfBalancingTree.size() > k) {
                selfBalancingTree.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        int t = 0;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));

        int[] nums2 = {1, 5, 9, 1, 5, 9};
        int k2 = 2;
        int t2 = 3;
        System.out.println(containsNearbyAlmostDuplicate(nums2, k2, t2));
    }
}
