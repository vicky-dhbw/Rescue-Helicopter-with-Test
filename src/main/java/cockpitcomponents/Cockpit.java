package cockpitcomponents;

import basiccomponents.CentralUnit;
import configuration.Position;
import humancomponents.Pilot;

public class Cockpit {

    private final Position position;
    private final Entrance entrance;
    private final Seat seat;
    private final Display display;
    private final CyclicStick cyclicStick;
    private final CollectivePitchControl collectivePitchControl;

    private final AntiTorquePedalLeft antiTorquePedalLeft;
    private final AntiTorquePedalRight antiTorquePedalRight;


    private final ControlPanel controlPanel;

    public Cockpit(Position position, CentralUnit centralUnit, Pilot pilot) {
        this.position = position;
        entrance = new Entrance();
        seat = new Seat(pilot);
        display = new Display();
        cyclicStick = centralUnit;
        collectivePitchControl = centralUnit;

        controlPanel = new ControlPanel(centralUnit);
        antiTorquePedalLeft = centralUnit;
        antiTorquePedalRight = centralUnit;


    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public CollectivePitchControl getCollectivePitchControl() {
        return collectivePitchControl;
    }

    public CyclicStick getCyclicStick() {
        return cyclicStick;
    }

    public AntiTorquePedalLeft getAntiTorquePedalLeft() {
        return antiTorquePedalLeft;
    }

    public AntiTorquePedalRight getAntiTorquePedalRight() {
        return antiTorquePedalRight;
    }
}

