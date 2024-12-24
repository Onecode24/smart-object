package Dashboard;

import javax.swing.*;
import java.awt.*;

public class DryerBoard extends JPanel {
    static final int WIDTH = 650;
    public DryerBoard() {
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(WIDTH, 600));
        this.add(new JLabel("Seche serviettes"));
    }
}
