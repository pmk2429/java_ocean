package numbers;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class FindKthLargest {
    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private static int findKthLargest(int[] nums, int start, int end, int k) {
        int left = start;
        int right = end;

        // Main loop to put all the values less than pivot
        // to left and all the values greater than pivot on the right.
        while (left <= right) {
            // scan from left to right until we find a value larger than pivot value

            /*
             * This while() loop is used to check if the numbers starting from
             * left until the last element are LESS THAN PIVOT or NOT. If they
             * are less then pivot, then its OK and keep incrementing LEFT
             * variable. else stop and store the LEFT variable value.
             */
            while (left <= right && nums[left] <= nums[start]) {
                ++left;
            }

            // same for this while() loop but loop only until the values stargin
            // from right are greater than the pivot.
            while (left <= right && nums[right] >= nums[start]) {
                --right;
            }

            // Now if left<right then swap its value
            if (left < right) {
                swap(nums, left, right);
            }
        }

        // Now after the loop, the correct pivot position should rely on right's position
        swap(nums, start, right);

        // From this point, it is different than Quick sort
        // Unlike from Quick sort, we firstly check if we can return from here.
        if (k == right + 1) { // notice, k it nth so start from 1, while index
            // starts from 0
            return nums[right]; // right is set so just return.
        }
        else if (k > right + 1) {
            // this means we have divided values in 2 groups and kth largest can
            // exist only on right group.
            return findKthLargest(nums, right + 1, end, k);
        }
        else {
            // focus on left half;
            return findKthLargest(nums, start, right - 1, k);
        }
    }

    private static int findKthLargest(int[] nums, int k) {
        // make sure that k is valid and between 0 and nums.length - 1
        if (k < 1 || k > nums.length) {
            return -1;
        }

        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    // Uses PriorityQueue
    private static int kthLargestUsingHeap(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>(k);
        for (int i : nums) {
            q.offer(i);
            if (q.size() > k) {
                q.poll();
            }
        }

        return q.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[5];
        Random random = new Random();
        System.out.println("Numbers: ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10);
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        System.out.println("\n3th largest value in array is: " + findKthLargest(nums, 3));

        System.out.println("\nAfter finding kth element: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println("\n\n");
        int[] a = {5, 4, 1, 8, 5, 7, 9};
        System.out.println("# " + kthLargestUsingHeap(a, 3));
    }
}
