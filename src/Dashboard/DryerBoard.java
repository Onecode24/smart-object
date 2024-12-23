package Dashboard;

import javax.swing.*;
import java.awt.*;

public class DryerBoard extends JPanel {
    public DryerBoard() {
        this.setBackground(Color.WHITE);
        this.setPreferredSize(getMaximumSize());
        this.add(new JLabel("Seche cheveux"));

    }
}
