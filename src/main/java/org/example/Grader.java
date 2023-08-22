package org.example;

import java.util.ArrayList;
import java.util.List;

public class Grader {
    private List<Long> inputTimestamps = new ArrayList<>();
    private List<Long> correctTimeStamps = new ArrayList<>();
    public Grader(List<Long> correctTimeStamps, List<Long> inputTimeStamps){
        this.inputTimestamps = inputTimeStamps;
        this.correctTimeStamps = correctTimeStamps;
    }
    public String calculateInputDurations(){
        int score = 0;
        for(int i = 0; i < inputTimestamps.size(); i++){
            if(inputTimestamps.get(i) > correctTimeStamps.get(i) - 200 && inputTimestamps.get(i)
            < correctTimeStamps.get(i + 1) + 200){
                score++;
            }
        }
        //compare to RhythmExercise object.getCorrectTimeStamps()
        //first input should be within 200ms correctTimeStamps second input.
        String scorePrintout = "Score: " + score + "/" + (correctTimeStamps.size() - 1);
        return scorePrintout;
    }
}
