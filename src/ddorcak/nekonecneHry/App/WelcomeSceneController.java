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
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button PlayButton;

    @FXML
    void initialize() {
        assert PlayButton != null : "fx:id=\"PlayButton\" was not injected: check your FXML file 'WelcomeScene.fxml'.";

        PlayButton.setOnAction(eh -> {

            try {
                GameSceneController controller = new GameSceneController();
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("../Resources/GameScene.fxml"));
                loader.setController(controller);

                Parent parentPane = loader.load();
                Scene scene = new Scene(parentPane);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.setTitle("Nekonecne hry");
                stage.showAndWait();

            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        });

    }
}
