package Dashboard;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanningRadiator extends JPanel {

    static final  int WIDTH = 630;
    static final String[] days = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};

    public PlanningRadiator() {
        setPreferredSize(new Dimension(WIDTH,580));
        //setLayout(new GridLayout(2,1));


        JPanel editPlanning = new JPanel();
        editPlanning.setPreferredSize(new Dimension(WIDTH,250));
        editPlanning.setLayout(new GridLayout(4,1));
        editPlanning.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel dayLabel = new JLabel("Jour :");
        JLabel startLabel = new JLabel("Heure démmarrage :");
        JLabel endLabel = new JLabel("Heure d'arrêt :");

        // edits components
        JComboBox dayComboBox = new JComboBox(days);

        DateFormat dateFormat = new SimpleDateFormat("hh:mm");
        JFormattedTextField startDate = new JFormattedTextField(dateFormat);
        startDate.setName("startDate");
        startDate.setValue(new Date());

        JFormattedTextField endDate = new JFormattedTextField(dateFormat);
        endDate.setName("endDate");
        endDate.setValue(new Date());

        JButton applyButton = new JButton("Apply");

        // set components size
        dayLabel.setPreferredSize(new Dimension(WIDTH/3,30));
        startLabel.setPreferredSize(new Dimension(WIDTH/3,30));
        endLabel.setPreferredSize(new Dimension(WIDTH/3,30));
        applyButton.setPreferredSize(new Dimension(WIDTH/3,30));

        dayComboBox.setPreferredSize(new Dimension(WIDTH/4,30));
        //startDate.setPreferredSize(new Dimension(WIDTH/2,30));
        //endDate.setPreferredSize(new Dimension(WIDTH/2,30));

        // create and add for each line a panel with its components
        JPanel line1 = new JPanel();
        line1.add(dayLabel);
        line1.add(dayComboBox);

        JPanel line2 = new JPanel();
        line2.add(startLabel);
        line2.add(startDate);

        JPanel line3 = new JPanel();
        line3.add(endLabel);
        line3.add(endDate);

        JPanel line4 = new JPanel();
        line4.add(applyButton);


        // add line to editPlanning
        editPlanning.add(line1);
        editPlanning.add(line2);
        editPlanning.add(line3);
        editPlanning.add(line4);


        add(editPlanning);
        add(listPlanningsData());

    }

    public JPanel listPlanningsData(){
        JPanel display = new JPanel();
        display.setLayout(new BoxLayout(display,BoxLayout.Y_AXIS));
        display.setPreferredSize(new Dimension(WIDTH,300));

        JLabel title = new JLabel("Planifications :");
        title.setFont(title.getFont().deriveFont(Font.BOLD));
        title.setFont(new Font("Arial",Font.BOLD,20));
        display.add(title);
        display.add(Box.createRigidArea(new Dimension(0, 15)));
        for( String s : days){
            JLabel label = new JLabel(s);
            display.add(label);
            display.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        return display;
    }

}
