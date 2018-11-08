package ddorcak.nekonecneHry.core;

import java.math.BigDecimal;
import java.util.Comparator;

public class IntervalComparator implements Comparator<Interval> {

    @Override
    public int compare(Interval o1, Interval o2) {
        BigDecimal borderL1 = o1.getBorderL();
        BigDecimal borderR1 = o1.getBorderR();
        BigDecimal borderL2 = o2.getBorderL();
        BigDecimal borderR2 = o2.getBorderR();

        if (borderL1 == borderL2) {
            return (borderR1.subtract(borderR2).intValue() );
        } else {
            return (borderL1.subtract(borderL2).intValue() );
        }
    }
}
