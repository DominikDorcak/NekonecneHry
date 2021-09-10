package ddorcak.nekonecneHry.core;

import java.math.BigDecimal;
import java.util.Comparator;

public class DoubleIntervalComparator implements Comparator<DoubleInterval> {

    @Override
    public int compare(DoubleInterval o1, DoubleInterval o2) {
        double borderL1 = o1.getBorderL();
        double borderR1 = o1.getBorderR();
        double borderL2 = o2.getBorderL();
        double borderR2 = o2.getBorderR();

        if (borderL1 == borderL2) {
            return (int) ((borderR1-borderR2));
        } else {
            return (int) (borderL1-borderL2 );
        }
    }
}
