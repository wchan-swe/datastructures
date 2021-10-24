package dp.fibonacci;

import java.util.Map;

public class Fibonacci {

    public int fibonacciRecursion(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    // top-down approach MEMOIZATION
    // start with n and calculate smaller and smaller fibonacci numbers
    public int fibonacciMemoization(int n, Map<Integer, Integer> table) {

        if (!table.containsKey(n)) {
            table.put(n, fibonacciMemoization(n-1, table) + fibonacciMemoization(n-2, table));
        }

        // O(1) constant running time
        return table.get(n);
    }

    // bottom-up approach TABULATION
    // start with small fibonacci values and keep calculating larger and larger ones
    // by building up the hash table on a one-by-one basis until we get to the solution
    public int fibonacciTabulation(int n, Map<Integer, Integer> table) {

        // values for 0 and 1 are already in the table
        // this has O(N) running time complexity
        for (int i = 2; i <= n; i++) {
            table.put(i, table.get(i-1) + table.get(i-2));
        }

        return table.get(n);
    }
}
