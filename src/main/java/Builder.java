import basiccomponents.Manufacturer;
import basiccomponents.RescueHelicopter;
import basiccomponents.Type;
import technicscomponents.BatteryManagement;

public class Builder {

    public static void main(String[] args){

        RescueHelicopter rescueHelicopter = new RescueHelicopter(Manufacturer.AIRBUS, Type.M145);
        rescueHelicopter.getCockpitLeft().getControlPanel().switchOnOffMainRotor(true);
        rescueHelicopter.getCockpitLeft().getControlPanel().switchOnOffTailRotor(true);

        rescueHelicopter.getCockpitLeft().getCollectivePitchControl().raiseCollectivePitchControl();
        rescueHelicopter.getCockpitLeft().getCyclicStick().tiltLeft(1);
        rescueHelicopter.getCockpitLeft().getCyclicStick().tiltBack(3);
        rescueHelicopter.getCockpitLeft().getControlPanel().changeEnergyUsage(BatteryManagement.L);
        rescueHelicopter.getCockpitLeft().getControlPanel().setDroneFree();     //Note: the drone loads all sections in storage after it detaches
        rescueHelicopter.getCockpitLeft().getControlPanel().changeEnergyUsage(BatteryManagement.B);


        rescueHelicopter.getCockpitLeft().getAntiTorquePedalLeft().decreaseLift();

        rescueHelicopter.getCockpitLeft().getAntiTorquePedalRight().increaseLift();
        rescueHelicopter.getCockpitLeft().getAntiTorquePedalLeft().decreaseLift();

        rescueHelicopter.getCockpitLeft().getCyclicStick().tiltFront(5);
        rescueHelicopter.getCockpitLeft().getCyclicStick().tiltRight(4);
        rescueHelicopter.getCockpitLeft().getCyclicStick().tiltFront(3);

        rescueHelicopter.getCockpitLeft().getControlPanel().switchOnOffAntiCollisionLight(true);
        rescueHelicopter.getCockpitLeft().getCyclicStick().tiltBack(1);
        rescueHelicopter.getCockpitLeft().getCyclicStick().tiltLeft(5);

        rescueHelicopter.getCockpitRight().getControlPanel().changeEnergyUsage(BatteryManagement.R);

        rescueHelicopter.getCockpitLeft().getControlPanel().switchOnOffAntiCollisionLight(false);
        rescueHelicopter.getCockpitLeft().getControlPanel().switchOnOffLandingLight(true);
        rescueHelicopter.getCockpitLeft().getCollectivePitchControl().lowerCollectivePitchControl();

        rescueHelicopter.getCockpitLeft().getControlPanel().openCloseBackEntrance(true);

        rescueHelicopter.getCockpitRight().getControlPanel().switchOnOffTailRotor(false);
        rescueHelicopter.getCockpitRight().getControlPanel().switchOnOffMainRotor(false);

    }
}
