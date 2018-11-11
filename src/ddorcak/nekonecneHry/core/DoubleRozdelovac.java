package ddorcak.nekonecneHry.core;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


public class DoubleRozdelovac implements Callable<ArrayList<DoubleInterval>> {
    private DoubleInterval rozdelovany;

    public DoubleRozdelovac(DoubleInterval rozdelovany){
        this.rozdelovany = rozdelovany;
    }
    @Override
    public ArrayList<DoubleInterval> call() throws Exception {
        ArrayList<DoubleInterval> vysledok = new ArrayList<>();
        double dlzka = rozdelovany.getLength();
        double tretina = dlzka/3;
        double posun = dlzka/100;

        double tretinaOdZaciatku = rozdelovany.getBorderL()+(tretina);
        double tretinaOdKonca = rozdelovany.getBorderR()-(tretina);

        vysledok.add(new DoubleInterval(rozdelovany.getBorderL(), tretinaOdZaciatku));
        vysledok.add(new DoubleInterval(tretinaOdZaciatku-posun, tretinaOdKonca));
        vysledok.add(new DoubleInterval(tretinaOdKonca-posun, rozdelovany.getBorderR()));

        return vysledok;
    }
}
