package ddorcak.nekonecneHry.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public enum PlayerOne {

    IMPOSSIBLE;

    public static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();



    public List<Interval> rozdel(List<Interval> intervalList, boolean zaciatok) throws ExecutionException, InterruptedException {
        ExecutorService EXECUTOR = Executors.newCachedThreadPool();
        List<Interval> vysledok = new ArrayList<>();
        List<Future<ArrayList<Interval>>> futures = new ArrayList<>();
        for (Interval interval : intervalList) {

            if (zaciatok) {
                BigDecimal dlzka = interval.getLength();
                BigDecimal tretina = dlzka.divide(new BigDecimal(3d), 5, RoundingMode.HALF_UP);
                BigDecimal posun = dlzka.divide(new BigDecimal(100d), 5, RoundingMode.HALF_UP);

                BigDecimal tretinaOdZaciatku = interval.getBorderL().add(tretina);
                BigDecimal tretinaOdKonca = interval.getBorderR().subtract(tretina);
                vysledok.add(new Interval(interval.getBorderL().subtract(posun), tretinaOdZaciatku));
                vysledok.add(new Interval(tretinaOdZaciatku.subtract(posun), tretinaOdKonca));
                vysledok.add(new Interval(tretinaOdKonca.subtract(posun), interval.getBorderR().add(posun)));
            } else {
                Rozdelovac rozdelovac = new Rozdelovac(interval);
                Future<ArrayList<Interval>> future = EXECUTOR.submit(rozdelovac);
                futures.add(future);

            }
        }


        for (Future<ArrayList<Interval>> f : futures) {
            ArrayList<Interval> list = f.get();
            vysledok.addAll(list);

        }

        EXECUTOR.shutdown();
        return vysledok;
    }
}
