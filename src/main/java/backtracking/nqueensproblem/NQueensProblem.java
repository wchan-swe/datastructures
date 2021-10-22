package backtracking.nqueensproblem;

public class NQueensProblem {

    private int[][] chessTable;
    private int numOfQueens;

    public NQueensProblem(int numOfQueens) {
        this.chessTable = new int[numOfQueens][numOfQueens];
        this.numOfQueens = numOfQueens;
    }

    public void solve() {
        // if setQueens at 0 returns true, it means we have a solution
        // so we will print it
        if(setQueens(0)) {
            printQueens();
        } else {
            System.out.println("There is no solution.");
        }
    }

    private boolean setQueens(int colIndex) {

        if (colIndex == numOfQueens) {
            return true;
        }

        for (int rowIndex = 0; rowIndex < numOfQueens; ++rowIndex) {
            if (isPlaceValid(rowIndex, colIndex)) {
                chessTable[rowIndex][colIndex] = 1;

                // check next column
                if (setQueens(colIndex + 1)) {
                    return true;
                }
                // backtracking
                // queen is not a good qposition, reset queen backtrack and try next row
                chessTable[rowIndex][colIndex] = 0;
            }
        }

        // false because we've considered every single row
        return false;
    }

    private boolean isPlaceValid(int rowIndex, int colIndex) {

        // check the rows
        for(int i = 0; i < colIndex; i++) {
            if (chessTable[rowIndex][i] == 1) {
                return false;   // because another queen on same row
            }
        }

        // check diagonals
        for(int i = rowIndex, j = colIndex; i >= 0 && j >= 0; i--, j--) {
            if (chessTable[i][j] == 1) {
                return false;   // another queen in diagonal
            }
        }

        // the other diagonal
        for(int i = rowIndex, j = colIndex; i < chessTable.length && j >= 0; i++, j--) {
            if (chessTable[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private void printQueens() {
        for (int i = 0; i < chessTable.length; i++) {
            for(int j = 0; j < chessTable.length; j++) {
                if(chessTable[i][j] == 1) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }
}
