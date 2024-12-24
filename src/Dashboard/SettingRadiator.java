package Dashboard;

import javax.swing.*;
import java.awt.*;

public class SettingRadiator extends JPanel {
    String[] classOptions = {"Info 1","Info 2","Info 3","Info 4", "Info 5", "Info 6", "Info 7", "TD 3", "TD 5", "TD 7"};
    static final int WIDTH = 630;
    public SettingRadiator() {
        setPreferredSize(new Dimension(WIDTH,580));


        JPanel editSettings = new JPanel();
        editSettings.setPreferredSize(new Dimension(WIDTH,250));
        editSettings.setLayout(new GridLayout(4,1));
        editSettings.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel classLabel = new JLabel("Salle :");
        JLabel tempLabel = new JLabel("Température :");
        JLabel windowLabel = new JLabel("Window open :");

        JComboBox<String> comboBox = new JComboBox<>(classOptions);
        SpinnerModel model = new SpinnerNumberModel(19, 1, 40, 0.1);
        JSpinner spinner = new JSpinner(model);
        JCheckBox windowOpen = new JCheckBox("open");
        JButton applyButton = new JButton("Apply");

        // set components size
        classLabel.setPreferredSize(new Dimension(WIDTH/3,30));
        tempLabel.setPreferredSize(new Dimension(WIDTH/3,30));
        windowLabel.setPreferredSize(new Dimension(WIDTH/3,30));

        comboBox.setPreferredSize(new Dimension(WIDTH/2,30));
        spinner.setPreferredSize(new Dimension(WIDTH/2,30));
        windowOpen.setPreferredSize(new Dimension(WIDTH/2,30));
        applyButton.setPreferredSize(new Dimension(WIDTH/3,30));

        // create and add for each line a panel with its components
        JPanel line1 = new JPanel();
        line1.add(classLabel);
        line1.add(comboBox);

        JPanel line2 = new JPanel();
        line2.add(tempLabel);
        line2.add(spinner);

        JPanel line3 = new JPanel();
        line3.add(windowLabel);
        line3.add(windowOpen);

        JPanel line4 = new JPanel();
        line4.add(applyButton);


        editSettings.add(line1);
        editSettings.add(line2);
        editSettings.add(line3);
        editSettings.add(line4);

        add(editSettings);
        add(listSettingsData());

    }

    public JPanel listSettingsData(){
        JPanel display = new JPanel();
        display.setLayout(new BoxLayout(display,BoxLayout.Y_AXIS));
        display.setPreferredSize(new Dimension(WIDTH,300));

        JLabel title = new JLabel("Salle :");
        title.setFont(title.getFont().deriveFont(Font.BOLD));
        title.setFont(new Font("Arial",Font.BOLD,20));
        display.add(title);
        display.add(Box.createRigidArea(new Dimension(0, 10)));
        for( String s : classOptions){
            JLabel label = new JLabel(s);
            display.add(label);
            display.add(Box.createRigidArea(new Dimension(0, 5)));
        }
        return display;
    }



}
