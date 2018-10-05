package ddorcak.nekonecneHry.core;

public class Interval {

    private float BorderL;
    private float BorderR;

    public Interval(float borderL, float borderR) {
        BorderL = borderL;
        BorderR = borderR;
    }

    public float getBorderL() {
        return BorderL;
    }

    public void setBorderL(float borderL) {
        BorderL = borderL;
    }

    public float getBorderR() {
        return BorderR;
    }

    public void setBorderR(float borderR) {
        BorderR = borderR;
    }
}
