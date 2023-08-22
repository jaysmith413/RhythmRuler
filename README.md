# Rhythm Ruler

This game allows players to test their rhythm-reading skills across 15 auto-generated rhythms with 3 choices for tempo.

## Project Description

The game presents a windowed user interface on which players can interact. Players can choose between 15 exercises and 3 tempi. When the player selects their options and presses START, a countoff click track plays to signal the beginning of the exercise. The player then clicks the rhythm in time and is graded for their efforts. A score is displayed on the right-hand side after the exercise is complete. Players also have the option to hear a playback of the exercise by selecting PLAY EXERCISE.

### Technologies

This game is coded in Java and used the javax.swing.JFrame class for the user interface. It incorporates OOP principles of encapsulation, polymorphism, and inheritance. Classes are separated into three packages that represent the FrameItems, Notes, and Main. 

### FrameItems
FrameItems include the setup code for each item in the JFrame. 

### Notes
Notes include an abstract Note class that is extended by each note type, and each note type contains a default duration. 

### Main
The primary logic is contained in the other classes. MyFrame includes the frame items and action listener, which incorporates methods for each frame item. RhythmExercise manages the exercise import from a text file, which is generated from a separate application called "Rhythm Generator." RhythmTiming manages the time stamps by which the user will be graded and initializes the countoff and PlayExercise methods. Grader manages the comparison between user input and the correct time stamps for an exercise. MusicPlayer manages the sound output.

### Challenges
This project challenged me to think asynchronously using a user interface. I had to think about how variables change, when to disable and enable buttons, and how to reduce large blocks of code for a busy action listener. 

### Future Features
I plan to include more rhythms, more time signatures, a difficulty selector, and a leaderboard database.