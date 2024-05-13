public class Click {
    private double clickValue = 1.0;
    private double clickMultiplier = 1.0;
    private double cps = 0;

    public Click() {
    }

    public double click() {
        return clickValue * clickMultiplier;
    }

    public double getCps() {
        return cps;
    }

    public void setCps(double cps) {
        this.cps = cps;
    }

    public double getClickValue() {
        return clickValue;
    }

    public void setClickValue(double clickValue) {
        this.clickValue = clickValue;
    }

    public double getClickMultiplier() {
        return clickMultiplier;
    }

    public void setClickMultiplier(double clickMultiplier) {
        this.clickMultiplier = clickMultiplier;
    }



}
