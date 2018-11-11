package ddorcak.nekonecneHry.App;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import ddorcak.nekonecneHry.core.*;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.XYChart;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameSceneControllerDouble {

	protected List<DoubleInterval> aktualnePokrytie;
	protected int turnCount = 1;
	protected List<DoubleInterval> vyber = new ArrayList<>();
	protected final DoubleInterval zakladny = new DoubleInterval(-10000, 10000);
	protected int score;

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

	void pridajDataPokrytia() {
		for (int i = 0; i < aktualnePokrytie.size(); i++) {
			DoubleInterval aktualny = aktualnePokrytie.get(i);
			XYChart.Series series = new XYChart.Series();
			series.getData().add(new XYChart.Data(aktualny.getBorderL() + 1, 0.5d + i % 2 * 0.25d));
			series.getData().add(new XYChart.Data(aktualny.getBorderR() + 1, 0.5d + i % 2 * 0.25d));
			intervalsChart.getData().add(series);
			nastavFarbu(series, Color.BLUE,true);
		}
	}

	void pridajDataVyberu() {
		for (int i = 0; i < vyber.size(); i++) {
			DoubleInterval aktualny = vyber.get(i);
			XYChart.Series series = new XYChart.Series();
			series.getData().add(new XYChart.Data(aktualny.getBorderL() + 1, 0.25d));
			series.getData().add(new XYChart.Data(aktualny.getBorderR() + 1, 0.25d));
			intervalsChart.getData().add(series);
			nastavFarbu(series, Color.GREEN,false);
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
		// Node symbol = series.getNode().lookup(".chart-line-symbol");

		String rgb = String.format("%d, %d, %d", (int) (color.getRed() * 255), (int) (color.getGreen() * 255),
				(int) (color.getBlue() * 255));

		line.setStyle("-fx-stroke: rgba(" + rgb + ", 1.0);");

		if (isClickable) {
			line.setOnMouseClicked(eh -> {
				ObservableList<XYChart.Data> ciara = series.getData();
				DoubleInterval vybrany = new DoubleInterval((double) ciara.get(0).getXValue(),
						(double) ciara.get(1).getXValue());
				vyber.add(vybrany);
				XYChart.Series vybranySeries = new XYChart.Series();
				vybranySeries.getData().add(new XYChart.Data(vybrany.getBorderL() + 1, 0.25d));
				vybranySeries.getData().add(new XYChart.Data(vybrany.getBorderR() + 1, 0.25d));
				intervalsChart.getData().add(vybranySeries);
			});
		}
	}

	
}
