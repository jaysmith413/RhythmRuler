package FrameItems;

import javax.swing.*;
import java.awt.*;

public class PreviousButton extends JButton {
    private JButton previousButton;
    public PreviousButton(){
        previousButton = new JButton();
        previousButton.setBounds(160, 600, 170, 50);
        previousButton.setText("Previous Rhythm");
        previousButton.setFocusable(false);
        previousButton.setEnabled(true);
        previousButton.setVisible(true);
        previousButton.setFont(new Font("Comic Sans", 1, 16));
    }

    public JButton getPreviousButton() {
        return previousButton;
    }
}
