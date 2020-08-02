package life;

public class Algorithm {
    public static Generation getNextGeneration(Generation lastGeneration) {
        int numberOfAliveCells = 0;
        int dimension = lastGeneration.getField().length;
        boolean[][] newGeneration = new boolean[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (cellIsAlive(i, j, lastGeneration.getField())) {
                    numberOfAliveCells++;
                    newGeneration[i][j] = true;
                }
            }
        }
        return new Generation(numberOfAliveCells, newGeneration);
    }

    private static boolean cellIsAlive(int rowIndex, int columnIndex, boolean[][] lastGeneration) {
        int dimension = lastGeneration.length;
        int neighborRow;
        int neighborColumn;
        int countAliveNeighbors = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i==0 && j==0) {
                    continue;
                }
                neighborRow = rowIndex + i;
                neighborColumn = columnIndex + j;
                if (neighborRow < 0) { neighborRow = dimension - 1; }
                if (neighborColumn < 0) { neighborColumn = dimension - 1; }
                if (neighborRow == dimension) { neighborRow = 0; }
                if (neighborColumn == dimension) { neighborColumn = 0; }
                if (lastGeneration[neighborRow][neighborColumn]) {
                    countAliveNeighbors++;
                }
            }
        }
        if (lastGeneration[rowIndex][columnIndex]) {
            return countAliveNeighbors == 2 || countAliveNeighbors == 3;
        }
        return countAliveNeighbors == 3;
    }
}