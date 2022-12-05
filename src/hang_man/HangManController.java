package hang_man;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow; 

public class HangManController {

    //Class variables
    private final int NUM_OF_WORDS=213, ALLOWED_GUESS_NUMBER=6;
    private int guessNumber;
    private String wordToGuess, wordWithUnderscores;
    private ArrayList<String> wordsArray;
    private GraphicsContext gc;

    @FXML
    private Button A_button;

    @FXML
    private Button B_button;

    @FXML
    private Button C_button;

    @FXML
    private Button D_button;

    @FXML
    private Button E_button;

    @FXML
    private Button F_button;

    @FXML
    private Button G_button;

    @FXML
    private Button H_button;

    @FXML
    private Button I_button;

    @FXML
    private Button J_button;

    @FXML
    private Button K_button;

    @FXML
    private Button L_button;

    @FXML
    private Button M_button;

    @FXML
    private Button N_button;

    @FXML
    private Button O_button;

    @FXML
    private Button P_button;

    @FXML
    private Button Q_button;

    @FXML
    private Button R_button;

    @FXML
    private Button S_button;

    @FXML
    private Button T_button;

    @FXML
    private Button U_button;

    @FXML
    private Button V_button;

    @FXML
    private Button W_button;

    @FXML
    private Button X_button;

    @FXML
    private Button Y_button;

    @FXML
    private Button Z_button;

    @FXML
    private Button newGameButton;

    @FXML
    private TextFlow guessWordTextbox;

    @FXML
    private TextFlow numberOfGuessesTextBox;

    @FXML
    private Canvas hangmanCanvas;

    @FXML
    void aPress(ActionEvent event) {
    	A_button.setDisable(true);
    	checkGuess("a");
    }

    @FXML
    void bPress(ActionEvent event) {
    	B_button.setDisable(true);
    	checkGuess("b");
    }

    @FXML
    void cPress(ActionEvent event) {
    	C_button.setDisable(true);
    	checkGuess("c");
    }

    @FXML
    void dPress(ActionEvent event) {
    	D_button.setDisable(true);
    	checkGuess("d");
    }

    @FXML
    void ePress(ActionEvent event) {
    	E_button.setDisable(true);
    	checkGuess("e");
    }

    @FXML
    void fPress(ActionEvent event) {
    	F_button.setDisable(true);
    	checkGuess("e");
    }

    @FXML
    void gPress(ActionEvent event) {
    	G_button.setDisable(true);
    	checkGuess("g");
    }

    @FXML
    void hPress(ActionEvent event) {
    	H_button.setDisable(true);
    	checkGuess("h");
    }

    @FXML
    void iPress(ActionEvent event) {
    	I_button.setDisable(true);
    	checkGuess("i");
    }

    @FXML
    void jPress(ActionEvent event) {
    	J_button.setDisable(true);
    	checkGuess("j");
    }

    @FXML
    void kPress(ActionEvent event) {
    	K_button.setDisable(true);
    	checkGuess("k");
    }

    @FXML
    void lPress(ActionEvent event) {
    	L_button.setDisable(true);
    	checkGuess("l");
    }

    @FXML
    void mPress(ActionEvent event) {
    	M_button.setDisable(true);
    	checkGuess("m");
    }

    @FXML
    void nPress(ActionEvent event) {
    	N_button.setDisable(true);
    	checkGuess("n");
    }

    @FXML
    void oPress(ActionEvent event) {
    	O_button.setDisable(true);
    	checkGuess("o");
    }

    @FXML
    void pPress(ActionEvent event) {
    	P_button.setDisable(true);
    	checkGuess("p");
    }

    @FXML
    void qPress(ActionEvent event) {
    	Q_button.setDisable(true);
    	checkGuess("q");
    }

    @FXML
    void rPress(ActionEvent event) {
    	R_button.setDisable(true);
    	checkGuess("r");
    }

    @FXML
    void sPress(ActionEvent event) {
    	S_button.setDisable(true);
    	checkGuess("s");
    }

    @FXML
    void tPress(ActionEvent event) {
    	T_button.setDisable(true);
    	checkGuess("t");
    }

    @FXML
    void uPress(ActionEvent event) {
    	U_button.setDisable(true);
    	checkGuess("u");
    }

    @FXML
    void vPress(ActionEvent event) {
    	V_button.setDisable(true);
    	checkGuess("v");
    }

    @FXML
    void wPress(ActionEvent event) {
    	W_button.setDisable(true);
    	checkGuess("w");
    }

    @FXML
    void xPress(ActionEvent event) {
    	X_button.setDisable(true);
    	checkGuess("x");
    }

    @FXML
    void yPress(ActionEvent event) {
    	Y_button.setDisable(true);
    	checkGuess("y");
    }

