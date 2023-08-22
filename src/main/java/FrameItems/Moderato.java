package FrameItems;

import javax.swing.*;
import java.awt.*;

public class Moderato extends JRadioButton {
    private JRadioButton moderato;
    public Moderato(){
        moderato = new JRadioButton();
        moderato.setBounds(190, 670, 180, 50);
        moderato.setText("Moderato (medium)");
        moderato.setFocusable(false);
        moderato.setEnabled(true);
        moderato.setVisible(true);
        moderato.setFont(new Font("Comic Sans", 1, 16));
    }
    public JRadioButton getModerato() {
        return moderato;
    }
}
