public class Click {
    double clickValue = 1.0;
    double clickMultiplier = 1.0;

    public Click() {
    }

    public void click() {
        clickValue += clickMultiplier;
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
