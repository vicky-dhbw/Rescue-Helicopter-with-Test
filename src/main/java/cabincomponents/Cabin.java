package cabincomponents;

import cockpitcomponents.Seat;
import configuration.Configuration;
import humancomponents.EmergencyDoctor;
import humancomponents.Paramedic;
import humancomponents.Patient;

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
