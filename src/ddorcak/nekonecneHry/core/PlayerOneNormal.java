package ddorcak.nekonecneHry.core;

import java.util.ArrayList;
import java.util.List;

public class PlayerOneNormal {


    public static List<List<DoubleInterval>> vygenerujRozdelenia(DoubleInterval zakladny) {
        List<List<DoubleInterval>> vysledok = new ArrayList<>();
        int pocetDeleni = (int) (7 + Math.round(Math.random() * 8));
        double maximalnaDlzka = zakladny.getLength() / 30;
        double posun = maximalnaDlzka / 15;
        for (int i = 0; i < pocetDeleni; i++) {
            List<DoubleInterval> list = new ArrayList<>();
            double hranica = zakladny.getBorderL();
            while (true){
                double posunHranice = 1+(Math.random()*4*maximalnaDlzka);
                list.add(new DoubleInterval(hranica-posun,hranica+posunHranice));
                hranica += posunHranice;
                if(hranica>zakladny.getBorderR()){
                    break;
                }
            }
            vysledok.add(list);
        }
        return vysledok;
    }
}
