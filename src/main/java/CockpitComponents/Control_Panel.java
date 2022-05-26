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

        drone.freeDrone();                      //--> the method is in Central unit --> the central unit then detaches the drone
                                                //--> the central unit turns on the camera of the drone from there
                                                //--> and loading contents of sections and search of the human is also present there
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
