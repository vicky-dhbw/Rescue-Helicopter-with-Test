package CockpitComponents;
import BasicComponents.*;
import TechnicsComponents.BatteryManagement;
import TechnicsComponents.Technics;

public class Control_Panel {

    Switch mainRotor;

    Switch tailRotor;

    Switch backEntrance;

    Switch landingLight;

    Switch antiCollisionLight;

    Switch drone;

    Knob technics;

    public void switchOnOffMainRotor(boolean switchOn){

        if(switchOn){

            mainRotor.switchMainRotorOn();
        }
        else {
            mainRotor.switchMainRotorOff();
        }
    }

    public void switchOnOffTailRotor(boolean switchOn){
        if(switchOn){
            tailRotor.switchTailRotorOn();
        }
        else {
            tailRotor.switchTailRotorOff();
        }

    }

    public void openCloseBackEntrance(boolean openClose){
        if(openClose){
            backEntrance.openBackEntrance();

        }
        else {
            backEntrance.closeBackEntrance();

        }

    }
    public void changeEnergyUsage(BatteryManagement batteryManagement){
        technics.changeBatteryUsage(batteryManagement);
    }

    public void switchOnOffAntiCollisionLight(boolean switchOn){
        if(switchOn){
            antiCollisionLight.switchAntiCollisionLightOn();
        }
        else {
            antiCollisionLight.switchAntiCollisionLightOff();
        }
    }

    public void switchOnOffLandingLight(boolean switchOn){
        if(switchOn){
            landingLight.switchLandingLightOn();
        }
        else {
            landingLight.switchLandingLightOff();
        }
    }

    public void setDroneFree(){

        drone.freeDrone();
    }
    public Control_Panel(CentralUnit centralUnit){
        this.mainRotor=centralUnit;
        this.tailRotor=centralUnit;
        this.backEntrance=centralUnit;
        this.landingLight=centralUnit;
        this.antiCollisionLight=centralUnit;
        this.technics=centralUnit;
        this.drone=centralUnit;
    }


}
