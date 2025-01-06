package Dashboard;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PlanningRadiator extends JPanel {

    static final  int WIDTH = 630;
    static final String[] days = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
    Date[] startDates = {setTimeFormat(8,45),setTimeFormat(8,45),setTimeFormat(8,45),setTimeFormat(8,45),setTimeFormat(8,45),setTimeFormat(8,45),setTimeFormat(8,45)};
    Date[] endDates = {setTimeFormat(18,30),setTimeFormat(18,30),setTimeFormat(18,30),setTimeFormat(18,30),setTimeFormat(18,30),setTimeFormat(18,30),setTimeFormat(18,30)};

    JPanel screenPanel = new JPanel();

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



        Format dateFormat = DateFormat.getTimeInstance(DateFormat.SHORT);
        JFormattedTextField startDate = new JFormattedTextField(dateFormat);
        startDate.setName("startDate");
        startDate.setValue(startDates[0]);

        JFormattedTextField endDate = new JFormattedTextField(dateFormat);
        endDate.setName("endDate");
        endDate.setValue(endDates[0]);

        JButton applyButton = new JButton("Apply");

        // set components size
        dayLabel.setPreferredSize(new Dimension(WIDTH/3,30));
        startLabel.setPreferredSize(new Dimension(WIDTH/3,30));
        endLabel.setPreferredSize(new Dimension(WIDTH/3,30));
        applyButton.setPreferredSize(new Dimension(WIDTH/3,30));

        dayComboBox.setPreferredSize(new Dimension(WIDTH/4,30));
        //startDate.setPreferredSize(new Dimension(WIDTH/2,30));
        //endDate.setPreferredSize(new Dimension(WIDTH/2,30));


        // add listener to all needed

        dayComboBox.addActionListener(e -> {
            int index = findIndex(dayComboBox.getSelectedItem().toString());
            startDate.setValue(startDates[index]);
            endDate.setValue(endDates[index]);
        });

        applyButton.addActionListener(e -> {
            int index = findIndex(dayComboBox.getSelectedItem().toString());

            startDates[index] = (Date) startDate.getValue();
            endDates[index] = (Date) endDate.getValue();

            screenPanel.remove(0);
            screenPanel.add(listPlanningsData());
            screenPanel.revalidate();

            System.out.println((Date) startDate.getValue() + " -> " + (Date) endDate.getValue());
        });


        // create and add for each line a panel with its components

        screenPanel.add(listPlanningsData());

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
        add(screenPanel);

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

        for (int i = 0; i < days.length; i++) {
            JLabel label = new JLabel(days[i] + "  démarrage à  " + getTimeFromDate(startDates[i]) + "  puis  arrêt  à  " + getTimeFromDate(endDates[i]));
            display.add(label);
            display.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        return display;
    }

    public Date setTimeFormat(int hour, int minute){
        Calendar time = Calendar.getInstance();
        time.set(Calendar.HOUR_OF_DAY,hour);
        time.set(Calendar.MINUTE,minute);
        time.set(Calendar.SECOND,0);
        time.set(Calendar.MILLISECOND,0);
        return time.getTime();
    }

    public int findIndex(String s) {
        int i = 0;

        while (i < days.length) {
            if (days[i].equals(s)) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return days.length;
    }

    public String getTimeFromDate(Date date){
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
        return localDateFormat.format(date);
    }

}
