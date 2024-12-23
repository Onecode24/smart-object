package Dashboard;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

   JPanel mainPanel = new JPanel();
   Container radiatorContainer = new JPanel();

   public Main(){
       setTitle("Dashboard");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(800, 600);
       setLocationRelativeTo(null);
       setResizable(false);
       setVisible(true);

       mainPanel.setSize(650,600);
       mainPanel.add(setRadiatorBoard());

       add(sideMenuBar(), BorderLayout.WEST);
       add(mainPanel, BorderLayout.CENTER);
   }

   public JPanel sideMenuBar(){
       JButton radiatorButton = new JButton("Radiateur");
       JButton dryerButton = new JButton("Sèche cheveux");

       radiatorButton.addActionListener(e -> {
          mainPanel.remove(0);
           mainPanel.add(setRadiatorBoard());
           mainPanel.revalidate();
       });

       dryerButton.addActionListener(e -> {
           System.out.println("Dryer cheveux");
           mainPanel.remove(0);
           mainPanel.add(setDryerBoard());
           mainPanel.revalidate();
       });

       JPanel containerMenu = new JPanel();
       containerMenu.setLayout(new GridLayout(5, 1));
       containerMenu.add(new JPanel());
       containerMenu.add(radiatorButton);
       containerMenu.add(new JPanel());
       containerMenu.add(dryerButton);
       containerMenu.add(new JPanel());
       containerMenu.setPreferredSize( new Dimension(150,this.getHeight()));
       return containerMenu;
   }

   public JPanel setRadiatorBoard(){
       JPanel radiatorBoard = new JPanel();
       radiatorBoard.setLayout(new BorderLayout());
       radiatorBoard.setSize(new Dimension(650,600));


       JPanel menuBar = new JPanel();
       JButton settingButton = new JButton("Réglage");
       JButton planningButton = new JButton("Planification");
       settingButton.setPreferredSize(new Dimension(radiatorBoard.getWidth()/2,20));
       planningButton.setPreferredSize(new Dimension(radiatorBoard.getWidth()/2,20));
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
       radiatorBoard.add(menuBar, BorderLayout.NORTH);
       radiatorBoard.add(radiatorContainer, BorderLayout.CENTER);

       return radiatorBoard;
   }
    public JPanel setDryerBoard(){
        JPanel dryerBoard = new JPanel();
        dryerBoard.setBackground(Color.WHITE);
        dryerBoard.setPreferredSize(getMaximumSize());
        dryerBoard.add(new JLabel("Seche cheveux"));
        return dryerBoard;
    }

}


