package ddorcak.nekonecneHry.App;

import ddorcak.nekonecneHry.core.DoubleInterval;
import ddorcak.nekonecneHry.core.PlayerOneEasy;
import ddorcak.nekonecneHry.core.PlayerOneNormal;
import ddorcak.nekonecneHry.core.ValidatorDouble;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.util.List;

public class GameSceneControllerNormal extends GameSceneControllerDouble {
    private List<List<DoubleInterval>> pokrytia;

    @FXML
    void initialize() {
        TurnLabel.setText("Ťah: " + turnCount);
        pokrytia = PlayerOneNormal.vygenerujRozdelenia(zakladny);
        int index0 = (int) (Math.round(Math.random()*(pokrytia.size()-1)));
        aktualnePokrytie = pokrytia.get(index0);
        naplnData();

        NextTurnButton.setOnAction(eh -> {
            if ((!vyber.isEmpty()) && ValidatorDouble.cowered(zakladny, vyber)) {
                Stage stage = (Stage) NextTurnButton.getScene().getWindow();
                stage.close();
                System.out.println("Vyhra!!");
            }
            turnCount++;
            TurnLabel.setText("Ťah: " + turnCount);
            int indexN = (int) (Math.round(Math.random()*(pokrytia.size()-1)));
            aktualnePokrytie = pokrytia.get(indexN);
            naplnData();
            MAX_POCET_VYBERANYCH++;
        });


    }


}
