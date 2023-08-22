package FrameItems;

import javax.swing.*;
import java.awt.*;

public class Score {
    private JLabel score;
    public Score(){
        score = new JLabel();
        score.setEnabled(false);
        score.setBounds(800, 200, 250, 550);
        score.setFont(new Font("Comic Sans", 1, 32));
        score.setForeground(Color.RED);
    }

    public JLabel getScore() {
        return score;
    }
}
