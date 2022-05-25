package BasicComponents;
import CockpitComponents.*;

public class TailRotor extends Rotor{

    private boolean liftIncreased=false;


    public void decreaseLift() {
        liftIncreased=false;
        System.out.println("---> lift of tail rotor is decreased.");
        System.out.println("yawing the helicopter to the left...");
        System.out.println("tail of the helicopter is turning in the direction of the rotation of main rotor..");
    }


    public void increaseLift() {

        liftIncreased=true;
        System.out.println("---> lift of tail rotor is increased.");
        System.out.println("yawing the helicopter to the right...");
        System.out.println("tail of the helicopter is turning opposite to the direction of the rotation of main rotor..");
    }
}
