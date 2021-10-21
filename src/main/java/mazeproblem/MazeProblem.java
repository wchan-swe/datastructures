package mazeproblem;

public class MazeProblem {

    private int[][] mazeTable;
    private int[][] solutionTable;
    private int mazeSize;

    public MazeProblem(int[][] maxzeTable) {
        this.mazeTable = maxzeTable;
        this.mazeSize = maxzeTable.length;
        this.solutionTable = new int[mazeSize][mazeSize];
    }

    public void solve() {
        if (solveMaze(0, 0)) {
            showResults();
        } else {
            System.out.println("No solution...");
        }
    }

    private boolean solveMaze(int x, int y) {
        // basically doing a depth first search here
        if (isFinished(x,y)) {
            return true;
        }

        if (isValid(x,y)) {
            solutionTable[x][y] = 1;
            // we go to the right
            if (solveMaze(x+1, y)) {
                return true;
            }

            // we go downwards
            if (solveMaze(x, y+1)) {
                return true;
            }

            if (solveMaze(x-1, y)) {
                return true;
            }

            if (solveMaze(x, y-1)) {
                return true;
            }

            // backtrack!!!
            solutionTable[x][y] = 0;
        }

        return false;
    }

    private boolean isValid(int x, int y) {
        // check to make sure we are not outside the scope of the table
        if (x < 0 || x >= mazeSize) { return false; }
        if (y < 0 || y >= mazeSize) { return false; }
        // check if obstacle which are integer 0
        if (mazeTable[x][y] != 1) { return false; }
        // if it is a 1 we have already considered the cell at x,y
        if (this.solutionTable[x][y] == 1) { return false; }

        return true;
    }

    private boolean isFinished(int x, int y) {
        // check if we are at the end
        if (x == mazeSize - 1 && y == mazeSize - 1) {
            this.solutionTable[x][y] = 1;
            return true;
        }

        return false;
    }

    private void showResults() {
        for (int i = 0; i < mazeSize; i++) {
            for (int j = 0; j < mazeSize; j++) {
                if (solutionTable[i][j] == 1) {
                    System.out.print(" s ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }
}
