package FrameItems;

import javax.swing.*;
import java.awt.*;

public class NextButton extends JButton {
    private JButton nextButton;
    public NextButton(){
        nextButton = new JButton();
        nextButton.setBounds(340, 600, 150, 50);
        nextButton.setText("Next Rhythm");
        nextButton.setFocusable(false);
        nextButton.setEnabled(true);
        nextButton.setVisible(true);
        nextButton.setFont(new Font("Comic Sans", 1, 16));
    }

    public JButton getNextButton() {
        return nextButton;
    }
}
