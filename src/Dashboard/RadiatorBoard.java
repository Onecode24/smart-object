package Dashboard;

import javax.swing.*;
import java.awt.*;

public class RadiatorBoard extends JPanel {

    Container radiatorContainer = new JPanel();

    public RadiatorBoard() {
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(650,600));


        JPanel menuBar = new JPanel();
        JButton settingButton = new JButton("Réglage");
        JButton planningButton = new JButton("Planification");
        settingButton.setPreferredSize(new Dimension(this.getWidth()/2,20));
        planningButton.setPreferredSize(new Dimension(this.getWidth()/2,20));
        //menuBar.setBackground(Color.WHITE);

        settingButton.addActionListener(e -> {
            System.out.println("Setting button clicked");
            radiatorContainer.remove(0);
            radiatorContainer.add(new SettingRadiator());
            radiatorContainer.revalidate();
        });

        planningButton.addActionListener(e -> {
            System.out.println("Planning button clicked");
            radiatorContainer.remove(0);
            radiatorContainer.add(new PlanningRadiator());
            radiatorContainer.revalidate();
        });

        menuBar.add(settingButton);
        menuBar.add(planningButton);


        radiatorContainer.setLayout(new FlowLayout());
        radiatorContainer.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        radiatorContainer.setBackground(Color.WHITE);
        radiatorContainer.setPreferredSize(new Dimension(650,580));
        radiatorContainer.add(new SettingRadiator());
        this.add(menuBar, BorderLayout.NORTH);
        this.add(radiatorContainer, BorderLayout.CENTER);

    }
}
