package FrameItems;

import javax.swing.*;
import java.awt.*;

public class Instructions {

    private JTextArea instructions;

    public Instructions(int numberOfCounts) {
        instructions = new JTextArea();
        instructions.setBounds(130,150,650,250);
        setText(numberOfCounts);
        instructions.setFocusable(false);
        instructions.setEnabled(true);
        instructions.setBackground(Color.decode("#FFFDE7"));
        instructions.setVisible(true);
        instructions.setFont(new Font("Comic Sans",1,24));
        instructions.setForeground(Color.BLUE);
    }

    public JTextArea getInstructions() {
        return instructions;
    }

    public void setText(int numberOfCounts){
        instructions.setText("Welcome to Rhythm Ruler!\n\nHow to play:\n 1) Select Tempo at bottom.\n 2) Press start to begin, and you will hear"+
                " a countoff\n    of "+numberOfCounts +" clicks.\n 3) Within the box, click the rhythm displayed.\n");
    }
}
