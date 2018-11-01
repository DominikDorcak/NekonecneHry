package ddorcak.nekonecneHry.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public enum PlayerOne{

    IMPOSSIBLE;



    public List<Interval> rozdel(List<Interval> intervalList){
        //TODO Specialne pre prve rozdelenie!!
        List<Interval> vysledok = new ArrayList<>();
        for (Interval interval:intervalList) {
            BigDecimal dlzka = interval.getLength();
            BigDecimal tretina = dlzka.divide(new BigDecimal(3d),20,RoundingMode.HALF_UP);
            BigDecimal posun = dlzka.divide(new BigDecimal(30d),20,RoundingMode.HALF_UP);

            BigDecimal tretinaOdZaciatku = interval.getBorderL().add(tretina);
            BigDecimal tretinaOdKonca = interval.getBorderR().subtract(tretina);
            vysledok.add(new Interval(interval.getBorderL().subtract(posun),tretinaOdZaciatku));
            vysledok.add(new Interval(tretinaOdZaciatku.subtract(posun),tretinaOdKonca));
            vysledok.add(new Interval(tretinaOdKonca.subtract(posun),interval.getBorderR().add(posun)));

        }
        return vysledok;
    }
}
