package ddorcak.nekonecneHry.charts;

import javafx.scene.chart.ValueAxis;

import java.util.List;

public class IntervalAxis  extends ValueAxis {

   public IntervalAxis(){
       this.setVisible(false);
       this.setTickLabelsVisible(false);
       this.setTickMarkVisible(false);
       this.setMinorTickCount(0);
   }

    @Override
    protected List calculateMinorTickMarks() {
        return null;
    }

    @Override
    protected void setRange(Object range, boolean animate) {

    }

    @Override
    protected Object getRange() {
        return null;
    }

    @Override
    public double getDisplayPosition(Object value) {
        return 0;
    }

    @Override
    public boolean isValueOnAxis(Object value) {
        return false;
    }

    @Override
    public double toNumericValue(Object value) {
        return 0;
    }

    @Override
    protected List calculateTickValues(double length, Object range) {
        return null;
    }

    @Override
    protected String getTickMarkLabel(Object value) {
        return null;
    }
}
