package coloringproblem;

public class ColoringProblem {

    private int numOfVertices;
    private int numOfColors;
    private int[] colors;       // store the colors as chromatic numbers 0,1,2 and so on
    private int[][] adjacencyMatrix;

    public ColoringProblem(int numOfColors, int[][] adjacencyMatrix) {
        this.numOfColors = numOfColors;
        this.adjacencyMatrix = adjacencyMatrix;
        this.numOfVertices = adjacencyMatrix.length;
        this.colors = new int[numOfVertices];
    }

    public void solve() {

        if (solveProblem(0)) {
            showResults();
        } else {
            System.out.println("No solution...");
        }
    }

    private boolean solveProblem(int nodeIndex) {
        if (nodeIndex == numOfVertices) {
            return true;
        }

        for (int colorIndex = 1; colorIndex <= numOfColors; colorIndex++) {
            // color is valid if we are able to assign that color to that given node
            if (isColorValid(nodeIndex, colorIndex)) {
                colors[nodeIndex] = colorIndex;

                // try and solve the problem recursively the next node
                // if it is possible, we will return true
                if (solveProblem(nodeIndex + 1)) {
                    return true;
                }

                // backtrack!!!
                // this means we just increment the color index because we are not able
                // to assign that colorIndex to the given node

            }
        }

        return false;
    }

    private boolean isColorValid(int nodeIndex, int colorIndex) {
        for (int i = 0; i < numOfVertices; i++) {
            // there is a connection with neighboring nodes
            //  adjacent nodes with the same color
            if (adjacencyMatrix[nodeIndex][i] == 1 && colorIndex == colors[i]) {
                return false;
            }
        }

        return true;
    }

    private void showResults() {
        for (int i = 0; i < numOfVertices; i++) {
            System.out.println("Node " + (i + 1) + " has color index: " + colors[i]);
        }
    }
}
