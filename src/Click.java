public class Click {
    private double clickValue;
    private double clickMultiplier;
    private double cps;

    public Click() {
        this.clickValue = 1.0;
        this.clickMultiplier = 1.0;
        this.cps = 0;
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

