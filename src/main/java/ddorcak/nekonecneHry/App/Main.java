package ddorcak.nekonecneHry.App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        WelcomeSceneController controller = new WelcomeSceneController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomeScene.fxml"));
        loader.setController(controller);

        Parent parentPane = loader.load();
        Scene scene = new Scene(parentPane);

        stage.setScene(scene);
//        stage.setMinHeight(345);
//        stage.setMinWidth(474);
        stage.setTitle("Nekonecne hry");
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
