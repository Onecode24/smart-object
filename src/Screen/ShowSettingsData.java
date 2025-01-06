package Screen;

import javax.swing.*;
import java.awt.*;

public class ShowSettingsData extends JPanel {
    static final int WIDTH = 630;

    public ShowSettingsData( String[] classOptions, double[] temps, boolean[] status ) {

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(WIDTH,300));

        JLabel title = new JLabel("Salle :");
        title.setFont(title.getFont().deriveFont(Font.BOLD));
        title.setFont(new Font("Arial",Font.BOLD,20));
        add(title);
        add(Box.createRigidArea(new Dimension(0, 10)));
        for( int i = 0; i < 10; i++){
            JLabel label = new JLabel(classOptions[i] + " is at " + temps[i] + " degrée and the windows are   " + (status[i] ? "open" : "closed"));
            add(label);
            add(Box.createRigidArea(new Dimension(0, 5)));
        }
    }

}
