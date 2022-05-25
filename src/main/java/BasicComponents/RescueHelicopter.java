package BasicComponents;

import DroneComponents.*;
import CockpitComponents.Cockpit;
import Configuration.Position;
import TechnicsComponents.Technics;

import java.io.FileNotFoundException;
import java.util.UUID;

public class RescueHelicopter {

    private final UUID serialNumber;
    private final Manufacturer manufacturer;

    private final MainRotor mainRotor;
    private final TailRotor tailRotor;

    private final Technics technics;

    private final CentralUnit centralUnit;

    public final BlackBox blackBox;

    private final Drone drone;

    Cockpit cockpitLeft;
    Cockpit cockpitRight;

    BackEntrance backEntrance=new BackEntrance();

    LandingLight landingLight=new LandingLight();

    AntiCollisionLight antiCollisionLight=new AntiCollisionLight();


    public RescueHelicopter(Manufacturer manufacturer){

        this.manufacturer=manufacturer;
        serialNumber= UUID.randomUUID();

        mainRotor=new MainRotor();
        tailRotor=new TailRotor();
        technics=new Technics();
        blackBox=new BlackBox();
        drone=new Drone();


        centralUnit=new CentralUnit(drone,blackBox,technics,mainRotor, tailRotor,backEntrance, landingLight, antiCollisionLight);
        cockpitLeft=new Cockpit(Position.LEFT, centralUnit);
        cockpitRight=new Cockpit(Position.RIGHT, centralUnit);


    }

    public Cockpit getCockpitLeft(){
        return cockpitLeft;
    }

    public Cockpit getCockpitRight(){
        return cockpitRight;
    }


}
