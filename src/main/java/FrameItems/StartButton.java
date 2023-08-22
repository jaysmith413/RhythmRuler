package FrameItems;

import javax.swing.*;
import java.awt.*;

public class StartButton extends JButton {
    private JButton startButton;

    public StartButton(){
        startButton = new JButton();
        startButton.setBounds(50, 600, 100, 50);
        startButton.setText("Start");
        startButton.setFocusable(false);
        startButton.setEnabled(true);
        startButton.setVisible(true);
        startButton.setFont(new Font("Comic Sans", 1, 16));
        this.startButton = startButton;
    }

    public JButton getStartButton() {
        return startButton;
    }
}
