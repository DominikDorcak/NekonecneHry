package ddorcak.nekonecneHry.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WelcomeSceneController {

	@FXML
	private URL location;

	@FXML
	private Button EasyButton;

	@FXML
	private Button NormalButton;

	@FXML
	private Button ImpossibleButton;

	@FXML
	void initialize() {
		assert EasyButton != null : "fx:id=\"EasyButton\" was not injected: check your FXML file 'WelcomeScene.fxml'.";
		assert NormalButton != null : "fx:id=\"NormalButton\" was not injected: check your FXML file 'WelcomeScene.fxml'.";
		assert ImpossibleButton != null : "fx:id=\"ImpossibleButton\" was not injected: check your FXML file 'WelcomeScene.fxml'.";

		ImpossibleButton.setOnAction(eh -> {

			try {
//                GameSceneControllerBigDecimal controller = new GameSceneControllerBigDecimal();
				GameSceneControllerImpossible controller = new GameSceneControllerImpossible();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScene.fxml"));
				loader.setController(controller);

				Parent parentPane = loader.load();
				Scene scene = new Scene(parentPane);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.setMaximized(true);
				stage.setTitle("Nekonecne hry");
				stage.showAndWait();

				ImpossibleButton.getScene().getWindow().hide();

			} catch (IOException iOException) {
				iOException.printStackTrace();
			}
		});

		EasyButton.setOnAction(eh -> {

			try {
				GameSceneControllerDouble controller = new GameSceneControllerEasy();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScene.fxml"));
				loader.setController(controller);

				Parent parentPane = loader.load();
				Scene scene = new Scene(parentPane);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.setMaximized(true);
				stage.setTitle("Nekonecne hry");
				stage.showAndWait();

				EasyButton.getScene().getWindow().hide();

			} catch (IOException iOException) {
				iOException.printStackTrace();
			}
		});
		
		NormalButton.setOnAction(eh -> {

			try {
				GameSceneControllerDouble controller = new GameSceneControllerNormal();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScene.fxml"));
				loader.setController(controller);

				Parent parentPane = loader.load();
				Scene scene = new Scene(parentPane);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.setMaximized(true);
				stage.setTitle("Nekonecne hry");
				stage.showAndWait();

				NormalButton.getScene().getWindow().hide();

			} catch (IOException iOException) {
				iOException.printStackTrace();
			}
		});

	}
}
