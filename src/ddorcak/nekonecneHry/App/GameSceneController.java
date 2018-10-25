package ddorcak.nekonecneHry.App;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.chart.XYChart;
import ddorcak.nekonecneHry.charts.IntervalAxis;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;

public class GameSceneController {

    private  IntervalAxis xAxis = new IntervalAxis();
    private  IntervalAxis yAxis =  new IntervalAxis();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button NextTurnButton;



    @FXML
    private LineChart<?,?> intervalsChart;

    @FXML
    void initialize() {
        assert NextTurnButton != null : "fx:id=\"NextTurnButton\" was not injected: check your FXML file 'GameScene.fxml'.";
        //assert intervalsChart != null : "fx:id=\"intervalsChart\" was not injected: check your FXML file 'GameScene.fxml'.";

      intervalsChart = new LineChart<Float,Float>(xAxis,yAxis);
//        intervalsChart.getYAxis().setTickLabelsVisible(false);
//        intervalsChart.getYAxis().setTickMarkVisible(false);
//        intervalsChart.getYAxis().setOpacity(0);

        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(50, 23));

        intervalsChart.getData().add(series);
    }
}

