package BasicComponents;
import Configuration.Configuration;
import CockpitComponents.*;

public class Rotor {

    private  final int highestSpeedKmp= Configuration.INSTANCE.highestSpeedKmp;

    private final int normalSpeedKmp=Configuration.INSTANCE.normalSpeedKmp;

    private boolean isOn;

    public void switchOn(){
        isOn=true;
    }

    public void switchOff(){
        isOn=false;
    }

    public boolean getIsOn(){
        return isOn;
    }

}

