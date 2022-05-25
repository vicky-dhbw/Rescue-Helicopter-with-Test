package CabinComponents;
import BasicComponents.BackEntrance;
import CockpitComponents.Seat;
import Configuration.*;

public class Cabin {


    private final Seat[] seats=new Seat[Configuration.INSTANCE.numberOfSeatsInCabin];

    private final SlidingDoors slidingDoors=new SlidingDoors();

    private TransportUnit transportUnit=new TransportUnit();


}
