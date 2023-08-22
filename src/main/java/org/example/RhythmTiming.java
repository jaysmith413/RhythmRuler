package org.example;

import Notes.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RhythmTiming {
    private final int INSTRUMENT_DRUM = 9;
    private final int MAX_VOLUME = 127;
    private final double adagioModifier = 1;
    private final double moderatoModifier = .75;
    private final double allegroModifier = .5;
    private double selectedTempo = adagioModifier;
    private long startTime;
    private List<Long> correctTimeStamps = new ArrayList<>();
    private Map<Integer, List<Note>> exerciseMap;
    public RhythmTiming(Map<Integer, List<Note>> exerciseMap){
        this.exerciseMap = exerciseMap;
    }
    public List<Long> getCorrectTimeStamps() {
        return correctTimeStamps;
    }
    public long getStartTime() {
        return startTime;
    }
    public double getAdagioModifier() {
        return adagioModifier;
    }
    public double getModeratoModifier() {
        return moderatoModifier;
    }
    public double getAllegroModifier() {
        return allegroModifier;
    }
    public double getSelectedTempo() {
        return selectedTempo;
    }
    public void clearCorrectTimeStamps(){
        this.correctTimeStamps = new ArrayList<>();
    }
    public void setCorrectTimeStamps(int exerciseNumber, int numberOfCounts) {
        long firstCorrectTimeStamp = this.startTime + 1000 + (long)(numberOfCounts * 1200 * this.selectedTempo);

        this.correctTimeStamps.add(firstCorrectTimeStamp);
        for(int i = 0; i < exerciseMap.get(exerciseNumber).size(); i++){
            this.correctTimeStamps.add((long)(exerciseMap.get(exerciseNumber).get(i).getDefaultDurationInMs() *
                    this.selectedTempo) + correctTimeStamps.get(i)); //organize durations for rhythm exercise
        }
    }
    public void setSelectedTempo(double selectedTempo) {
        this.selectedTempo = selectedTempo;
    }
    public void setUpCountOff(double tempoModifier, int numberOfCounts){
        int volume = MAX_VOLUME;
        MusicPlayer player = new MusicPlayer(INSTRUMENT_DRUM, volume);
        this.startTime = player.playCountoff(tempoModifier, numberOfCounts); //returns start time of method
    }
    public void playExercise(int exerciseNumber, double tempoModifier, int numberOfCounts){
        MusicPlayer player = new MusicPlayer(INSTRUMENT_DRUM, MAX_VOLUME);
        player.playExercise(exerciseMap, exerciseNumber, tempoModifier, numberOfCounts);
    }
}
