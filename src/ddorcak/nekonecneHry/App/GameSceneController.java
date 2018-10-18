package ddorcak.nekonecneHry.App;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;

public class GameSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Line BigIntervalLine;

    @FXML
    private Button NextTurnButton;

    @FXML
    void initialize() {
        assert BigIntervalLine != null : "fx:id=\"BigIntervalLine\" was not injected: check your FXML file 'Untitled'.";
        assert NextTurnButton != null : "fx:id=\"NextTurnButton\" was not injected: check your FXML file 'Untitled'.";

    }
}
