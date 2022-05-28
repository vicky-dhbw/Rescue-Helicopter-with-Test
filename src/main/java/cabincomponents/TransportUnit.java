package cabincomponents;

import humancomponents.Patient;

public class TransportUnit {

    private final Patient patient;

    public TransportUnit(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }
}
