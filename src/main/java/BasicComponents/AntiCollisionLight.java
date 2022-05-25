package BasicComponents;

import CockpitComponents.Switch;

public class AntiCollisionLight {

    private boolean isOn=false;
    public void switchOn(){
        isOn=true;
        System.out.println("Anti collision light switched on!");
    }

    public void switchOff(){
        isOn=false;
        System.out.println("Anti collision light switched off!");
    }
}
