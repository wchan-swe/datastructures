package search.linear;

public class RecursiveFind {

    static int[] num = { 5, 3, 7, 2, 9, 4, 8 };

    public static void main(String[] args) {
        int result = find(num, 9, 0);
        System.out.println(result);
    }

    public static int find(int[] container, int item, int index) {

        // base cases
        if (index >= container.length) {
            return -1;
        } else if (container[index] == item) {
            return index;
        }
        return find(container, item, index + 1);
    }

}
