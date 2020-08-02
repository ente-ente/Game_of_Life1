package life;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception ex) { ex.printStackTrace(); }
        int dimension = 20;
        Universe life = new Universe(dimension);
        GameOfLife swingView = new GameOfLife();
        swingView.init(dimension);
        swingView.update(life);
        final int interval = 1000;
        var timer = new Timer(interval, evt -> {
            life.advance();
            swingView.update(life);
            swingView.revalidate();
            swingView.repaint();
        });
        timer.start();
    }
}
