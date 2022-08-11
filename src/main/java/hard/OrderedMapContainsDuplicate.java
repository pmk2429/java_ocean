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
 */
public class OrderedMapContainsDuplicate {

    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> selfBalancingTree = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // Find the successor of current element
            Integer ceiling = selfBalancingTree.ceiling(nums[i]);
            if (ceiling != null && ceiling <= nums[i] + t) {
                return true;
            }

            // Find the predecessor of current element
            Integer floor = selfBalancingTree.floor(nums[i]);
            if (floor != null && nums[i] <= floor + t) {
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
    }
}
