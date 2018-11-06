package ddorcak.nekonecneHry.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


public class Rozdelovac implements Callable<ArrayList<Interval>> {
    private Interval rozdelovany;

    public Rozdelovac(Interval rozdelovany){
        this.rozdelovany = rozdelovany;
    }
    @Override
    public ArrayList<Interval> call() throws Exception {
        ArrayList<Interval> vysledok = new ArrayList<>();
        BigDecimal dlzka = rozdelovany.getLength();
        BigDecimal tretina = dlzka.divide(new BigDecimal(3d),5, RoundingMode.HALF_UP);
        BigDecimal posun = dlzka.divide(new BigDecimal(100d),5,RoundingMode.HALF_UP);

        BigDecimal tretinaOdZaciatku = rozdelovany.getBorderL().add(tretina);
        BigDecimal tretinaOdKonca = rozdelovany.getBorderR().subtract(tretina);

        vysledok.add(new Interval(rozdelovany.getBorderL(), tretinaOdZaciatku));
        vysledok.add(new Interval(tretinaOdZaciatku.subtract(posun), tretinaOdKonca));
        vysledok.add(new Interval(tretinaOdKonca.subtract(posun), rozdelovany.getBorderR()));

        return vysledok;
    }
}
