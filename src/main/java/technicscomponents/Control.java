package technicscomponents;

public class Control {

    private static int leftI;
    private static int leftJ;
    private static int leftK;
    private static int rightI;
    private static int rightJ;
    private static int rightK;

    //all the variable above stores the information of the last discharged cell coordinates for loop optimization
    private static int countAmount;
    Energy energy;
    private BatteryManagement batteryManagement = BatteryManagement.B;  //default battery level

    public Control(Energy energy) {
        this.energy = energy;
    }


    //changeBatteryUsage method changes the battery usage mode.
    //this method is called when the knob for battery level management is turned in the control panel
    //the default battery usage is set to B--> use both batteries when the main rotor is turned on


    public void changeBatteryUsage(BatteryManagement batteryManagement) {
        this.batteryManagement = batteryManagement;
        useBatteries(600);
        System.out.println("Battery usage level set to: " + batteryManagement);
    }

    public void useBatteries(int RPM) {
        int energyAmount = RPM * 10;

        switch (batteryManagement) {
            case B -> useBothBatteries(energyAmount);
            case L -> useLeftBattery(energyAmount);
            case R -> useRightBattery(energyAmount);
        }
    }

    public void useLeftBattery(int energyAmount) {

        for (int i = leftI; i < 250; i++) {
            for (int j = leftJ; j < 100; j++) {
                for (int k = leftK; k < 50; k++) {
                    if (countAmount == energyAmount) {
                        leftI = i;
                        leftJ = j;
                        leftK = k;
                        break;
                    } else {
                        energy.getLeftBattery().getCells()[i][j][k].dischargeCell();
                        countAmount++;
                    }

                }
                if (countAmount == energyAmount) {
                    break;
                }

            }
            if (countAmount == energyAmount) {
                break;
            }
        }
        System.out.println("left battery consumed till Cell L: " + leftI + " B: " + leftJ + " H: " + leftK);
        countAmount = 0;    //countAmount is a helping variable set to zero at the end

    }

    public void useRightBattery(int energyAmount) {

        for (int i = rightI; i < 250; i++) {
            for (int j = rightJ; j < 100; j++) {
                for (int k = rightK; k < 50; k++) {
                    if (countAmount == energyAmount) {
                        rightI = i;
                        rightJ = j;
                        rightK = k;
                        break;
                    } else {
                        energy.getRightBattery().getCells()[i][j][k].dischargeCell();
                        countAmount++;
                    }

                }
                if (countAmount == energyAmount) {
                    break;
                }
            }
            if (countAmount == energyAmount) {
                break;
            }
        }
        System.out.println("right battery consumed till Cell L: " + rightI + " B: " + rightJ + " H: " + rightK);
        countAmount = 0;
    }

    public void useBothBatteries(int energyAmount) {   //ba
        int energyAmountPerBattery;
        int oneMore;
        if (energyAmount % 2 != 0) {
            energyAmount -= 1;
            energyAmountPerBattery = energyAmount / 2;
            oneMore = energyAmount / 2 + 1;
        } else {
            energyAmountPerBattery = energyAmount / 2;    //battery usage halved for each battery
            oneMore = energyAmount / 2;
        }

        useLeftBattery(oneMore);  //default extra unit used from left battery
        useRightBattery(energyAmountPerBattery);

    }

    public BatteryManagement getBatteryManagement() {
        return batteryManagement;
    }


}
