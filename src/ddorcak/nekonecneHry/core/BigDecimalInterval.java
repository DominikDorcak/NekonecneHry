package ddorcak.nekonecneHry.core;

import java.math.BigDecimal;

public class Interval {

    private BigDecimal BorderL;
    private BigDecimal BorderR;

    public Interval(BigDecimal borderL, BigDecimal borderR) {
        BorderL = borderL;
        BorderR = borderR;
    }

    public BigDecimal getBorderL() {
        return BorderL;
    }

    public void setBorderL(BigDecimal borderL) {
        BorderL = borderL;
    }

    public BigDecimal getBorderR() {
        return BorderR;
    }

    public void setBorderR(BigDecimal borderR) {
        BorderR = borderR;
    }

    public BigDecimal getLength(){return BorderR.subtract(BorderL);}
}