    @FXML
    void zPress(ActionEvent event) {
    	Z_button.setDisable(true);
    	checkGuess("z");
    }

    /*When pressing the new game key, a new random word is read from the file and printed to the screen
     A new tree skeleton is drawn*/
    @FXML
    private void pressNewGame(ActionEvent event) {
        guessNumber=0;
        //Clear the word text box
        if (!guessWordTextbox.getChildren().isEmpty()) {
            guessWordTextbox.getChildren().clear();
        }
        //Clear the guess number text box
        if (!numberOfGuessesTextBox.getChildren().isEmpty()) {
            numberOfGuessesTextBox.getChildren().clear();
        }
        //Clear the canvas
        gc.clearRect(0, 0, hangmanCanvas.getWidth(), hangmanCanvas.getHeight());
        //Draw hangman skeleton
        drawHangman(0);
        //Select a new random word
        Random r = new Random();
        int i = r.nextInt(NUM_OF_WORDS);
        wordToGuess=wordsArray.get(i);
        //Print the word with underscores
        wordWithUnderscores=calcWordWithUnderscores(wordToGuess);
        printWord(wordWithUnderscores);
        printGuessNumber();
        turnOnButtons();
    }

    //initalize the class variables and generates the words array
    public void initialize() {
        guessNumber=0;
        readWordsFromFile();
        drawHangman(0);
        //Turn on in a new game
        turnOffButtons();
    }

    //This method generates the words arraylist and shuffles it
    private void readWordsFromFile() {
        String word="";
        FileReader wordsFileReader;
        BufferedReader reader;
		//Read a word from the file and save it to the arraylist
        try {
            java.net.URL url = getClass().getResource("Words.txt");
            wordsFileReader = new FileReader(url.getPath());
            reader= new BufferedReader(wordsFileReader);
            wordsArray=new ArrayList<String>();
            //Read the word
            for (int i = 0; i < NUM_OF_WORDS; i++) {
                word = reader.readLine();
                wordsArray.add(word);
            }
		} catch (IOException e) {
			e.printStackTrace();
            Collections.shuffle(wordsArray);
        }
    }

    //print a word to the text box
    private void printWord (String word) {
        Text newWord=new Text(word);
        newWord.setFill(Color.PURPLE);
        newWord.setFont(Font.font("Helvetica", FontPosture.ITALIC, 35));
        //if a word already exists
        if (!guessWordTextbox.getChildren().isEmpty()) {
            guessWordTextbox.getChildren().clear();
        }
        guessWordTextbox.getChildren().addAll(newWord);
        guessWordTextbox.setStyle("-fx-background-color: yellow");
    }

    //print the number of remaining guesses to the text box
    private void printGuessNumber () {
        Text newWord=new Text("Mistakes: "+Integer.toString(guessNumber)+"\nout of 6");
        newWord.setFill(Color.PURPLE);
        newWord.setFont(Font.font("Helvetica", FontPosture.ITALIC, 20));
        //clean the previous number
        if (!numberOfGuessesTextBox.getChildren().isEmpty()) {
            numberOfGuessesTextBox.getChildren().clear();
        }
        numberOfGuessesTextBox.getChildren().addAll(newWord);
        numberOfGuessesTextBox.setStyle("-fx-background-color: yellow");
    }

    //This method returns the word with underscores
    private String calcWordWithUnderscores(String word) {
        String wordWithUnderscores="";
        for (int i = 0; i < word.length(); i++) {
            wordWithUnderscores += "_";
        }
        return wordWithUnderscores;
    }

