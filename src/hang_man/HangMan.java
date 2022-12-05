package hang_man;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HangMan extends Application{ 
	
	public void start(Stage stage) throws Exception{ 
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("Hang_man.fxml")); 
		Scene scene = new Scene(root); 
		stage.setTitle("Hang man");
		stage.setScene(scene); 
		stage.show();
	}
	
	public static void main(String[] args) { 
		launch(args);
	} 
}