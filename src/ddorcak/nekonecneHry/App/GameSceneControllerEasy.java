package ddorcak.nekonecneHry.App;


import ddorcak.nekonecneHry.core.PlayerOneEasy;
import ddorcak.nekonecneHry.core.ValidatorDouble;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;

public class GameSceneControllerEasy extends GameSceneControllerDouble{


	@FXML
	void initialize() {
		TurnLabel.setText("Ťah: " + turnCount + "\tSkóre: " + score);
		aktualnePokrytie = PlayerOneEasy.rozdel(zakladny, turnCount);
		naplnData();
		
		NextTurnButton.setOnAction(eh -> {
			if(score<=0){
				try {
					showWinScene(NextTurnButton,false);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if ((!vyber.isEmpty()) && ValidatorDouble.cowered(zakladny, vyber)) {
				Stage stage = (Stage) NextTurnButton.getScene().getWindow();
				stage.close();
				try {
					showWinScene(NextTurnButton,true);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			score-=1000;
			turnCount++;
			TurnLabel.setText("Ťah: " + turnCount + "\tSkóre: " + score);
			aktualnePokrytie = PlayerOneEasy.rozdel(zakladny, turnCount);
			naplnData();
			MAX_POCET_VYBERANYCH++;
		});

		odobratAkcia();
	}
}
