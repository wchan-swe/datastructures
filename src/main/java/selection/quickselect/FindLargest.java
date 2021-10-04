package selection.quickselect;

/**
 * Quick Select is a selection algorithm designed by Tony Hoare.
 * It is able to find the k-th smallest
 * (largest) item in an unordered array.
 * It has O(N) running time in best case.
 * Worst case running time of O(N^2) quadratice running time.
 * In-place approach and does not need additional memory.
 */

public class FindLargest {

    public static void main(String[] args) {
        // [1,2,3,4,5,6]
        int[] nums = { 3, 2, 1, 5, 6, 4 };

        int kthLargest = findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = n - k;

        int low = 0;
        int high = n - 1;
        int pivotIndex = partition(nums, low, high);

        while(pivotIndex != k) {
            if (pivotIndex < k) {
                pivotIndex = partition(nums, pivotIndex + 1, high);
            } else if (pivotIndex > k) {
                pivotIndex = partition(nums, low, pivotIndex - 1);
            }
        }

        return nums[k];
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = high;
        for (int i = low; i < high; i++) {
           if (nums[i] > nums[pivot]) {
               swap(nums, i, pivot);
           }
        }

        return pivot;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
