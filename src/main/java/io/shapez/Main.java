package io.shapez;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {
    Application app = new Application(this);
    long tick = 0L;

    public Main() {
        app.boot();
        Thread animationThread = new Thread(() -> {
            while (true) {
                update();
                repaint();
                try {
                    Thread.sleep(1000 / 60);
                } catch (InterruptedException ignored) {
                }
            }
        });
        animationThread.start();
    }

    private void update() {
        app.ticker.handleAnimationFrame(tick);
        app.onFrameEmitted(System.nanoTime());
        app.onBackgroundFrame(System.nanoTime());
        app.ticker.handleBackgroundTick();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
//        Graphics2D g2d = (Graphics2D) g;
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Shapez.io");
            frame.setContentPane(new Main());
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
