package org.example;

public class RhythmAppMain {
    public static void main(String[] args) {
        RhythmExercise exercise = new RhythmExercise();
        exercise.populateExerciseList();
        new MyFrame(exercise);
    }
}


