import BasicComponents.CentralUnit;
import BasicComponents.Manufacturer;
import BasicComponents.RescueHelicopter;
import HumanComponents.Gender;
import HumanComponents.Human;
import HumanComponents.Patient;
import TechnicsComponents.BatteryManagement;

import java.io.FileNotFoundException;
import java.util.Date;

public class Builder {

    public static void main(String[] args) throws FileNotFoundException {
        int i=0;

      /*  Human notSmoker = new Human(false, false);
       Human smoker = new Human(false,  true);
        Patient patientNotSmoker = new Patient(false);
        Patient patientSmoker = new Patient(true);
        patientSmoker.breatheIn();
        patientNotSmoker.breatheIn();
        patientSmoker.breatheOut();
        patientNotSmoker.breatheOut();
        notSmoker.breatheIn();
        smoker.breatheIn();
        notSmoker.breatheOut();
        smoker.breatheOut();
        patientSmoker.breatheIn();
        patientNotSmoker.breatheIn();
        patientSmoker.breatheOut();
        patientNotSmoker.breatheOut();
        notSmoker.breatheIn();
        smoker.breatheIn();
        notSmoker.breatheOut();
        smoker.breatheOut();
        patientSmoker.breatheIn();
        patientNotSmoker.breatheIn();
        patientSmoker.breatheOut();
        patientNotSmoker.breatheOut();
        notSmoker.breatheIn();
        smoker.breatheIn();
        notSmoker.breatheOut();
        smoker.breatheOut();
        patientSmoker.breatheIn();
        patientNotSmoker.breatheIn();
        patientSmoker.breatheOut();
        patientNotSmoker.breatheOut();
        notSmoker.breatheIn();
        smoker.breatheIn();
        notSmoker.breatheOut();
        smoker.breatheOut();
        patientSmoker.breatheIn();
        patientNotSmoker.breatheIn();
        patientSmoker.breatheOut();
        patientNotSmoker.breatheOut();
        notSmoker.breatheIn();
        smoker.breatheIn();
        notSmoker.breatheOut();
        smoker.breatheOut();
        patientSmoker.breatheIn();
        patientNotSmoker.breatheIn();
        patientSmoker.breatheOut();
        patientNotSmoker.breatheOut();
        notSmoker.breatheIn();
        smoker.breatheIn();
        notSmoker.breatheOut();
        smoker.breatheOut();
        patientSmoker.breatheIn();
        patientNotSmoker.breatheIn();
        patientSmoker.breatheOut();
        patientNotSmoker.breatheOut();
        notSmoker.breatheIn();
        smoker.breatheIn();
        notSmoker.breatheOut();
        smoker.breatheOut();
        patientSmoker.breatheIn();
        patientNotSmoker.breatheIn();
        patientSmoker.breatheOut();
        patientNotSmoker.breatheOut();
        notSmoker.breatheIn();
        smoker.breatheIn();
        notSmoker.breatheOut();
        smoker.breatheOut();
        patientSmoker.breatheIn();
        patientNotSmoker.breatheIn();
        patientSmoker.breatheOut();
        patientNotSmoker.breatheOut();
        notSmoker.breatheIn();
        smoker.breatheIn();
        notSmoker.breatheOut();
        smoker.breatheOut();
        patientSmoker.breatheIn();
        patientNotSmoker.breatheIn();
        patientSmoker.breatheOut();
        patientNotSmoker.breatheOut();
        notSmoker.breatheIn();
        smoker.breatheIn();
        notSmoker.breatheOut();
        smoker.breatheOut();
        patientSmoker.breatheIn();
        patientNotSmoker.breatheIn();
        patientSmoker.breatheOut();
        patientNotSmoker.breatheOut();
        notSmoker.breatheIn();
        smoker.breatheIn();
        notSmoker.breatheOut();
        smoker.breatheOut();
        patientSmoker.breatheIn();
        patientNotSmoker.breatheIn();
        patientSmoker.breatheOut();
        patientNotSmoker.breatheOut();
        notSmoker.breatheIn();
        smoker.breatheIn();
        notSmoker.breatheOut();
        smoker.breatheOut();*/

        RescueHelicopter rescueHelicopter=new RescueHelicopter(Manufacturer.AIRBUS);
        rescueHelicopter.getCockpitLeft().getControl_panel().switchOnOffMainRotor(true);
        rescueHelicopter.getCockpitLeft().getControl_panel().setDroneFree();     //Note: the drone loads all sections in storage after it detaches
        rescueHelicopter.getCockpitLeft().getControl_panel().changeEnergyUsage(BatteryManagement.L);
        rescueHelicopter.getCockpitLeft().getControl_panel().switchOnOffMainRotor(true);
        rescueHelicopter.getCockpitLeft().getControl_panel().changeEnergyUsage(BatteryManagement.B);
        rescueHelicopter.getCockpitLeft().getControl_panel().switchOnOffMainRotor(false);
        rescueHelicopter.getCockpitLeft().getControl_panel().switchOnOffMainRotor(true);
        rescueHelicopter.getCockpitLeft().getControl_panel().switchOnOffLandingLight(true);

        rescueHelicopter.getCockpitLeft().getCollective_pitch_control().raiseCollectivePitchControl();
        rescueHelicopter.getCockpitLeft().getCollective_pitch_control().lowerCollectivePitchControl();
        rescueHelicopter.getCockpitLeft().getCollective_pitch_control().raiseCollectivePitchControl();

        rescueHelicopter.getCockpitLeft().getCyclic_stick().tiltLeft(1);
        rescueHelicopter.getCockpitLeft().getCyclic_stick().tiltBack(3);
        rescueHelicopter.getCockpitLeft().getCyclic_stick().tiltFront(5);
        rescueHelicopter.getCockpitLeft().getCyclic_stick().tiltRight(4);

        rescueHelicopter.getCockpitLeft().getControl_panel().switchOnOffAntiCollisionLight(true);
        rescueHelicopter.getCockpitLeft().getControl_panel().switchOnOffAntiCollisionLight(false);
        rescueHelicopter.getCockpitLeft().getControl_panel().switchOnOffAntiCollisionLight(true);

        rescueHelicopter.getCockpitLeft().getControl_panel().openCloseBackEntrance(true);
        rescueHelicopter.getCockpitLeft().getControl_panel().openCloseBackEntrance(false);

        rescueHelicopter.getCockpitLeft().getAntiTorquePedalLeft().decreaseLift();
        rescueHelicopter.getCockpitLeft().getAntiTorquePedalRight().increaseLift();
        rescueHelicopter.getCockpitLeft().getAntiTorquePedalLeft().decreaseLift();


    }
}
