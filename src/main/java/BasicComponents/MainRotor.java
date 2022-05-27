package BasicComponents;
import CockpitComponents.Directions;

public class MainRotor extends Rotor {

    public boolean raise=false;
    public int angleRotorBlades;

    private double speed;

    Directions direction;


    public void switchOn(){
        super.switchOn();
        System.out.println("main rotor switched on!");
    }

    public void switchOff(){
        super.switchOff();
        System.out.println("main rotor switched off!");
    }
    public boolean getRaise(){
        return raise;
    }

    public void setRaise(boolean setRaise) {

        raise=setRaise;
    }

    public void tiltLeft(int degree) {

        speed=degree*50;
        direction = Directions.LEFT;
        angleRotorBlades = degree;
        System.out.println("Cyclic stick moved "+degree+ " degree "+ direction);
        System.out.println("helicopter going " + direction+" with a speed of "+ speed+ " km/h ....");
    }

    public void tiltRight(int degree) {

        speed=degree*50;
        direction=Directions.RIGHT;
        angleRotorBlades=degree;
        System.out.println("Cyclic stick moved "+degree+ " degree "+ direction);
        System.out.println("helicopter going " + direction+" with a speed of "+ speed+ " km/h ....");

    }

    public void tiltFront(int degree) {

        speed=degree*50;
        direction=Directions.FORWARD;
        angleRotorBlades=degree;
        System.out.println("Cyclic stick moved "+degree+ " degree "+ direction);
        System.out.println("helicopter going " + direction+" with a speed of "+ speed+ " km/h ....");

    }

    public void tiltBack(int degree) {

        speed=degree*50;
        direction=Directions.BACKWARD;
        angleRotorBlades=degree;
        System.out.println("Cyclic stick moved "+degree+ " degree "+ direction);
        System.out.println("helicopter going " + direction+" with a speed of "+ speed+ " km/h ....");

    }

    public double getSpeed(){
        return speed;
    }

    public int getAngleRotorBlades(){
        return angleRotorBlades;
    }

    public Directions getDirection(){
        return direction;
    }
}

