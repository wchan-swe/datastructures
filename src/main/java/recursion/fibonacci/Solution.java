package recursion.fibonacci;

public class Solution {

    public static void main(String[] args) {
//        int result = fibonacci(10);
//        System.out.println(result);
        int iterative = iterative_Fibonacci(8);
        int iterative2 = iterative_Fibonacci(12);
        int iterative3 = iterative_Fibonacci(0);
        int iterative4 = iterative_Fibonacci(1);
        System.out.println(iterative);
        System.out.println(iterative2);
        System.out.println(iterative3);
        System.out.println(iterative4);
    }

    public static int fibonacci(int n) {
        if (n == 0 ||  n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int iterative_Fibonacci(int n) {
        int prev = 0;
        int next = 1;
        int sum = prev + next;
        int f = 1;

        if (n == 0) {
            return n;
        }

        while (f < n) {
            sum = prev + next;
            prev = next;
            next = sum;
            f++;
        }

        return next;
    }
}
