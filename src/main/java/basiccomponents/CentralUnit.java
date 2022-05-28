package basiccomponents;

import cockpitcomponents.*;
import dronecomponents.Drone;
import dronecomponents.DroneCentralUnit;
import technicscomponents.BatteryManagement;
import technicscomponents.Technics;

import java.io.PrintStream;

public class CentralUnit implements CyclicStick, CollectivePitchControl, Switch, Knob, AntiTorquePedalLeft, AntiTorquePedalRight {

    public final BlackBox blackBox;
    private final Technics technics;
    private final MainRotor mainRotor;
    private final TailRotor tailRotor;
    private final BackEntrance backEntrance;
    private final LandingLight landingLight;
    private final AntiCollisionLight antiCollisionLight;
    private final Drone drone;
    private final DroneCentralUnit droneCentralUnit;
    PrintStream console = System.out;
    private BatteryManagement batteryManagement;

    public CentralUnit(Drone drone, BlackBox blackBox, Technics technics, MainRotor mainRotor, TailRotor tailRotor, BackEntrance backEntrance, LandingLight landingLight, AntiCollisionLight antiCollisionLight) {

        this.technics = technics;
        this.mainRotor = mainRotor;
        this.tailRotor = tailRotor;
        this.backEntrance = backEntrance;
        this.landingLight = landingLight;
        this.antiCollisionLight = antiCollisionLight;
        this.blackBox = blackBox;
        this.drone = drone;
        this.droneCentralUnit = drone.getDroneCentralUnit();
    }

    @Override
    public void raiseCollectivePitchControl() {
        recordAndPrint();
        mainRotor.setRaise(true);
        System.out.println("increasing pitch angle of Main Rotor...");
        System.out.println("--> lifting helicopter....");
    }

    @Override
    public void lowerCollectivePitchControl() {
        recordAndPrint();
        mainRotor.setRaise(false);
        System.out.println("decreasing pitch angle of Main Rotor...");
        System.out.println("--> sinking helicopter....");
    }

    @Override
    public void tiltLeft(int degree) {
        recordAndPrint();
        mainRotor.tiltLeft(degree);
    }

    @Override
    public void tiltRight(int degree) {

        recordAndPrint();
        mainRotor.tiltRight(degree);
    }

    @Override
    public void tiltFront(int degree) {

        recordAndPrint();
        mainRotor.tiltFront(degree);
    }

    @Override
    public void tiltBack(int degree) {

        recordAndPrint();
        mainRotor.tiltBack(degree);
    }


    @Override
    public void switchMainRotorOn() {

        recordAndPrint();

        if (!mainRotor.getIsOn()) {
            mainRotor.switchOn();
            technics.getControl().useBatteries(600);
        } else {
            System.out.println("try to switch on main rotor failed, since motor is already on..");
        }

    }

    @Override
    public void switchMainRotorOff() {
        recordAndPrint();
        if (mainRotor.getIsOn()) {
            mainRotor.switchOff();
        } else {
            System.out.println("try to switch off main rotor failed, since main rotor is already off..");
        }

    }

    @Override
    public void switchTailRotorOn() {
        recordAndPrint();
        tailRotor.switchOn();
        technics.getControl().useBatteries(600);
    }

    @Override
    public void switchTailRotorOff() {
        recordAndPrint();
        tailRotor.switchOff();
    }

    @Override
    public void openBackEntrance() {
        recordAndPrint();
        backEntrance.openBackEntrance();
    }

    @Override
    public void closeBackEntrance() {
        recordAndPrint();
        backEntrance.closeBackEntrance();
    }

    @Override
    public void switchLandingLightOn() {
        recordAndPrint();
        landingLight.switchOn();
    }

    @Override
    public void switchLandingLightOff() {
        recordAndPrint();
        landingLight.switchOff();
    }

    @Override
    public void switchAntiCollisionLightOn() {
        recordAndPrint();
        antiCollisionLight.switchOn();
    }

    @Override
    public void switchAntiCollisionLightOff() {
        recordAndPrint();
        antiCollisionLight.switchOff();
    }

    @Override
    public void freeDrone() {

        System.setOut(console);
        printBeginConsole();
        drone.detach();                         //the drone is detached by the calling the method in the drone class
        droneCentralUnit.switchOnCamera();     // since this drone is managed by droneCentralUnit --> the camera is switched on from central unit of drone
        //as soon as the camera turns on, the contents of the whole landscape is scanned and loaded, the search of the human is also done at this point
        droneCentralUnit.switchOffCamera();
        drone.attach();                      //the drone automatically attaches itself to helicopter after the human has been found

    }

    @Override
    public void changeBatteryUsage(BatteryManagement batteryManagement) {
        recordAndPrint();
        technics.getControl().changeBatteryUsage(batteryManagement);
    }

    @Override
    public void decreaseLift() {
        recordAndPrint();
        tailRotor.decreaseLift();
    }

    @Override
    public void increaseLift() {
        recordAndPrint();
        tailRotor.increaseLift();
    }

    public void recordAndPrint() {
        blackBox.streamToFile();
        System.out.println("-----------------------------");
        System.out.println(blackBox.getLocalDateTime());
    }

    public void printBeginConsole() {
        System.out.println("please find flight history recorded by black box at src/basiccomponents/flight_recorder.txt");
        System.out.println("the console outputs refer to processes related to searching human by the drone...");
        System.out.println();
    }
}
