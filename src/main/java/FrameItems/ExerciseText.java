package FrameItems;

import javax.swing.*;
import java.awt.*;

public class ExerciseText {
    private JLabel exerciseText;
    public ExerciseText(int exerciseNumber){
        exerciseText = new JLabel();
        exerciseText.setEnabled(true);
        exerciseText.setBounds(350, -250, 250, 600);
        exerciseText.setFont(new Font("Comic Sans", 1, 32));
        exerciseText.setForeground(Color.RED);
        exerciseText.setText("Exercise " + exerciseNumber);
    }

    public JLabel getExerciseText() {
        return exerciseText;
    }
}
