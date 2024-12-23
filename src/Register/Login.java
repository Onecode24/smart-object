package Register;
import Dashboard.Main;
import Input.JInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    public Login(){
        setTitle("Login");
        setSize(500,500);
        setLayout(new GridLayout(4,1,10,10));

        // Inits components
        JLabel title = new JLabel("Connexion");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("DejaVu Sans", Font.BOLD, 25));

        JLabel emailLabel = new JLabel("Email :");
        JLabel passwordLabel = new JLabel("Password :");
        JInput emailInput = new JInput("Your email");
        JInput passwordInput = new JInput("Your password");
        JButton loginButton = new JButton("Login");

        // set size of components
        emailLabel.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
        emailLabel.setPreferredSize(new Dimension(100,15));
        passwordLabel.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
        passwordLabel.setPreferredSize(new Dimension(100,15));
        passwordInput.setPreferredSize(new Dimension(150,35));
        emailInput.setPreferredSize(new Dimension(150,35));
        loginButton.setPreferredSize(new Dimension(120,35));


        // add each line in a Panel
        JPanel emailPanel = new JPanel();
        emailPanel.add(emailLabel);
        emailPanel.add(emailInput);

        JPanel passwordPanel = new JPanel();
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordInput);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);


        // add actionperformed to logginButton
        loginButton.addActionListener(this);


        Container contentPane = this.getContentPane();
        // Add elements to the frame
        contentPane.add(title);
        contentPane.add(emailPanel);
        contentPane.add(passwordPanel);
        contentPane.add(buttonPanel);


        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void actionPerformed(ActionEvent e){
        this.dispose();
        new Main();
        System.out.println("Login clicked");

    }

}

