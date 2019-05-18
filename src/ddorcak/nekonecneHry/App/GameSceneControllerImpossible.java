package ddorcak.nekonecneHry.App;

import java.io.IOException;
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

		TurnLabel.setText("Ťah: " + turnCount + "\tSkóre: " + score);

		List<DoubleInterval> zakladnyInterval = new ArrayList<>();
		zakladnyInterval.add(zakladny);
		aktualnePokrytie = PlayerOneImpossible.rozdelDouble(zakladnyInterval, true);
		naplnData();

		NextTurnButton.setOnAction(eh -> {
			score-=4000;
			turnCount++;
			if(this.score<0){
				try {
					showWinScene(NextTurnButton,false);
					Stage stage = (Stage) NextTurnButton.getScene().getWindow();
					stage.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if ((!vyber.isEmpty()) && ValidatorDouble.cowered(zakladny, vyber)) {
				try {
					showWinScene(NextTurnButton,true);
					Stage stage = (Stage) NextTurnButton.getScene().getWindow();
					stage.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			TurnLabel.setText("Ťah: " + turnCount + "\tSkóre: " + score);

			try {
				aktualnePokrytie = PlayerOneImpossible.rozdelDouble(aktualnePokrytie, false);
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			naplnData();
			MAX_POCET_VYBERANYCH++;
		});

		odobratAkcia();
	}
}
