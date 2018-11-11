package ddorcak.nekonecneHry.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


public class BigdecimalRozdelovac implements Callable<ArrayList<BigDecimalInterval>> {
    private BigDecimalInterval rozdelovany;

    public BigdecimalRozdelovac(BigDecimalInterval rozdelovany){
        this.rozdelovany = rozdelovany;
    }
    @Override
    public ArrayList<BigDecimalInterval> call() throws Exception {
        ArrayList<BigDecimalInterval> vysledok = new ArrayList<>();
        BigDecimal dlzka = rozdelovany.getLength();
        BigDecimal tretina = dlzka.divide(new BigDecimal(3d),5, RoundingMode.HALF_UP);
        BigDecimal posun = dlzka.divide(new BigDecimal(100d),5,RoundingMode.HALF_UP);

        BigDecimal tretinaOdZaciatku = rozdelovany.getBorderL().add(tretina);
        BigDecimal tretinaOdKonca = rozdelovany.getBorderR().subtract(tretina);

        vysledok.add(new BigDecimalInterval(rozdelovany.getBorderL(), tretinaOdZaciatku));
        vysledok.add(new BigDecimalInterval(tretinaOdZaciatku.subtract(posun), tretinaOdKonca));
        vysledok.add(new BigDecimalInterval(tretinaOdKonca.subtract(posun), rozdelovany.getBorderR()));

        return vysledok;
    }
}
