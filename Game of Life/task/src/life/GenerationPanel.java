package life;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GenerationPanel extends JPanel {
    private final JPanel[][] field;

    public GenerationPanel(int dimension, int size) {
        super(new GridLayout(dimension, dimension));
        this.field = new JPanel[dimension][dimension];
        setPreferredSize(new Dimension(size, size));
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                JPanel cell = new JPanel(new BorderLayout());
                this.field[i][j] = cell;
                add(cell);
                cell.setBorder(new LineBorder(Color.black));
            }
        }
    }

    public void update(Generation generation) {
        for (int i = 0; i < generation.getField().length; i++) {
            boolean[] row = generation.getField()[i];
            for (int j = 0; j < row.length; j++) {
                field[i][j].setBackground(row[j] ? Color.black : Color.white);
            }
        }
    }
}
