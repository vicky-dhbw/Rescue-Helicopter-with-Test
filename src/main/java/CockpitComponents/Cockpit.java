package CockpitComponents;
import BasicComponents.*;
import Configuration.*;
import HumanComponents.Pilot;

public class Cockpit {

    private final Position position;
    private final Entrance entrance;
    private final Seat seat;
    private final Display display;
    private final CyclicStick cyclic_stick;
    private final CollectivePitchControl collective_pitch_control;

    private final AntiTorquePedalLeft antiTorquePedalLeft;
    private final AntiTorquePedalRight antiTorquePedalRight;


    private final Control_Panel control_panel;
    public Cockpit(Position position, CentralUnit centralUnit, Pilot pilot){
        this.position=position;
        entrance=new Entrance();
        seat=new Seat(pilot);
        display=new Display();
        cyclic_stick=centralUnit;
        collective_pitch_control=centralUnit;

        control_panel=new Control_Panel(centralUnit);
        antiTorquePedalLeft=centralUnit;
        antiTorquePedalRight=centralUnit;


    }

    public Control_Panel getControl_panel(){
        return control_panel;
    }

    public CollectivePitchControl getCollective_pitch_control(){
        return collective_pitch_control;
    }

    public CyclicStick getCyclic_stick(){
        return cyclic_stick;
    }

    public AntiTorquePedalLeft getAntiTorquePedalLeft(){
        return antiTorquePedalLeft;
    }

    public AntiTorquePedalRight getAntiTorquePedalRight(){
        return antiTorquePedalRight;
    }
}

