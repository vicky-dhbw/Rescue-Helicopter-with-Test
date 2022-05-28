package BasicComponents;

import CabinComponents.Cabin;
import CockpitComponents.Cockpit;
import Configuration.Position;
import DroneComponents.Drone;
import HumanComponents.EmergencyDoctor;
import HumanComponents.Paramedic;
import HumanComponents.Patient;
import HumanComponents.Pilot;
import TechnicsComponents.Technics;

import java.util.UUID;

public class RescueHelicopter {

    public final BlackBox blackBox;
    private final UUID serialNumber;
    private final Manufacturer manufacturer;
    private final CentralUnit centralUnit;
    private final Drone drone;

    private final Cockpit cockpitLeft;
    private final Cockpit cockpitRight;
    private final Cabin cabin;
    BackEntrance backEntrance = new BackEntrance();
    LandingLight landingLight = new LandingLight();
    AntiCollisionLight antiCollisionLight = new AntiCollisionLight();
    MainRotor mainRotor;
    TailRotor tailRotor;
    Technics technics;


    public RescueHelicopter(Manufacturer manufacturer) {

        this.manufacturer = manufacturer;
        serialNumber = UUID.randomUUID();
        blackBox = new BlackBox();
        drone = new Drone();
        mainRotor = new MainRotor();
        tailRotor = new TailRotor();
        technics = new Technics();
        final Pilot pilot1 = new Pilot();
        final Pilot pilot2 = new Pilot();
        EmergencyDoctor emergencyDoctor = new EmergencyDoctor();
        Paramedic paramedic = new Paramedic();
        Patient patient = new Patient();

        cabin = new Cabin(emergencyDoctor, paramedic, patient);


        centralUnit = new CentralUnit(drone, blackBox, technics, mainRotor, tailRotor, backEntrance, landingLight, antiCollisionLight);
        cockpitLeft = new Cockpit(Position.LEFT, centralUnit, pilot1);
        cockpitRight = new Cockpit(Position.RIGHT, centralUnit, pilot2);


    }

    public Cockpit getCockpitLeft() {
        return cockpitLeft;
    }

    public Cockpit getCockpitRight() {
        return cockpitRight;
    }


    public UUID getSerialNumber() {
        return serialNumber;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Cabin getCabin() {
        return cabin;
    }

    public CentralUnit getCentralUnit() {
        return centralUnit;
    }

    public MainRotor getMainMotor() {
        return mainRotor;
    }

    public TailRotor getTailRotor() {
        return tailRotor;
    }

    public Technics getTechnics() {
        return technics;
    }

    public Drone getDrone() {
        return drone;
    }


    public AntiCollisionLight getAntiCollisionLight() {
        return antiCollisionLight;
    }

    public BackEntrance getBackEntrance() {
        return backEntrance;
    }

    public LandingLight getLandingLight() {
        return landingLight;
    }


}
