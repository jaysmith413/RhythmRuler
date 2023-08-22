package FrameItems;

import javax.swing.*;
import java.awt.*;

public class PlayExercise extends JButton {
    private JButton playExercise;
    public PlayExercise(){
        playExercise = new JButton();
        playExercise.setBounds(550, 600, 200, 50);
        playExercise.setText("Exercise Playback");
        playExercise.setFocusable(false);
        playExercise.setEnabled(true);
        playExercise.setVisible(true);
        playExercise.setFont(new Font("Comic Sans", 1, 16));
    }

    public JButton getPlayExercise() {
        return playExercise;
    }
}
