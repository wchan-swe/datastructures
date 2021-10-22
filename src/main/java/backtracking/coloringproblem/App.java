package backtracking.coloringproblem;

public class App {

    public static void main(String[] args) {

        int[][] matrix = {
                { 0, 1, 0, 1, 0 },
                { 1, 0, 1, 1, 0 },
                { 0, 1, 0, 1, 0 },
                { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 1, 0 }
        };

        // no solution for 2
//        int numColors = 2;
        int numColors = 3;

        ColoringProblem coloringProblem  = new ColoringProblem(numColors, matrix);
        coloringProblem.solve();
    }
}
