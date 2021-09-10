package ddorcak.nekonecneHry.core;

import java.math.BigDecimal;

public class BigDecimalInterval {

    private BigDecimal BorderL;
    private BigDecimal BorderR;

    public BigDecimalInterval(BigDecimal borderL, BigDecimal borderR) {
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
