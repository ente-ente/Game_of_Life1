package life;
import javax.swing.*;

public class GameOfLife extends JFrame {
    private final JLabel aliveLabel;
    private final JLabel generationLabel;
    private static final int size = 600;
    private GenerationPanel generationPanel;
    private final JPanel box;

    public GameOfLife() {
        super("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel header = new JPanel();
        this.box = new JPanel();
        header.setName("Header");
        header.setLayout(new BoxLayout(header, BoxLayout.PAGE_AXIS));
        aliveLabel = new JLabel("Generation #0");
        generationLabel = new JLabel("Alive: 0");
        generationLabel.setName("GenerationLabel");
        aliveLabel.setName("AliveLabel");
        header.add(aliveLabel);
        header.add(generationLabel);
        box.add(header);
        this.add(box);
        setSize(size, size + 100);
    }

    public void init(int dimension) {
        generationPanel = new GenerationPanel(dimension, size - 10);
        box.add(generationPanel);
        setVisible(true);
    }

    public void update(Universe life) {
        generationLabel.setText("Generation #" + life.getGenerationNumber());
        aliveLabel.setText("Alive: " + life.getCurrentGeneration().getNumberOfAliveCells());
        generationPanel.update(life.getCurrentGeneration());
    }
}