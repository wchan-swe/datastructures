package selection.quickselect;

import java.util.Arrays;
import java.util.Random;

/**
 * Sort a list of integers with quick select
 */

public class Exercise {

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, 26, 7, 14, 3, 7, 2};
        sortUsingSelect(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortUsingSelect(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            select(nums, i);
        }
    }

    public static int select(int[] nums, int k) {
        int result = quickSelect(nums, 0, nums.length - 1, k - 1);

        return result;
    }

    private static int quickSelect(int[] nums, int low, int high, int k) {

        int pivot = partition(nums, low, high);

        if (pivot < k) {
            return quickSelect(nums, pivot +1, high, k);
        } else if (pivot > k) {
            return quickSelect(nums, low, pivot - 1, k);
        }

        return pivot;

    }

    private static int partition(int[] nums, int low, int high) {
        // random pivot value
        int pivot = new Random().nextInt(high - low + 1) + low;
        pivot = nums[pivot];

        int i = low - 1;
        int j = high + 1;

        while(true) {
            do {
                i++;
            } while(nums[i] < pivot);

            do {
                j--;
            } while(nums[j] > pivot);

            if (i >= j) {
                return j;
            }

            swap(nums, i, j);

        }

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
