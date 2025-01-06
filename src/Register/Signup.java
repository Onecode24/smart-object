package Register;
import Dashboard.Main;
import Input.JInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Signup extends JFrame implements MouseListener {
    JButton loginButton = new JButton("signup");
    JLabel labelLogin = new JLabel("Déjà un compte ? Login :");
    JInput emailInput = new JInput("Your email");
    JInput passwordInput = new JInput("Your password");

    public Signup(){
        setTitle("SignUp");
        setSize(500,500);
        setLayout(new GridLayout(5,1,10,10));

        // Inits components
        JLabel title = new JLabel("Creation de compte");
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


    public void actionPerformed(ActionEvent e){

        //System.out.println("Login clicked");

    }

    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == loginButton){
            if(emailInput.getText().equals("") || passwordInput.getText().equals("") || emailInput.getText().equals("Your email") || passwordInput.getText().equals("Your password")){
                JOptionPane.showMessageDialog(this, "Veuillez entrer un mail et mot de passe.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }else{
                 try{
                    saveUserCredentials(emailInput.getText(),passwordInput.getText());
                     JOptionPane.showMessageDialog(this, "Compte creer.");
                    this.dispose();
                    new Main().setVisible(true);
                }catch(IOException ex){
                    throw new RuntimeException(ex);
                }
            }

        }else if(e.getSource() == labelLogin){
            this.dispose();
            new Login();
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


    public void saveUserCredentials(String username, String password) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true));
        writer.write(username);
        writer.newLine();
        writer.write(password);
        writer.newLine();
        writer.flush();
        writer.close();

    }

}

