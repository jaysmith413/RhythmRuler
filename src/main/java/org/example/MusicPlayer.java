package org.example;

import Notes.Note;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.List;
import java.util.Map;


public class MusicPlayer {

    private final String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    private Synthesizer synth;
    private MidiChannel[] channels;
    private int instrument;
    private int volume;
    public MusicPlayer(int instrument, int volume) {
        this.instrument = instrument;
        this.volume = volume;
        openSynth();
    }
    private static void rest(int duration) throws InterruptedException {
        Thread.sleep(duration);
    }
    private void playNote(String note, int durationMs) throws InterruptedException {
        playNote(note, this.volume, durationMs);
    }
    private void playNote(String note, int volume, int durationMs) throws InterruptedException {
        int octave = Integer.parseInt(note.substring(note.length() - 1));
        int tone = note.length() > 2 ? getToneIndex(note.substring(0, 2)) : getToneIndex(note.substring(0, 1));
        int midi_note = 12 + (12 * octave) + tone;
        /*
         * Play note for duration using Thread.sleep, then turn off note
         */
        channels[this.instrument].noteOn(midi_note, volume );
        Thread.sleep( durationMs );
        channels[this.instrument].noteOff(midi_note);
    }
    private Integer getToneIndex(String note){
        Integer toneIndex = null;
        for(int i = 0; i < notes.length; i++){
            if( notes[i].equals(note) ){
                toneIndex = i;
                break;
            }
        }
        return toneIndex;
    }

    private void openSynth(){
        try {
            this.synth = MidiSystem.getSynthesizer();
            this.synth.open();
            this.channels = synth.getChannels();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }
    private void closeSynth(){
        if(synth != null && synth.isOpen()) {
            synth.close();
        }
    }
    public long playCountoff(double tempoModifier, int numberOfCounts) {
        long startTime;

        try{
            startTime = System.currentTimeMillis();
            rest(1000);
            playNote("G4", (int)(1200 * tempoModifier));
            playNote("G4", (int)(1200 * tempoModifier));
            playNote("G4", (int)(1200 * tempoModifier));
            if(numberOfCounts == 4) {
                playNote("G4", (int) (1200 * tempoModifier));
                //closeSynth();
            }
            return startTime;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void playExercise(Map<Integer, List<Note>> exerciseMap, int exerciseNumber, double tempoModifier, int numberOfCounts){
        playCountoff(tempoModifier, numberOfCounts);
        try{
            for(Note eachNote : exerciseMap.get(exerciseNumber)){
                playNote("C4", (int)(eachNote.getDefaultDurationInMs() * tempoModifier));
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
