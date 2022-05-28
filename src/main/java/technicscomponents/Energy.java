package technicscomponents;

public class Energy {

    private final Battery leftBattery;
    private final Battery rightBattery;

    public Energy() {
        leftBattery = new Battery();
        rightBattery = new Battery();
    }

    public Battery getLeftBattery() {
        return leftBattery;
    }

    public Battery getRightBattery() {
        return rightBattery;
    }
}
