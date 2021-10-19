package hamiltoniancycle;

public class App {

    public static void main(String[] args) {

        int[][] matrix = {
                { 0, 1, 0 },
                { 1, 0, 1 },
                { 0, 1, 0 }
        };

        int[][] matrix2 = {
                { 0, 1, 1, 1, 0, 0 },
                { 1, 0, 1, 0, 1, 0 },
                { 1, 1, 1, 1, 0, 1 },
                { 1, 0, 1, 0, 0, 1 },
                { 0, 1, 0, 0, 0, 1 },
                { 0, 1, 1, 1, 1, 1 }
        };

        HamiltonianCycle cycle = new HamiltonianCycle(matrix2);
        cycle.solve();
    }
}
