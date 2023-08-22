package FrameItems;

import javax.swing.*;
import java.awt.*;

public class Adagio extends JRadioButton {
    private JRadioButton adagio;
    public Adagio(){
        adagio = new JRadioButton();
        adagio.setBounds(50, 670, 140, 50);
        adagio.setText("Adagio (slow)");
        adagio.setFocusable(false);
        adagio.setEnabled(true);
        adagio.setVisible(true);
        adagio.setFont(new Font("Comic Sans", 1, 16));
    }

    public JRadioButton getAdagio() {
        return adagio;
    }
}
