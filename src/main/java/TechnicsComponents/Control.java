package TechnicsComponents;

public class Control {

    public static int tempK;
    private static int leftI;
    private static int leftJ;
    private static int leftK;
    private static int rightI;
    private static int rightJ;
    private static int rightK;
    private static int countAmount;
    Energy energy;
    private BatteryManagement batteryManagement = BatteryManagement.B;

    public Control(Energy energy) {
        this.energy = energy;
    }

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

        tempK = 0;
        for (int i = leftI; i < 250; i++) {
            for (int j = leftJ; j < 100; j++) {
                for (int k = leftK; k < 50; k++) {
                    if (countAmount == energyAmount) {
                        leftI = i;
                        leftJ = j;
                        leftK = k;
                        tempK = rightK + 1;
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
        countAmount = 0;

    }

    public void useRightBattery(int energyAmount) {
        tempK = 0;

        for (int i = rightI; i < 250; i++) {
            for (int j = rightJ; j < 100; j++) {
                for (int k = rightK; k < 50; k++) {
                    if (countAmount == energyAmount) {
                        rightI = i;
                        rightJ = j;
                        rightK = k;
                        tempK = rightK + 1;
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

    public void useBothBatteries(int energyAmount) {
        int energyAmountPerBattery;
        int oneMore;
        if (energyAmount % 2 != 0) {
            energyAmount -= 1;
            energyAmountPerBattery = energyAmount / 2;
            oneMore = energyAmount / 2 + 1;
        } else {
            energyAmountPerBattery = energyAmount / 2;
            oneMore = energyAmount / 2;
        }

        useLeftBattery(oneMore);  //default extra unit used from left battery
        useRightBattery(energyAmountPerBattery);

    }

    public BatteryManagement getBatteryManagement() {
        return batteryManagement;
    }


}
