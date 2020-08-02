package life;

public class Universe {
    private Generation currentGeneration;
    private int generationNumber;

    public Universe(int dimension) {
        this.currentGeneration = new Generation(dimension);
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

    public String toString() {
        return "Generation #" + generationNumber + "\n" + currentGeneration.toString();
    }

    public int getGenerationNumber() {
        return generationNumber;
    }
}