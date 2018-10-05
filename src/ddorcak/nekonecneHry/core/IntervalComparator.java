package ddorcak.nekonecneHry.core;

import java.util.Comparator;

public class IntervalComparator implements Comparator<Interval> {

    @Override
    public int compare(Interval o1, Interval o2) {
        float borderL1 = o1.getBorderL();
        float borderR1 = o1.getBorderR();
        float borderL2 = o2.getBorderL();
        float borderR2 = o2.getBorderR();

        if (borderL1 == borderL2) {
            return (int) (borderR1 - borderR2);
        } else {
            return (int) (borderL1 - borderL2);
        }
    }
}
