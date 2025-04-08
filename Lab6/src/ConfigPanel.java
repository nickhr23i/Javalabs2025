import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinner;
    JButton gameBtn=new JButton("New Game");
    private int score1;
    private int score2;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        label = new JLabel("Number of dots:");
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        add(label); //JPanel uses FlowLayout by default
        add(spinner);
        add(gameBtn);
        gameBtn.addActionListener(this::newGame);
    }

    private void newGame(ActionEvent e) {
        frame.canvas.setDotNumber((int)spinner.getValue());
        score1=score2=0;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score) {
        this.score1 = score;
        System.out.println(score);
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score) {
        this.score2 = score;
        System.out.println(score);
    }
}
