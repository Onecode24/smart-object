package Register;
import Dashboard.Main;
import Input.JInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Login extends JFrame implements MouseListener {
    JButton loginButton = new JButton("Login");
    JLabel labelLogin = new JLabel("Vous n'avez pas de compte ? SignUp :");
    JInput emailInput = new JInput("Your email");
    JInput passwordInput = new JInput("Your password");

    public Login(){
        setTitle("Login");
        setSize(500,500);
        setLayout(new GridLayout(5,1,10,10));

        // Inits components
        JLabel title = new JLabel("Connexion");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("DejaVu Sans", Font.BOLD, 25));

        JLabel emailLabel = new JLabel("Email :");
        JLabel passwordLabel = new JLabel("Password :");



        // set size of components
        emailLabel.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
        emailLabel.setPreferredSize(new Dimension(100,15));
        passwordLabel.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
        passwordLabel.setPreferredSize(new Dimension(100,15));
        passwordInput.setPreferredSize(new Dimension(150,35));
        emailInput.setPreferredSize(new Dimension(150,35));
        loginButton.setPreferredSize(new Dimension(120,35));
        labelLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        labelLogin.setFont(new Font("DejaVu Sans", Font.PLAIN, 13));
        labelLogin.setHorizontalAlignment(SwingConstants.CENTER);


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
        loginButton.addMouseListener(this);
        labelLogin.addMouseListener( this);


        Container contentPane = this.getContentPane();
        // Add elements to the frame
        contentPane.add(title);
        contentPane.add(emailPanel);
        contentPane.add(passwordPanel);
        contentPane.add(buttonPanel);
        contentPane.add(labelLogin);


        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == loginButton){

            if(checkUserInformation(emailInput.getText(),passwordInput.getText())){
                JOptionPane.showMessageDialog(null,"Bienvenue sur Smart Box !");
                this.dispose();
                new Main();
            }else{
                JOptionPane.showMessageDialog(null,"Email ou mot de passe incorrecte", "Erreur", JOptionPane.ERROR_MESSAGE);
            }

        }else if(e.getSource() == labelLogin){
            this.dispose();
            new Signup();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public boolean checkUserInformation(String email, String password){
        // read file users.txt and save each line in an array
        try {
            ArrayList<String> database = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
            while (reader.ready()){
                database.add(reader.readLine());
            }

            for (int i = 0; i < database.size(); i=i+2){
                if(database.get(i).equals(email) && database.get(i+1).equals(password)) return  true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

