package CabinComponents;

import HumanComponents.Paramedic;
import HumanComponents.Patient;

public class TransportUnit {

    private final Patient patient;

    public TransportUnit(Patient patient){
        this.patient=patient;
    }

    public Patient getPatient(){
        return patient;
    }
}
