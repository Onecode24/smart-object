package Input;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class JInput  extends JTextField implements KeyListener {
    public JInput(String label ) {
        super(label);
        setColumns(20);
        addKeyListener(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        if(this.getText().toLowerCase().equals("your email") || this.getText().toLowerCase().equals("your password")){
            this.setText("");
            return;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
