package basiccomponents;

import cabincomponents.Cabin;
import cockpitcomponents.Cockpit;
import configuration.Position;
import dronecomponents.Drone;
import humancomponents.EmergencyDoctor;
import humancomponents.Paramedic;
import humancomponents.Patient;
import humancomponents.Pilot;
import technicscomponents.Technics;

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
    private final BackEntrance backEntrance = new BackEntrance();
    private final LandingLight landingLight = new LandingLight();
    private final AntiCollisionLight antiCollisionLight = new AntiCollisionLight();
    private final MainRotor mainRotor;
    private final TailRotor tailRotor;
    private final Technics technics;

    private final Type type;



    public RescueHelicopter(Manufacturer manufacturer, Type type) {

        this.manufacturer = manufacturer;
        this.type=Type.M145;
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
