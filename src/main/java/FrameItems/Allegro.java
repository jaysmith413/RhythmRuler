package FrameItems;

import javax.swing.*;
import java.awt.*;

public class Allegro extends JRadioButton {
    private JRadioButton allegro;
    public Allegro(){
        allegro = new JRadioButton();
        allegro.setBounds(370, 670, 150, 50);
        allegro.setText("Allegro (fast)");
        allegro.setFocusable(false);
        allegro.setEnabled(true);
        allegro.setVisible(true);
        allegro.setFont(new Font("Comic Sans", 1, 16));
    }

    public JRadioButton getAllegro() {
        return allegro;
    }
}
