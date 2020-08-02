package life;

import java.util.Random;

public class Generation {
    private int numberOfAliveCells;
    private final boolean[][] field;

    public Generation(int numberOfAliveCells, boolean[][] field) {
        this.numberOfAliveCells = numberOfAliveCells;
        this.field = field.clone();
    }

    public int getNumberOfAliveCells() {
        return numberOfAliveCells;
    }

    public Generation(int dimension) {
        Random random = new Random();
        this.field = new boolean[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (random.nextBoolean()) {
                    numberOfAliveCells++;
                    this.field[i][j] = true;
                }
            }
        }
    }

    public boolean[][] getField() {
        return field.clone();
    }
}