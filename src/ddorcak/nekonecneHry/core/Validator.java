package ddorcak.nekonecneHry.core;

import java.util.Collections;
import java.util.List;

public class Validator {


    public boolean cowered(Interval interval, List<Interval> choosen) {
        Collections.sort(choosen,new IntervalComparator());
        if(interval.getBorderL().compareTo(choosen.get(0).getBorderL())<0){
            return false;
        }else{
            Interval aktualny = choosen.get(0);
            for (int i = 0; i < choosen.size(); i++) {
                    if (choosen.get(i).getBorderR().compareTo(aktualny.getBorderR())>0){
                        if(choosen.get(i).getBorderL().compareTo(aktualny.getBorderR())<0){
                            aktualny=choosen.get(i);
                        }else {
                            return false;
                        }
                    }
            }
            return (aktualny.getBorderR().compareTo(interval.getBorderR())>0);
        }



    }
}
