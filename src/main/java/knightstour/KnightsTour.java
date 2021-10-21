package knightstour;

public class KnightsTour {

    private int[][] solutionMatrix;
    private int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};    // positive is right, negative is left
    private int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};    // positive is up, negative is down

    public KnightsTour() {
        this.solutionMatrix = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                solutionMatrix[i][j] = Integer.MIN_VALUE;   // track if we have visited a given cell
            }
        }
    }

    public void solveTour() {
        this.solutionMatrix[0][0] = 1;   // start from the top left corner

        if (solve(2,0,0)) {
            printSolution();
        } else {
            System.out.println("No feasible solution...");
        }
    }

    private boolean solve(int stepCount, int x, int y) {
        // we are going to assign a given stepCount to ever single cell
        // to be able to track, start from 2 because we have already settled stepCount 1
        if (stepCount == Constants.BOARD_SIZE * Constants.BOARD_SIZE + 1) {
            // this means we have visited every cell on the board and there is a solution
            return true;
        }

        for (int i = 0; i < Constants.NUM_OF_MOVES; i++) {
            // track whether it is possible to make a step with the given moves
            int nextX = x + xMoves[i];
            int nextY = y + yMoves[i];

            if (isStepValid(nextX, nextY)) {
                solutionMatrix[nextX][nextY] = stepCount;

                if (solve(stepCount+1, nextX, nextY)) {
                    return true;
                }

                // backtrack!!!
                solutionMatrix[nextX][nextY] = Integer.MIN_VALUE;   // reset to unvisited
            }

        }
        return false;
    }

    private boolean isStepValid(int x, int y) {

        // check if possible to make the move
        if (x < 0 || x >= Constants.BOARD_SIZE) { return false; }
        if (y < 0 || y >= Constants.BOARD_SIZE) { return false; }
        if (solutionMatrix[x][y] != Integer.MIN_VALUE) { return false; }

        return true;
    }

    private void printSolution() {
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                System.out.print(this.solutionMatrix[i][j] + " ");
            }

            System.out.println();
        }
    }


}
