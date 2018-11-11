package ddorcak.nekonecneHry.App;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import ddorcak.nekonecneHry.core.*;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class GameSceneControllerImpossible extends GameSceneControllerDouble {


	@FXML
	void initialize() throws ExecutionException, InterruptedException {
		assert NextTurnButton != null : "fx:id=\"NextTurnButton\" was not injected: check your FXML file 'GameScene.fxml'.";
		assert intervalsChart != null : "fx:id=\"intervalsChart\" was not injected: check your FXML file 'GameScene.fxml'.";

		TurnLabel.setText("çah: " + turnCount);

		List<DoubleInterval> zakladnyInterval = new ArrayList<>();
		zakladnyInterval.add(zakladny);
		aktualnePokrytie = PlayerOneImpossible.rozdelDouble(zakladnyInterval, true);
		naplnData();
		turnCount++;

		NextTurnButton.setOnAction(eh -> {
			if ((!vyber.isEmpty()) && ValidatorDouble.cowered(zakladny, vyber)) {
				Stage stage = (Stage) NextTurnButton.getScene().getWindow();
				stage.close();
				System.out.println("Vyhra!!");
			}

			TurnLabel.setText("çah: " + turnCount++);
			try {
				aktualnePokrytie = PlayerOneImpossible.rozdelDouble(aktualnePokrytie, false);
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			naplnData();
		});

	}
}
