package Dashboard;

import javax.swing.*;
import java.awt.*;

public class DryerBoard extends JPanel {
    String[] bathrooms = {"Bathroom 1","Bathroom 2","Bathroom 3","Bathroom 4"};
    double[] temps = {19,19,19,19};
    boolean[] status = {false,true,false,false,false};
    int[] times = {0,0,0,0};
    static final int WIDTH = 650;

    JPanel screenPanel = new JPanel();

    public DryerBoard() {
        setPreferredSize(new Dimension(WIDTH,580));


        JPanel editSettings = new JPanel();
        editSettings.setPreferredSize(new Dimension(WIDTH,350));
        editSettings.setLayout(new GridLayout(5,1));
        editSettings.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel classLabel = new JLabel("Salles de bains :");
        JLabel tempLabel = new JLabel("Température :");
        JLabel stateLabel = new JLabel("Présence :");
        JLabel durationLabel = new JLabel("Durée (min) :");

        JComboBox<String> comboBox = new JComboBox<>(bathrooms);
        SpinnerModel model = new SpinnerNumberModel((int) temps[0], 1, 40, 0.1);
        SpinnerModel timeModel = new SpinnerNumberModel(times[0], 0, 120, 1);
        JSpinner spinner = new JSpinner(model);
        JSpinner durationSpinner = new JSpinner(timeModel);
        JCheckBox state = new JCheckBox("serviette");
        JButton applyButton = new JButton("Start");

        // set components size
        classLabel.setPreferredSize(new Dimension(WIDTH/3,30));
        tempLabel.setPreferredSize(new Dimension(WIDTH/3,30));
        stateLabel.setPreferredSize(new Dimension(WIDTH/3,30));
        durationLabel.setPreferredSize(new Dimension(WIDTH/3,30));

        comboBox.setPreferredSize(new Dimension(WIDTH/2,30));
        //spinner.setPreferredSize(new Dimension(WIDTH/2,30));
        //state.setPreferredSize(new Dimension(WIDTH/2,30));
        applyButton.setPreferredSize(new Dimension(WIDTH/3,30));


        // add listener to all needed
        comboBox.addItemListener(e -> {
             int index = findIndex(comboBox.getSelectedItem().toString());
             spinner.setValue(temps[index]);
             state.setSelected(status[index]);
        });

        applyButton.addActionListener(e -> {
           if(state.isSelected() & Double.parseDouble(durationSpinner.getValue().toString())!=0){
               int index = findIndex(comboBox.getSelectedItem().toString());
               times[index] = (int) durationSpinner.getValue();
               status[index] = true;
               JOptionPane.showMessageDialog(this,
                       "Sèche serviette en marche pour " + durationSpinner.getValue().toString() + " min à " + spinner.getValue() + "°"
               );
               screenPanel.remove(0);
               screenPanel.add(listSettingsData());
               screenPanel.revalidate();
           } else if (!state.isSelected()) {
               JOptionPane.showMessageDialog(this,
                       "Veuillez ajouter votre serviette ","Serviette not found", JOptionPane.ERROR_MESSAGE
               );
           }else if(Double.parseDouble(durationSpinner.getValue().toString())==0){
               JOptionPane.showMessageDialog(this,
                       "Veuillez préciser la durée du séchage ","Durée obligatoire", JOptionPane.WARNING_MESSAGE
               );
           }
        });

        // create and add for each line a panel with its components

        screenPanel.add(listSettingsData());

        JPanel line1 = new JPanel();
        line1.add(classLabel);
        line1.add(comboBox);

        JPanel line2 = new JPanel();
        line2.add(tempLabel);
        line2.add(spinner);

        JPanel line5 = new JPanel();
        line5.add(durationLabel);
        line5.add(durationSpinner);


        JPanel line3 = new JPanel();
        line3.add(stateLabel);
        line3.add(state);

        JPanel line4 = new JPanel();
        line4.add(applyButton);


        editSettings.add(line1);
        editSettings.add(line2);
        editSettings.add(line5);
        editSettings.add(line3);
        editSettings.add(line4);

        JPanel display = new JPanel();
        display.setPreferredSize(new Dimension(WIDTH-20,600));
        display.setLayout(new GridLayout(2,1));
        display.add(editSettings);
        display.add(screenPanel);
        add(display);

    }

    public JPanel listSettingsData(){
        JPanel display = new JPanel();
        display.setLayout(new BoxLayout(display,BoxLayout.Y_AXIS));
        display.setPreferredSize(new Dimension(WIDTH-20,300));

        JLabel title = new JLabel("Dernière activités :");
        title.setFont(title.getFont().deriveFont(Font.BOLD));
        title.setFont(new Font("Arial",Font.BOLD,20));
        display.add(title);
        display.add(Box.createRigidArea(new Dimension(0, 10)));
        for( int i=0; i<bathrooms.length; i++){
            JLabel label = new JLabel("Sèche serviette de "+bathrooms[i] + (status[i] ? " a été utiliser à " + temps[i] + "° pendant " + times[i] + " min" : " est off"));
            display.add(label);
            display.add(Box.createRigidArea(new Dimension(0, 5)));
        }
        return display;
    }

    public int findIndex(String s) {
        int len = bathrooms.length;
        int i = 0;

        while (i < len) {

            if (bathrooms[i].equals(s)) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return len;
    }
}
