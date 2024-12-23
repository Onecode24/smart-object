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
       mainPanel.add(new RadiatorBoard());

       add(sideMenuBar(), BorderLayout.WEST);
       add(mainPanel, BorderLayout.CENTER);
   }

   public JPanel sideMenuBar(){
       JButton radiatorButton = new JButton("Radiateur");
       JButton dryerButton = new JButton("Sèche cheveux");

       radiatorButton.addActionListener(e -> {
          mainPanel.remove(0);
           mainPanel.add(new RadiatorBoard());
           mainPanel.revalidate();
       });

       dryerButton.addActionListener(e -> {
           System.out.println("Dryer cheveux");
           mainPanel.remove(0);
           mainPanel.add(new DryerBoard());
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


}


