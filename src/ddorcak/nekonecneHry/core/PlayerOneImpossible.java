package ddorcak.nekonecneHry.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PlayerOneImpossible {





    public static List<BigDecimalInterval> rozdelBigDecimal(List<BigDecimalInterval> intervalList, boolean zaciatok) throws ExecutionException, InterruptedException {
        ExecutorService EXECUTOR = Executors.newCachedThreadPool();
        List<BigDecimalInterval> vysledok = new ArrayList<>();
        List<Future<ArrayList<BigDecimalInterval>>> futures = new ArrayList<>();
        for (BigDecimalInterval interval : intervalList) {

            if (zaciatok) {
                BigDecimal dlzka = interval.getLength();
                BigDecimal tretina = dlzka.divide(new BigDecimal(3d), 5, RoundingMode.HALF_UP);
                BigDecimal posun = dlzka.divide(new BigDecimal(100d), 5, RoundingMode.HALF_UP);

                BigDecimal tretinaOdZaciatku = interval.getBorderL().add(tretina);
                BigDecimal tretinaOdKonca = interval.getBorderR().subtract(tretina);
                vysledok.add(new BigDecimalInterval(interval.getBorderL().subtract(posun), tretinaOdZaciatku));
                vysledok.add(new BigDecimalInterval(tretinaOdZaciatku.subtract(posun), tretinaOdKonca));
                vysledok.add(new BigDecimalInterval(tretinaOdKonca.subtract(posun), interval.getBorderR().add(posun)));
            } else {
                BigdecimalRozdelovac rozdelovac = new BigdecimalRozdelovac(interval);
                Future<ArrayList<BigDecimalInterval>> future = EXECUTOR.submit(rozdelovac);
                futures.add(future);

            }
        }


        for (Future<ArrayList<BigDecimalInterval>> f : futures) {
            ArrayList<BigDecimalInterval> list = f.get();
            vysledok.addAll(list);

        }

        EXECUTOR.shutdown();
        return vysledok;
    }
    
    public  static List<DoubleInterval> rozdelDouble(List<DoubleInterval> intervalList, boolean zaciatok) throws ExecutionException, InterruptedException {
        ExecutorService EXECUTOR = Executors.newCachedThreadPool();
        List<DoubleInterval> vysledok = new ArrayList<>();
        List<Future<ArrayList<DoubleInterval>>> futures = new ArrayList<>();
        for (DoubleInterval interval : intervalList) {

            if (zaciatok) {
                double dlzka = interval.getLength();
                double tretina = dlzka/3;
                double posun = dlzka/100;

                double tretinaOdZaciatku = interval.getBorderL()+(tretina);
                double tretinaOdKonca = interval.getBorderR()-(tretina);
                vysledok.add(new DoubleInterval(interval.getBorderL()-posun, tretinaOdZaciatku));
                vysledok.add(new DoubleInterval(tretinaOdZaciatku-posun, tretinaOdKonca));
                vysledok.add(new DoubleInterval(tretinaOdKonca-posun, interval.getBorderR()+posun));
            } else {
                DoubleRozdelovac rozdelovac = new DoubleRozdelovac(interval);
                Future<ArrayList<DoubleInterval>> future = EXECUTOR.submit(rozdelovac);
                futures.add(future);

            }
        }


        for (Future<ArrayList<DoubleInterval>> f : futures) {
            ArrayList<DoubleInterval> list = f.get();
            vysledok.addAll(list);

        }

        EXECUTOR.shutdown();
        return vysledok;
    }
    
 
    
    
}
