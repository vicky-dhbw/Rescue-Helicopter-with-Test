package CabinComponents;

import CockpitComponents.Seat;
import Configuration.Configuration;
import HumanComponents.EmergencyDoctor;
import HumanComponents.Paramedic;
import HumanComponents.Patient;

public class Cabin {


    private final Seat[] seats = new Seat[Configuration.INSTANCE.numberOfSeatsInCabin];

    private final SlidingDoors slidingDoors = new SlidingDoors();

    private final TransportUnit transportUnit;

    public Cabin(EmergencyDoctor emergencyDoctor, Paramedic paramedic, Patient patient) {

        transportUnit = new TransportUnit(patient);
        seats[0] = new Seat(paramedic);
        seats[1] = new Seat(emergencyDoctor);
    }

    public TransportUnit getTransportUnit() {
        return transportUnit;
    }
}
