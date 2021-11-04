package dp.knapsackproblem;

public class App {

    public static void main(String[] args) {

        int numOfItems = 3;
        int capacityOfKnapsack = 5;

        int[] weightOfItmes = new int[numOfItems + 1];
        weightOfItmes[1] = 4;
        weightOfItmes[2] = 2;
        weightOfItmes[3] = 3;

        int[] profitOfItems = new int[numOfItems + 1];
        profitOfItems[1] = 10;
        profitOfItems[2] = 4;
        profitOfItems[3] = 7;

        Knapsack knapsack = new Knapsack(numOfItems, capacityOfKnapsack, weightOfItmes, profitOfItems);
        knapsack.solve();
        knapsack.showResult();
     }
}
