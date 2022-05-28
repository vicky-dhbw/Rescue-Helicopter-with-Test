package cockpitcomponents;

import humancomponents.Staff;

public class Seat {

    private final Staff staff;
    private final SafetyBelt safetyBelt = new SafetyBelt();

    public Seat(Staff staff) {
        this.staff = staff;
    }

    public Staff getStaff() {
        return staff;
    }
}
