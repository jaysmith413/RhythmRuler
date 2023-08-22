package org.example;
import Notes.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RhythmExercise {
    private Map<Integer, List<Note>> exerciseMap = new HashMap<>();
    private List<Note> notesList = new ArrayList<>();

    public Map<Integer, List<Note>> getExerciseMap() {
        return exerciseMap;
    }
    public Map<Integer, List<Note>> populateExerciseList(){
        //read from file
        File inputFile = new File("rhythms.txt");
        int measureCounter = 1;
        int exerciseCounter = 1;

        try (Scanner inputScanner = new Scanner(inputFile)){
            while(inputScanner.hasNextLine()){
                String lineInput = inputScanner.nextLine();
                String[] noteNames = lineInput.split(" ");

                if(noteNames[1].equals("2/4")) {
                    for (int i = 2; i < noteNames.length; i++) {
                        addNotesToList(i, noteNames);
                    }
                    if (measureCounter == 4) {
                        exerciseMap.put(exerciseCounter, notesList);
                        notesList = new ArrayList<>();
                        measureCounter = 0;
                        exerciseCounter++;
                    }
                    measureCounter++;
                } else{
                    for (int i = 2; i < noteNames.length; i++) {
                        addNotesToList(i, noteNames);
                    }
                    if (measureCounter == 2){
                        exerciseMap.put(exerciseCounter, notesList);
                        notesList = new ArrayList<>();
                        measureCounter = 0;
                        exerciseCounter++;
                    }
                    measureCounter++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return exerciseMap;
    }
    public void addNotesToList(int i, String[] noteNames){
        if(noteNames[i].equals("Whole")){
            notesList.add(new WholeNote());
        } else if(noteNames[i].equals("DottedHalf")){
            notesList.add(new DottedHalfNote());
        } else if(noteNames[i].equals("Half")) {
            notesList.add(new HalfNote());
        } else if(noteNames[i].equals("DottedQuarter")) {
            notesList.add(new DottedQuarterNote());
        } else if(noteNames[i].equals("Quarter")) {
            notesList.add(new QuarterNote());
        } else if(noteNames[i].equals("Eighth")) {
            notesList.add(new EighthNote());
        }
    }

}
