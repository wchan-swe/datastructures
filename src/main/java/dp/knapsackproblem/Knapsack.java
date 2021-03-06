package dp.knapsackproblem;

public class Knapsack {

    private int numOfItems;
    private int capacityOfKnapsack;
    private int[][] knapsackTable;
    private int totalBenefit;
    private int[] weights;
    private int[] values;

    public Knapsack(int numOfItems, int capacityOfKnapsack, int[] weights, int[] values) {
        this.numOfItems = numOfItems;
        this.capacityOfKnapsack = capacityOfKnapsack;
        this.weights = weights;
        this.values = values;
        this.knapsackTable = new int[numOfItems+1][capacityOfKnapsack+1];
    }

    public void solve() {
        // time complexity: O(N*W)
        for(int i = 1; i < numOfItems+1; i++) {
            for(int j = 1; j < capacityOfKnapsack+1; j++) {
                int notTakingItem = knapsackTable[i-1][j];  // not taking item i
                int takingItem = 0;

                if (weights[i] <= j) {
                    takingItem = values[i] + knapsackTable[i-1][j-weights[i]];
                }
                knapsackTable[i][j] = Math.max(notTakingItem, takingItem);
            }
        }
        totalBenefit = knapsackTable[numOfItems][capacityOfKnapsack];
    }

    public int solveRecursion(int m, int[] w, int[] v, int n) {

        // base cases
        if (m == 0 || n == 0) {
            return 0;
        }

        // the given item can not fit into the knapsack
        if (w[n-1] > m) {
            return solveRecursion(m, w, v, n-1);
        } else {
            // given item can fit into the knapsack so we have
            int included = v[n-1] + solveRecursion(m-w[n-1], w, v, n-1);
            int excluded = solveRecursion(m, w, v, n-1);
            return Math.max(included, excluded);
        }
    }

    public void showResult() {
        System.out.println("Total benefit: " + totalBenefit);

        for(int n = numOfItems, w = capacityOfKnapsack; n > 0; n--) {
            if (knapsackTable[n][w] != 0 && knapsackTable[n][w] != knapsackTable[n-1][w]) {
                System.out.println("We take item #" + n);
                w = w - weights[n];
            }
        }
    }
}
