package ddorcak.nekonecneHry.App;

import java.awt.*;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;


import ddorcak.nekonecneHry.core.BigDecimalInterval;
import ddorcak.nekonecneHry.core.PlayerOneImpossible;
import javafx.scene.Node;
import javafx.scene.chart.XYChart;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;

public class GameSceneControllerBigDecimal {

    private List<BigDecimalInterval> aktualnePokrytie;
    private int turnCount = 0;
    private List<BigDecimalInterval> vyber = new ArrayList<>();

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
            BigDecimalInterval aktualny = aktualnePokrytie.get(i);
            XYChart.Series series = new XYChart.Series();
            series.getData().add(new XYChart.Data(aktualny.getBorderL().doubleValue() + 1, 0.5d + i % 2 * 0.25d));
            series.getData().add(new XYChart.Data(aktualny.getBorderR().doubleValue() + 1, 0.5d + i % 2 * 0.25d));
            intervalsChart.getData().add(series);
            nastavFarbu(series, Color.BLUE);
        }
    }

    void pridajDataVyberu() {
        for (int i = 0; i < vyber.size(); i++) {
            BigDecimalInterval aktualny = vyber.get(i);
            XYChart.Series series = new XYChart.Series();
            series.getData().add(new XYChart.Data(aktualny.getBorderL().doubleValue() + 1, 0.25d));
            series.getData().add(new XYChart.Data(aktualny.getBorderR().doubleValue() + 1, 0.25d));
            intervalsChart.getData().add(series);
            nastavFarbu(series, Color.GREEN);
        }
    }

    void naplnData() {
        intervalsChart.getData().clear();
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data(1d, 1d));
        series.getData().add(new XYChart.Data(100001d, 1d));

        intervalsChart.getData().add(series);
        pridajDataPokrytia();
        pridajDataVyberu();
    }

    void nastavFarbu(XYChart.Series series, Color color) {
        Node line = series.getNode().lookup(".chart-series-line");
        //Node symbol = series.getNode().lookup(".chart-line-symbol");

        String rgb = String.format("%d, %d, %d",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));

        line.setStyle("-fx-stroke: rgba(" + rgb + ", 1.0);");
        for (Node symbol : series.getNode().lookupAll(".chart-series-symbol")) {
            symbol.setStyle("-fx-background-color:rgba(" + rgb + ", 1.0), white;");
            System.out.println(symbol == null);
        }
    }

    @FXML
    void initialize() throws ExecutionException, InterruptedException {
        assert NextTurnButton != null : "fx:id=\"NextTurnButton\" was not injected: check your FXML file 'GameScene.fxml'.";
        assert intervalsChart != null : "fx:id=\"intervalsChart\" was not injected: check your FXML file 'GameScene.fxml'.";


        BigDecimalInterval zaklad = new BigDecimalInterval(new BigDecimal(0), new BigDecimal(100000));
        List<BigDecimalInterval> zakladnyInterval = new ArrayList<>();
        zakladnyInterval.add(zaklad);
        aktualnePokrytie = PlayerOneImpossible.rozdelBigDecimal(zakladnyInterval, true);
        naplnData();
        turnCount++;


        NextTurnButton.setOnAction(eh -> {
            turnCount++;
            try {
                aktualnePokrytie = PlayerOneImpossible.rozdelBigDecimal(aktualnePokrytie, false);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            naplnData();
        });


    }
}

