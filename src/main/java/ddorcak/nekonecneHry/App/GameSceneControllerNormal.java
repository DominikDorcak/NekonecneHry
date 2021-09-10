package ddorcak.nekonecneHry.App;

import ddorcak.nekonecneHry.core.DoubleInterval;
import ddorcak.nekonecneHry.core.PlayerOneEasy;
import ddorcak.nekonecneHry.core.PlayerOneNormal;
import ddorcak.nekonecneHry.core.ValidatorDouble;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class GameSceneControllerNormal extends GameSceneControllerDouble {
    private List<List<DoubleInterval>> pokrytia;
    private int pocetIntervalov = 0;

    @FXML
    void initialize() {
        TurnLabel.setText("Ťah: " + turnCount + "\tSkóre: " + score);
        pokrytia = PlayerOneNormal.vygenerujRozdelenia(zakladny);
        int index0 = (int) (Math.round(Math.random()*(pokrytia.size()-1)));
        aktualnePokrytie = pokrytia.get(index0);
        naplnData();
        for (List<DoubleInterval> pokr:pokrytia) {
            pocetIntervalov+=pokr.size();
        }


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
            turnCount++;
            score-=10000/pocetIntervalov;
            TurnLabel.setText("Ťah: " + turnCount + "\tSkóre: " + score);
            int indexN = (int) (Math.round(Math.random()*(pokrytia.size()-1)));
            aktualnePokrytie = pokrytia.get(indexN);
            naplnData();
            MAX_POCET_VYBERANYCH++;
        });
        odobratAkcia();

    }


}
