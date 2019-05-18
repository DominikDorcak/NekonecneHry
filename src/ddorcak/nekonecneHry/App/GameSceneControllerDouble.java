package ddorcak.nekonecneHry.App;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import ddorcak.nekonecneHry.core.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GameSceneControllerDouble {

    protected int MAX_POCET_VYBERANYCH = 1;
    protected XYChart.Series vybranySeries;
    protected DoubleInterval vybrany;
    protected int pocetVybranych = 0;
    protected List<DoubleInterval> aktualnePokrytie;
    protected int turnCount = 1;
    protected List<DoubleInterval> vyber = new ArrayList<>();
    protected final DoubleInterval zakladny = new DoubleInterval(-10000, 10000);
    protected int score = 10000;

    @FXML
    protected ResourceBundle resources;

    @FXML
    protected URL location;

    @FXML
    protected Button NextTurnButton;

    @FXML
    protected LineChart<?, ?> intervalsChart;

    @FXML
    protected Label TurnLabel;

    @FXML
    protected Button RemoveButton;

    void pridajDataPokrytia() {
        for (int i = 0; i < aktualnePokrytie.size(); i++) {
            DoubleInterval aktualny = aktualnePokrytie.get(i);
            XYChart.Series series = new XYChart.Series();
            series.getData().add(new XYChart.Data(aktualny.getBorderL() + 1, 0.5d + i % 2 * 0.25d));
            series.getData().add(new XYChart.Data(aktualny.getBorderR() + 1, 0.5d + i % 2 * 0.25d));
            intervalsChart.getData().add(series);
            nastavFarbu(series, Color.BLUE, true);
        }
    }

    void pridajDataVyberu() {
        for (int i = 0; i < vyber.size(); i++) {
            DoubleInterval aktualny = vyber.get(i);
            XYChart.Series series = new XYChart.Series();
            series.getData().add(new XYChart.Data(aktualny.getBorderL() + 1, 0.25d));
            series.getData().add(new XYChart.Data(aktualny.getBorderR() + 1, 0.25d));
            intervalsChart.getData().add(series);
            nastavFarbu(series, Color.GREEN, false);
        }
    }

    void naplnData() {
        intervalsChart.getData().clear();
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        // populating the series with data
        series.getData().add(new XYChart.Data(zakladny.getBorderL() + 1, 1d));
        series.getData().add(new XYChart.Data(zakladny.getBorderR() + 1, 1d));

        intervalsChart.getData().add(series);
        pridajDataPokrytia();
        pridajDataVyberu();
    }

    void nastavFarbu(XYChart.Series series, Color color, boolean isClickable) {
        Node line = series.getNode().lookup(".chart-series-line");

        String rgb = String.format("%d, %d, %d", (color.getRed() * 255), (color.getGreen() * 255),
                (color.getBlue() * 255));

        line.setStyle("-fx-stroke: rgba(" + rgb + ", 1.0);");

        if (isClickable) {
            line.setOnMouseClicked(eh -> {
                ObservableList<XYChart.Data> ciara = series.getData();
                vybrany = new DoubleInterval((double) ciara.get(0).getXValue(),
                        (double) ciara.get(1).getXValue());
                if (pocetVybranych < MAX_POCET_VYBERANYCH) {
                    vyber.add(vybrany);

                    vybranySeries = new XYChart.Series();
                    vybranySeries.getData().add(new XYChart.Data(vybrany.getBorderL() + 1, 0.25d));
                    vybranySeries.getData().add(new XYChart.Data(vybrany.getBorderR() + 1, 0.25d));
                    intervalsChart.getData().add(vybranySeries);

                    pocetVybranych++;
                    RemoveButton.setDisable(pocetVybranych!=MAX_POCET_VYBERANYCH);

                }
            });
        }
    }

    void odobratAkcia(){
        RemoveButton.setDisable(pocetVybranych!=MAX_POCET_VYBERANYCH);
        RemoveButton.setOnAction(eh ->{
            if (pocetVybranych==MAX_POCET_VYBERANYCH) {
                intervalsChart.getData().remove(vybranySeries);
                vyber.remove(vybrany);
                pocetVybranych--;
                RemoveButton.setDisable(pocetVybranych!=MAX_POCET_VYBERANYCH);
            }

        });
    }

    void showWinScene(Button button,boolean win) throws IOException {
        WinSceneController controller = new WinSceneController(win,this.score);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Resources/WinScene.fxml"));
        loader.setController(controller);


        Parent parentPane = loader.load();
        Scene scene = new Scene(parentPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Nekonecne hry");
        stage.show();

        button.getScene().getWindow().hide();
    }


}
