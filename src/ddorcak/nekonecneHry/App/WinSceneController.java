package ddorcak.nekonecneHry.App;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class WinSceneController {

    private String mainLabelText;
    private int score;

    public WinSceneController(boolean win, int score) {
        this.mainLabelText = win ? "Vyhrali ste!" : "Prehrali ste!";
        this.score = score;
    }

    @FXML
    private Button exitButton;

    @FXML
    private Button newGameButton;

    @FXML
    private Label mainLabel;

    @FXML
    private Label scoreLabel;



    @FXML
    void initialize() {
        mainLabel.setText(mainLabelText);
        scoreLabel.setText("Vaše skóre: " + this.score);

        newGameButton.setOnAction(eh -> {
            WelcomeSceneController controller = new WelcomeSceneController();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resources/WelcomeScene.fxml"));
            loader.setController(controller);

            Parent parentPane = null;
            try {
                parentPane = loader.load();

                Scene scene = new Scene(parentPane);

                Stage stage = new Stage();
                stage.setScene(scene);
//        stage.setMinHeight(345);
//        stage.setMinWidth(474);
                stage.setTitle("Nekonecne hry");
                stage.show();
                newGameButton.getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        exitButton.setOnAction(eh -> {
             System.exit(0);});

    }

}

