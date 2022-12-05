# Hang man
This is an assignment from the course 'Java advanced programing', 20554 at the Open University of Israel
Assignment 13, Q (semester 2023A).

Hang man is a famous one / many player game
More info can be found in [Wikipedia](https://en.wikipedia.org/wiki/Hangman_(game))

To run the project:
1.   Clone
2.   cd into the cloned directory
3.   run.bat

To re-compile the project yourself:
1. cd into src->hang_man directory
2. List all the files in the directory: `dir /s /B *.java > sources.txt`
3. Compile: `javac -d . @sources.txt`
4. Copy .fxml file into the newly created folder which contains the .class files
5. Run using the command: `java HangMan.hang_man`
