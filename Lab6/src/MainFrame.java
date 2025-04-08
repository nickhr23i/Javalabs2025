import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);

        add(canvas, CENTER); //this is BorderLayout.CENTER
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);

        //invoke the layout manager
        pack();
    }


}
