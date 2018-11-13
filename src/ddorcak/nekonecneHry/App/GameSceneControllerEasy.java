package ddorcak.nekonecneHry.App;


import ddorcak.nekonecneHry.core.PlayerOneEasy;
import ddorcak.nekonecneHry.core.ValidatorDouble;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class GameSceneControllerEasy extends GameSceneControllerDouble{


	@FXML
	void initialize() {
		TurnLabel.setText("çah: " + turnCount);
		aktualnePokrytie = PlayerOneEasy.rozdel(zakladny, turnCount);
		naplnData();
		
		NextTurnButton.setOnAction(eh -> {
			if ((!vyber.isEmpty()) && ValidatorDouble.cowered(zakladny, vyber)) {
				Stage stage = (Stage) NextTurnButton.getScene().getWindow();
				stage.close();
				System.out.println("Vyhra!!");
			}

			TurnLabel.setText("çah: " + turnCount++);
				aktualnePokrytie = PlayerOneEasy.rozdel(zakladny, turnCount);
			naplnData();
			MAX_POCET_VYBERANYCH++;
		});
	}
}
