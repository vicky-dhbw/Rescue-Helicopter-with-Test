package TechnicsComponents;


public class Technics {

    private final Energy energy;
    private final Control control;

    public Technics() {
        energy = new Energy();
        control = new Control(energy);
    }

    public Control getControl() {
        return control;
    }

    public Energy getEnergy() {
        return energy;
    }


}
