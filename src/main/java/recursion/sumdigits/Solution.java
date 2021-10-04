package recursion.sumdigits;

public class Solution {

    public static void main(String[] args) {
        int sum = sumDigits(12345);
        System.out.println(sum);
    }

    private static int sumDigits(int n) {
        if (n % 10 == 0) {
            return n;
        }
        return (n % 10) + sumDigits(n / 10);
    }
}