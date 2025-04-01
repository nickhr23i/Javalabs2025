import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    private int canvasWidth = 400, canvasHeight = 400;
    private int dotSize = 20;
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        g.setColor(Color.BLACK);
        g.drawOval(20,20,dotSize,dotSize);
        g.drawOval(20,90,dotSize,dotSize);
        g.drawOval(70,50,dotSize,dotSize);
        g.drawOval(120,120,dotSize,dotSize);
        g.drawOval(250,270,dotSize,dotSize);
    }
}
