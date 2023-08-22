package FrameItems;

import javax.swing.*;
import java.awt.*;

public class ExerciseImage {
    private ImageIcon icon;
    public ExerciseImage(int exerciseNumber){
        icon = null;
        if(exerciseNumber == 1){
            icon = new ImageIcon("src/Exercise1.jpeg");
        } else if(exerciseNumber == 2){
            icon = new ImageIcon("src/Exercise2.jpeg");
        } else if(exerciseNumber == 3){
            icon = new ImageIcon("src/Exercise3.jpeg");
        } else if(exerciseNumber == 4){
            icon = new ImageIcon("src/Exercise4.jpeg");
        } else if(exerciseNumber == 5){
            icon = new ImageIcon("src/Exercise5.jpeg");
        } else if(exerciseNumber == 6){
            icon = new ImageIcon("src/Exercise6.jpeg");
        } else if(exerciseNumber == 7){
            icon = new ImageIcon("src/Exercise7.jpeg");
        } else if(exerciseNumber == 8){
            icon = new ImageIcon("src/Exercise8.jpeg");
        } else if(exerciseNumber == 9){
            icon = new ImageIcon("src/Exercise9.jpeg");
        } else if(exerciseNumber == 10){
            icon = new ImageIcon("src/Exercise10.jpeg");
        } else if(exerciseNumber == 11){
            icon = new ImageIcon("src/Exercise11.jpeg");
        } else if(exerciseNumber == 12){
            icon = new ImageIcon("src/Exercise12.jpeg");
        } else if(exerciseNumber == 13){
            icon = new ImageIcon("src/Exercise13.jpeg");
        } else if(exerciseNumber == 14){
            icon = new ImageIcon("src/Exercise14.jpeg");
        } else if(exerciseNumber == 15){
            icon = new ImageIcon("src/Exercise15.jpeg");
        }
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(700, 110, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);
    }
    public ImageIcon getIcon() {
        return icon;
    }
}
