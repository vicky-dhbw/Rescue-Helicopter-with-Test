package TechnicsComponents;


import CockpitComponents.Knob;

public class Technics{

    private Energy energy;
    private Control control;
    public Technics(){
        energy = new Energy();
        control = new Control(energy);
    }

    public Control getControl(){
        return control;
    }

    public Energy getEnergy(){
        return energy;
    }


}
