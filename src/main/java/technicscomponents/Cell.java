package technicscomponents;

public class Cell {

    private boolean isCharged;

    public Cell() {
        isCharged = true;
    }

    public void dischargeCell() {
        isCharged = false;
    }

    public boolean getIsCharged() {
        return isCharged;
    }


}
