package hamiltoniancycle;

public class HamiltonianCycle {

    private int numOfVertex;
    private int[] hamiltonianPath;
    private int[][] adjacencyMatrix;

    public HamiltonianCycle(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.hamiltonianPath = new int[adjacencyMatrix.length];
        this.numOfVertex = adjacencyMatrix.length;

        // we are going to assign indexes to every vertex
        this.hamiltonianPath[0] = 0;
    }

    public void solve() {
        // start with the second vertex because first is already checked
        if (findFeasibleSolution(1)) {
            showHamiltonianPath();
        } else {
            System.out.println("No feasible solution...");
        }
    }

    private boolean findFeasibleSolution(int position) {
        if (position == numOfVertex) {
            // if the last vertex in the path is connected to the first vertex
            // it is only a Hamiltonian cycle if it forms a closed loop or else it is just a Hamiltonian path
            return adjacencyMatrix[hamiltonianPath[position - 1]][hamiltonianPath[0]] == 1;
        }

        for(int vertexIndex = 1; vertexIndex < numOfVertex; ++vertexIndex) {
            if (isFeasible(vertexIndex, position)) {
                hamiltonianPath[position] = vertexIndex;
            }

            if (findFeasibleSolution(position + 1)) {
                return true;
            }

            // backtrack!!
        }

        return false;
    }

    private boolean isFeasible(int vertexIndex, int actualPosition) {
        // first criterion: whether two nodes are connected
        // check if the last vertex on the path is NOT connected to the vertex we are considering
        // if it is NOT connected, we cannot consider it
        if (adjacencyMatrix[hamiltonianPath[actualPosition - 1]][vertexIndex] == 0) {
            return false;
        }

        // second criterion: whether we have visited it or not
        for (int i = 0; i < actualPosition; i++) {
            if (hamiltonianPath[i] == vertexIndex) {
                return false;
            }
        }
        return true;
    }

    private void showHamiltonianPath() {
        System.out.print("Hamiltonian cycle: " );

        for (int j : hamiltonianPath) {
            System.out.print(j + " ");
        }

        System.out.println(hamiltonianPath[0]);
    }
}
