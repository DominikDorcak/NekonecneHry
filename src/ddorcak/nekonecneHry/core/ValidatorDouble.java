package ddorcak.nekonecneHry.core;

import java.util.Collections;
import java.util.List;

public class ValidatorDouble {


    public static boolean cowered(DoubleInterval interval, List<DoubleInterval> choosen) {
        Collections.sort(choosen,new DoubleIntervalComparator());
        if(interval.getBorderL()<choosen.get(0).getBorderL()){
            return false;
        }else{
            DoubleInterval aktualny = choosen.get(0);
            for (int i = 0; i < choosen.size(); i++) {
                    if (choosen.get(i).getBorderR()>(aktualny.getBorderR())){
                        if(choosen.get(i).getBorderL()<(aktualny.getBorderR())){
                            aktualny=choosen.get(i);
                        }else {
                            return false;
                        }
                    }
            }
            return (aktualny.getBorderR()>(interval.getBorderR()));
        }



    }
}
