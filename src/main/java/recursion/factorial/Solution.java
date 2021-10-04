package recursion.factorial;

public class Solution {

    public static void main(String[] args) {
        // tail recursion
        int result = factorial(5, 1);
        System.out.println(result);

        // factorial(5, 1) initial call
        // return factorial (4, 5*1)
        // return factorial(3, 5*1*4)
        // return factorial(2, 5*1*4*3)
        // return factorial(1, 5*1*4*3*2)
        // return 120

    }

    private static int factorial(int n, int result) {
        if (n == 0 || n == 1) {
            return result;
        }

        return factorial(n - 1, n * result);
    }
}
