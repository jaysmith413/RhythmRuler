package org.example;

import FrameItems.*;
import Notes.HalfNote;
import Notes.Note;
import Notes.QuarterNote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MyFrame extends JFrame implements ActionListener {
    private JButton actionButton;
    private ActionButton actionButtonSetup;
    private JButton startButton;
    private StartButton startButtonSetup = new StartButton();
    private JButton nextButton;
    private NextButton nextButtonSetup = new NextButton();
    private JButton previousButton;
    private PreviousButton previousButtonSetup = new PreviousButton();
    private JButton playExercise;
    private PlayExercise playExerciseSetup = new PlayExercise();
    private JLabel score;
    private Score scoreSetup = new Score();
    private JRadioButton adagio;
    private Adagio adagioSetup = new Adagio();
    private JRadioButton moderato;
    private Moderato moderatoSetup = new Moderato();
    private JRadioButton allegro;
    private Allegro allegroSetup = new Allegro();
    private JTextArea instructions;
    private Instructions instructionsSetup;
    private ButtonGroup tempo;
    private JLabel exerciseText;
    private ExerciseText exerciseTextSetup;
    private List<Long> timeStamps = new ArrayList<>();
    private int exerciseNumber = 1;
    private int numberOfCounts = 4;
    private long startTime;
    private RhythmExercise exercise = new RhythmExercise();
    private ImageIcon icon;
    private ExerciseImage iconSetup;
    private RhythmTiming rhythmTiming;
    private ImageIcon frameImage = new ImageIcon("src/Exercise1.jpeg");
    public MyFrame(RhythmExercise exercise){

        this.exercise = exercise;
        rhythmTiming = new RhythmTiming(exercise.getExerciseMap());
        iconSetup = new ExerciseImage(exerciseNumber);
        icon = iconSetup.getIcon();
        actionButtonSetup = new ActionButton(icon);
        actionButton = actionButtonSetup.getActionButton();
        actionButton.addActionListener(this);
        startButton = startButtonSetup.getStartButton();
        startButton.addActionListener(this);
        instructionsSetup = new Instructions(numberOfCounts);
        instructions = instructionsSetup.getInstructions();
        nextButton = nextButtonSetup.getNextButton();
        nextButton.addActionListener(this);
        previousButton = previousButtonSetup.getPreviousButton();
        previousButton.addActionListener(this);
        score = scoreSetup.getScore();
        exerciseTextSetup = new ExerciseText(exerciseNumber);
        exerciseText = exerciseTextSetup.getExerciseText();
        playExercise = playExerciseSetup.getPlayExercise();
        playExercise.addActionListener(this);
        adagio = adagioSetup.getAdagio();
        adagio.addActionListener(this);
        moderato = moderatoSetup.getModerato();
        moderato.addActionListener(this);
        allegro = allegroSetup.getAllegro();
        allegro.addActionListener(this);
        setupTempo();

        this.setIconImage(frameImage.getImage());
        this.setTitle("Rhythm Ruler");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1024, 768);
        this.setVisible(true);
        this.add(actionButton);
        this.add(startButton);
        this.add(nextButton);
        this.add(previousButton);
        this.add(score);
        this.add(exerciseText);
        this.add(adagio);
        this.add(moderato);
        this.add(allegro);
        this.add(playExercise);
        this.add(instructions);
        this.setBackground(Color.black);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.decode("#FFFDE7"));
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== actionButton){
            this.timeStamps.add(e.getWhen());

            if(this.timeStamps.size() == rhythmTiming.getCorrectTimeStamps().size() - 1){
                endOfExercise();
            }
        }
        if(e.getSource() == startButton){
            if(exerciseNumber < 6 || exerciseNumber > 10) {
                numberOfCounts = 4;
            } else {
                numberOfCounts = 3;
            }
            startOfExercise();
        }
        if(e.getSource() == nextButton){
            nextButtonAction();
        }
        if(e.getSource() == previousButton){
            previousButtonAction();
        }
        setTempo();
        if(e.getSource() == playExercise){
            if(exerciseNumber >= 6 && exerciseNumber < 10){
                numberOfCounts = 3;
            } else{
                numberOfCounts = 4;
            }
            rhythmTiming.playExercise(exerciseNumber, rhythmTiming.getSelectedTempo(), numberOfCounts);
        }
    }
    public void nextButtonAction(){
        if(exerciseNumber < 15) {
            exerciseNumber++;
        }
        exerciseText.setText("Exercise " + exerciseNumber);
        updateInstructionText();
        setExerciseImage();
    }
    public void previousButtonAction(){
        if(exerciseNumber > 1) {
            exerciseNumber--;
        }
        exerciseText.setText("Exercise " + exerciseNumber);
        updateInstructionText();
        setExerciseImage();
    }
    public void setupTempo() {
        tempo = new ButtonGroup();
        tempo.add(adagio);
        tempo.add(moderato);
        tempo.add(allegro);
        tempo.setSelected(adagio.getModel(), true);
    }
    public void startOfExercise(){
        score.setEnabled(false);
        actionButton.setEnabled(true);
        rhythmTiming.setUpCountOff(rhythmTiming.getSelectedTempo(), numberOfCounts);
        rhythmTiming.clearCorrectTimeStamps();
        rhythmTiming.setCorrectTimeStamps(exerciseNumber, numberOfCounts);
        startTime = rhythmTiming.getStartTime();
    }
    public void endOfExercise(){
        actionButton.setEnabled(false);
        Grader exerciseGrader = new Grader(rhythmTiming.getCorrectTimeStamps(), this.timeStamps);
        String exerciseScore = exerciseGrader.calculateInputDurations();
        this.score.setEnabled(true);
        this.score.setText(exerciseScore);
        this.timeStamps = new ArrayList<>(); // reset inputs
    }
    public void updateInstructionText(){
        if(exerciseNumber > 5 && exerciseNumber <= 10){
            numberOfCounts = 3;
        } else{
            numberOfCounts = 4;
        }
        instructionsSetup.setText(numberOfCounts);
        instructions = instructionsSetup.getInstructions();
    }
    public void setTempo(){
        if(adagio.isSelected()){
            rhythmTiming.setSelectedTempo(rhythmTiming.getAdagioModifier());
        }
        if(moderato.isSelected()){
            rhythmTiming.setSelectedTempo(rhythmTiming.getModeratoModifier());
        }
        if(allegro.isSelected()){
            rhythmTiming.setSelectedTempo(rhythmTiming.getAllegroModifier());
        }
    }
    public void setExerciseImage(){
        iconSetup = new ExerciseImage(exerciseNumber);
        icon = iconSetup.getIcon();
        actionButton.setIcon(icon);
        actionButton.setDisabledIcon(icon);
    }
}

