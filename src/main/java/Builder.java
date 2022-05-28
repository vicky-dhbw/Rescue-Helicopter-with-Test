import basiccomponents.Manufacturer;
import basiccomponents.RescueHelicopter;
import technicscomponents.BatteryManagement;

public class Builder {

    public static void main(String[] args){

        RescueHelicopter rescueHelicopter = new RescueHelicopter(Manufacturer.AIRBUS);
        rescueHelicopter.getCockpitLeft().getControlPanel().switchOnOffMainRotor(true);
        rescueHelicopter.getCockpitLeft().getControlPanel().changeEnergyUsage(BatteryManagement.L);
        rescueHelicopter.getCockpitLeft().getControlPanel().setDroneFree();     //Note: the drone loads all sections in storage after it detaches
        rescueHelicopter.getCockpitLeft().getControlPanel().changeEnergyUsage(BatteryManagement.B);
        rescueHelicopter.getCockpitLeft().getControlPanel().switchOnOffMainRotor(false);
        rescueHelicopter.getCockpitLeft().getControlPanel().switchOnOffMainRotor(true);
        rescueHelicopter.getCockpitLeft().getControlPanel().switchOnOffLandingLight(true);

        rescueHelicopter.getCockpitLeft().getCollectivePitchControl().raiseCollectivePitchControl();
        rescueHelicopter.getCockpitLeft().getCollectivePitchControl().lowerCollectivePitchControl();
        rescueHelicopter.getCockpitLeft().getCollectivePitchControl().raiseCollectivePitchControl();

        rescueHelicopter.getCockpitLeft().getCyclicStick().tiltLeft(1);
        rescueHelicopter.getCockpitLeft().getCyclicStick().tiltBack(3);
        rescueHelicopter.getCockpitLeft().getCyclicStick().tiltFront(5);
        rescueHelicopter.getCockpitLeft().getCyclicStick().tiltRight(4);

        rescueHelicopter.getCockpitLeft().getControlPanel().switchOnOffAntiCollisionLight(true);
        rescueHelicopter.getCockpitLeft().getControlPanel().switchOnOffAntiCollisionLight(false);
        rescueHelicopter.getCockpitLeft().getControlPanel().switchOnOffAntiCollisionLight(true);

        rescueHelicopter.getCockpitLeft().getControlPanel().openCloseBackEntrance(true);
        rescueHelicopter.getCockpitLeft().getControlPanel().openCloseBackEntrance(false);

        rescueHelicopter.getCockpitLeft().getAntiTorquePedalLeft().decreaseLift();
        rescueHelicopter.getCockpitLeft().getAntiTorquePedalRight().increaseLift();
        rescueHelicopter.getCockpitLeft().getAntiTorquePedalLeft().decreaseLift();


    }
}
