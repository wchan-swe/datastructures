package selection.quickselect;

/**
 * QuickSelect
 * l\Lomuto paritioning scheme degenerates to O(N^2) when array is sorted or all equal
 */

import java.util.Random;

public class QuickSelect {

    public static void main(String[] args) {
        int[] nums = { 3, 2, -1, 5, 6, 4 };
        int[] nums2 = {1, 12, -5, 26, 7, 14, 3, 7, 2};
        int result = select(nums2, 2);
        System.out.println(result);
    }

    public static int select(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    public static int quickSelect(int[] nums, int first, int last, int k) {
        int pivot = partition_hoare(nums, first, last);

        if (pivot < k) {
            // k is larger recurse right
            return quickSelect(nums, pivot + 1, last, k);
        } else if (pivot > k) {
            // k is smaller than pivot recurse left
            return quickSelect(nums, first, pivot - 1, k);
        }

        return nums[pivot];
    }

    private static int partition_lomuto(int[] nums, int first, int last) {
        // index of random pivot within the range between first and last
        int pivot = new Random().nextInt(last - first + 1) + first;

        swap(nums, pivot, last);

        // iterate through the items
        for(int i = first; i < last; i++) {
            if (nums[i] < nums[last]) {
                swap(nums, i, first);
                first++;
            }
        }

        swap(nums, last, first);

        // this is the index of the pivot
        return first;
    }

    // Partition using Hoare's Partitioning scheme
    public static int partition_hoare(int[] a, int low, int high)
    {
        int pivot = a[low];
        int i = low - 1;
        int j = high + 1;

        while (true)
        {
            do {
                i++;
            } while (a[i] < pivot);

            do {
                j--;
            } while (a[j] > pivot);

            if (i >= j) {
                return j;
            }

            swap(a, i, j);
        }
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
