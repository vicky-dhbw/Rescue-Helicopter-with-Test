package TechnicsComponents;

import BasicComponents.BackEntrance;

import java.util.Map.Entry;

public class Energy {

    private Battery leftBattery;
    private Battery rightBattery;

    public Energy(){
        leftBattery = new Battery();
        rightBattery = new Battery();
    }
    public Battery getLeftBattery(){
        return leftBattery;
    }
    public Battery getRightBattery(){
        return rightBattery;
    }
}
