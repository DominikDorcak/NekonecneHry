package ddorcak.nekonecneHry.core;


public class DoubleInterval {

    private double BorderL;
    private double BorderR;

    public DoubleInterval(double borderL, double borderR) {
        BorderL = borderL;
        BorderR = borderR;
    }

    public double getBorderL() {
        return BorderL;
    }

    public void setBorderL(double borderL) {
        BorderL = borderL;
    }

    public double getBorderR() {
        return BorderR;
    }

    public void setBorderR(double borderR) {
        BorderR = borderR;
    }

    public double getLength(){return BorderR-BorderL;}
}
