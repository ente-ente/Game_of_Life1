package life;

public class Universe {
    private Generation currentGeneration;
    private int dimension;
    private int generationNumber;

    public Universe(int dimension) {
        this.currentGeneration = new Generation(dimension);
        this.dimension = dimension;
        generationNumber = 1;
    }

    public int advance() {
        this.currentGeneration = Algorithm.getNextGeneration(currentGeneration);
        generationNumber++;
        return generationNumber;
    }

    public Generation getCurrentGeneration() {
        return currentGeneration;
    }

    public int getGenerationNumber() {
        return generationNumber;
    }
}