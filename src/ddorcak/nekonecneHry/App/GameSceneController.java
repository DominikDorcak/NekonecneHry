package ddorcak.nekonecneHry.App;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import ddorcak.nekonecneHry.core.Interval;
import ddorcak.nekonecneHry.core.PlayerOne;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.scene.chart.XYChart;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;

public class GameSceneController {

    private List<Interval> aktualnePokrytie;
    private int turnCount = 0;
    private List<Interval> vyber = new ArrayList<>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button NextTurnButton;


    @FXML
    private LineChart<?, ?> intervalsChart;

    void pridajDataPokrytia() {
        for (int i = 0; i < aktualnePokrytie.size(); i++) {
            Interval aktualny = aktualnePokrytie.get(i);
            XYChart.Series series = new XYChart.Series();
            series.getData().add(new XYChart.Data(aktualny.getBorderL().doubleValue()+0.1, 0.5d + i % 2 * 0.25d));
            series.getData().add(new XYChart.Data(aktualny.getBorderR().doubleValue()+0.1, 0.5d + i % 2 * 0.25d));
            intervalsChart.getData().add(series);
        }
    }

    void pridajDataVyberu() {
        for (int i = 0; i < vyber.size(); i++) {
            Interval aktualny = vyber.get(i);
            XYChart.Series series = new XYChart.Series();
            series.getData().add(new XYChart.Data(aktualny.getBorderL().doubleValue()+0.1, 0.25d));
            series.getData().add(new XYChart.Data(aktualny.getBorderR().doubleValue()+0.1, 0.25d));
            intervalsChart.getData().add(series);
        }
    }

    void naplnData() {
        intervalsChart.getData().clear();
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data(0.1d, 1d));
        series.getData().add(new XYChart.Data(1.1d, 1d));

        intervalsChart.getData().add(series);
        pridajDataPokrytia();
        pridajDataVyberu();
    }

    @FXML
    void initialize() {
        assert NextTurnButton != null : "fx:id=\"NextTurnButton\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert intervalsChart != null : "fx:id=\"intervalsChart\" was not injected: check your FXML file 'GameScene.fxml'.";


        Interval zaklad = new Interval(new BigDecimal(0), new BigDecimal(1));
        List<Interval> zakladnyInterval = new ArrayList<>();
        zakladnyInterval.add(zaklad);
        aktualnePokrytie = PlayerOne.IMPOSSIBLE.rozdel(zakladnyInterval);
        naplnData();
        turnCount++;


        NextTurnButton.setOnAction(eh -> {
            turnCount++;
            aktualnePokrytie = PlayerOne.IMPOSSIBLE.rozdel(aktualnePokrytie);
            naplnData();
        });


    }
}

