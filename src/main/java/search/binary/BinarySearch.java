package search.binary;

public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        BinarySearch b = new BinarySearch();
        System.out.println(b.find(nums, -10, 0, nums.length - 1));
        System.out.println(b.find(nums, 8, 0, nums.length - 1));

    }

    public static int find(int[] container, int item, int left, int right) {

        if (right < left) {
            return -1;
        }

        int middle = (left + right) / 2;

        if (container[middle] == item) {
            return middle;
        }

        if (container[middle] < item) {
            // we can discard left sub array
            return find(container, item, middle + 1, right);
        } else {
            // discard the right array
            return find(container, item, left, middle - 1);
        }
    }
}
