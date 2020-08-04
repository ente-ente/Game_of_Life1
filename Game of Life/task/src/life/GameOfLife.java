package life;

import javax.swing.*;
import java.awt.event.ItemEvent;

public class GameOfLife extends JFrame {
    private Universe life;
    private final JLabel generationLabel;
    private final JLabel aliveLabel;
    private final FieldPanel fieldPanel;
    private final JToggleButton playToggleButton;
    private Timer timer;

    public GameOfLife() {
        super("Game Of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 750);
        JPanel box = new JPanel();
        JButton resetButton = new JButton("reset");
        resetButton.setName("ResetButton");
        resetButton.addActionListener(actionEvent -> {
            timer.stop();
            startAnimation();
        });
        playToggleButton = new JToggleButton("pause");
        playToggleButton.setName("PlayToggleButton");
        playToggleButton.addItemListener(itemEvent -> {
            int state = itemEvent.getStateChange();
            if (state == ItemEvent.SELECTED) {
                timer.stop();
                playToggleButton.setText("resume");
            }
            else {
                playToggleButton.setText("pause");
                timer.restart();
            }
        });
        JPanel header = new JPanel();
        header.setName("Header");
        header.setLayout(new BoxLayout(header, BoxLayout.PAGE_AXIS));
        generationLabel = new JLabel("Generation #0");
        generationLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        generationLabel.setName("GenerationLabel");
        header.add(generationLabel);

        aliveLabel = new JLabel("Alive: 0");
        aliveLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        aliveLabel.setName("AliveLabel");
        header.add(aliveLabel);
        JPanel buttonBox = new JPanel();
        buttonBox.add(resetButton);
        buttonBox.add(playToggleButton);
        header.add(buttonBox);
        box.add(header);
        boolean[][] state = new boolean[1][1];
        fieldPanel = new FieldPanel(state);
        box.add(fieldPanel);
        add(box);
        setVisible(true);
        startAnimation();
    }

    public void startAnimation() {
        int dimension = 150;
        life = new Universe(dimension);
        this.setGenerationLabel(life.getGenerationNumber());
        this.setAliveLabel(life.getCurrentGeneration().getNumberOfAliveCells());
        this.draw(life.getCurrentGeneration().getField());
        this.revalidate();
        this.repaint();
        final int interval = 500;
        timer = new Timer(interval, evt -> {
            life.advance();
            this.setGenerationLabel(life.getGenerationNumber());
            this.setAliveLabel(life.getCurrentGeneration().getNumberOfAliveCells());
            this.draw(life.getCurrentGeneration().getField());
            this.revalidate();
            this.repaint();
        });
        timer.start();
    }

    public void setGenerationLabel(int numOfGen) {
        generationLabel.setText("Generation #" + numOfGen);
    }

    public void setAliveLabel(int numAlive) {
        aliveLabel.setText("Alive: " + numAlive);
    }

    public void draw(boolean[][] state) {
        fieldPanel.setState(state);
        fieldPanel.repaint();
    }

    public static void main(String[] args) {
        new GameOfLife();
    }
}