    //This method draws the hang man - for each wrong guess
    private void drawHangman(int stage) {
        hangmanCanvas.setCache(true);
        gc = hangmanCanvas.getGraphicsContext2D();
    	switch (stage) {
    	  case 0:
    		  gc.setStroke(Color.BLACK);
    		  gc.setLineWidth(5.0);
    	      gc.strokeLine(hangmanCanvas.getWidth()/2-75,hangmanCanvas.getHeight()-10,hangmanCanvas.getWidth()/2+75,hangmanCanvas.getHeight()-10);
    	      gc.strokeLine(hangmanCanvas.getWidth()/2, hangmanCanvas.getHeight()-10, hangmanCanvas.getWidth()/2,25);
    	      gc.strokeLine(hangmanCanvas.getWidth()/2, 25, hangmanCanvas.getWidth()/2+70,25);
    	      gc.setStroke(Color.BLACK);
    	      gc.strokeLine(hangmanCanvas.getWidth()/2+70, 25, hangmanCanvas.getWidth()/2+70,70);
    	    break;
    	  case 1:
    		  gc.setStroke(Color.BLUE);
    		  gc.strokeOval(hangmanCanvas.getWidth()/2+36, 70, 70, 70);
    	    break;
    	  case 2:
    		  gc.setStroke(Color.BLUE);
    		  gc.strokeLine(hangmanCanvas.getWidth()/2+70, 140,hangmanCanvas.getWidth()/2+70,270);
    	    break;
    	  case 3:
    		  gc.setStroke(Color.BLUE);
    		  gc.strokeLine(hangmanCanvas.getWidth()/2+70, 170,hangmanCanvas.getWidth()/2+100,220);
    	    break;
    	  case 4:
    		  gc.setStroke(Color.BLUE);
    		  gc.strokeLine(hangmanCanvas.getWidth()/2+70, 170,hangmanCanvas.getWidth()/2+40,220);
    	    break;
    	  case 5:
    		  gc.setStroke(Color.BLUE);
    		  gc.strokeLine(hangmanCanvas.getWidth()/2+70,270,hangmanCanvas.getWidth()/2+100,300);
    		break;
    	  case 6:
    		  gc.setStroke(Color.BLUE);
    		  gc.strokeLine(hangmanCanvas.getWidth()/2+70,270,hangmanCanvas.getWidth()/2+40,300);
    		break;
            }
        }

        //This method is triggered when too many wrong guess are detected
        private void gameOver() {
            guessWordTextbox.getChildren().clear();
            printWord("The game is over! \nThe word was "+wordToGuess);
            printGuessNumber();
            turnOffButtons();
        }
        
        //Turn on all the buttons
        private void turnOnButtons() {
            A_button.setDisable(false);
            B_button.setDisable(false);
            C_button.setDisable(false);
            D_button.setDisable(false);
            E_button.setDisable(false);
            F_button.setDisable(false);
            G_button.setDisable(false);
            H_button.setDisable(false);
            I_button.setDisable(false);
            J_button.setDisable(false);
            K_button.setDisable(false);
            L_button.setDisable(false);
            M_button.setDisable(false);
            N_button.setDisable(false);
            O_button.setDisable(false);
            P_button.setDisable(false);
            Q_button.setDisable(false);
            R_button.setDisable(false);
            S_button.setDisable(false);
            T_button.setDisable(false);
            U_button.setDisable(false);
            V_button.setDisable(false);
            W_button.setDisable(false);
            X_button.setDisable(false);
            Y_button.setDisable(false);
            Z_button.setDisable(false);
        }

        //Turn off all the buttons
        private void turnOffButtons() {
            A_button.setDisable(true);
            B_button.setDisable(true);
            C_button.setDisable(true);
            D_button.setDisable(true);
            E_button.setDisable(true);
            F_button.setDisable(true);
            G_button.setDisable(true);
            H_button.setDisable(true);
            I_button.setDisable(true);
            J_button.setDisable(true);
            K_button.setDisable(true);
            L_button.setDisable(true);
            M_button.setDisable(true);
            N_button.setDisable(true);
            O_button.setDisable(true);
            P_button.setDisable(true);
            Q_button.setDisable(true);
            R_button.setDisable(true);
            S_button.setDisable(true);
            T_button.setDisable(true);
            U_button.setDisable(true);
            V_button.setDisable(true);
            W_button.setDisable(true);
            X_button.setDisable(true);
            Y_button.setDisable(true);
            Z_button.setDisable(true);
        }

    //This method checks the guess and triggers a response if the guess is correct or not
    private void checkGuess (String letter) {
        if (wordToGuess.contains(letter)) {
            correctGuess(letter);
        }
        else{
            wrongGuess(letter);
        }
    }

    //This method is called if the guess is correct - remove the underscore from the letter
    private void correctGuess (String letter) {
        String tempWordWithUnderscores=wordWithUnderscores;
        for (int i = 0; i <wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter.charAt(0)) {
                tempWordWithUnderscores=tempWordWithUnderscores.substring(0,i)+letter.charAt(0)+tempWordWithUnderscores.substring(i+1,wordWithUnderscores.length());
            }
        }
        wordWithUnderscores=tempWordWithUnderscores;
        //If there are no more underscores it means we won
    	if(!wordWithUnderscores.contains("_"))	{
    		guessWordTextbox.getChildren().clear();
    		printWord("You won!");
    		turnOffButtons();
        }
        else
        {
            printWord(wordWithUnderscores);
        }
        printGuessNumber();
    }

    //This method is called if the guess is incorrect
    private void wrongGuess (String letter) {
        guessNumber++;
        drawHangman(guessNumber);
        if(guessNumber>=ALLOWED_GUESS_NUMBER) {
            gameOver();
        }
        printGuessNumber();
    }
}