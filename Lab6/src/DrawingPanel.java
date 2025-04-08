import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    private int canvasWidth = 400, canvasHeight = 400;
    private int dotSize = 20;
    private int dotNumber = 10;
    private Dot selectedDot = null;
    private List<Dot> dots = new ArrayList<>();
    private List<Line> lines = new ArrayList<>();

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        setDotNumber(10);
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        init();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintDots(g);
        paintLines(g);
    }

    final void init() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (Dot d : dots) {
                    if ((e.getX() >= d.getX()) && (e.getX() <= d.getX()+dotSize) && (e.getY() >= d.getY()) && (e.getY() <= d.getY()+dotSize)) {

                        if (selectedDot == null||selectedDot.equals(d)) {
                            selectedDot = d;
                        } else {
                            Line l = new Line(selectedDot, d);
                            lines.add(l);
                            selectedDot = null;
                        }
                        break;
                    }
                }
                repaint();
            }
        });
    }

    public void paintDots(Graphics g) {
        g.setColor(Color.BLACK);
        for (Dot d : dots) {
            g.fillOval(d.getX(), d.getY(), dotSize, dotSize);
        }
    }

    public void paintLines(Graphics g) {
        int ln = 1;
        for (Line l : lines) {
            if (ln % 2 == 1) {
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.RED);
            }
            g.drawLine(l.getD1().getX()+dotSize/2, l.getD1().getY()+dotSize/2, l.getD2().getX()+dotSize/2, l.getD2().getY()+dotSize/2);
            ln++;
        }
    }

    public int getDotNumber() {
        return dotNumber;
    }

    public void setDotNumber(int dotNumber) {
        this.dotNumber = dotNumber;
        dots.clear();
        lines.clear();
        Dot d;
        for (int i = 0; i < dotNumber; i++) {
            d = new Dot(dotSize + (int) (Math.random() * 1000) % (canvasWidth - 2 * dotSize), dotSize + (int) (Math.random() * 1000) % (canvasHeight - 2 * dotSize));
            dots.add(d);
        }
        repaint();
    }
}
