package dp.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        Fibonacci fibonacci = new Fibonacci();

        // it has exponential running time
        System.out.println(fibonacci.fibonacciRecursion(8));

        Map<Integer, Integer> table = new HashMap<>();
        table.put(0, 1);
        table.put(1, 1);

        // they have O(N) linear running time
//        System.out.println(fibonacci.fibonacciMemoization(12, table));
        System.out.println(fibonacci.fibonacciTabulation(12, table));
    }
}
