package basiccomponents;

public class LandingLight {

    private boolean isOn = false;

    public void switchOn() {
        isOn = true;
    }

    public void switchOff() {
        isOn = false;
    }

    public boolean getIsOn() {
        return isOn;
    }
}
