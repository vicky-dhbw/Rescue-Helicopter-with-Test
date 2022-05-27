package TechnicsComponents;

public class Control {

    private BatteryManagement batteryManagement = BatteryManagement.B;

    Energy energy;

    public static int leftI;
    public static int leftJ;
    public static int leftK;
    public static int rightI;
    public static int rightJ;
    public static int rightK;
    public static int countAmount;

    public static int tempK;
    public Control(Energy energy){
        this.energy=energy;
    }
    public void changeBatteryUsage(BatteryManagement batteryManagement) {
        this.batteryManagement = batteryManagement;
        System.out.println("Battery usage level set to: "+batteryManagement );
    }
    public void useBatteries(int RPM) {
        int energyAmount= RPM*10;

        switch (batteryManagement) {
            case B -> useBothBatteries(energyAmount);
            case L -> useLeftBattery(energyAmount);
            case R -> useRightBattery(energyAmount);
        }
    }
    public void useLeftBattery(int energyAmount) {
        countAmount=0;
        tempK=0;
        for(int i=leftI; i<250; i++){
            for(int j=leftJ; j<100; j++){
                for(int k=leftK; k<50; k++){
                    if(countAmount==energyAmount){
                        tempK=leftK+1;
                        break;
                    }
                    leftK=k;
                    energy.getLeftBattery().getCells()[i][j][k].dischargeCell();
                    countAmount++;
                }
                if(countAmount==energyAmount){
                    break;
                }
                leftJ=j;

            }
            if(countAmount==energyAmount){
                break;
            }
            leftI=i;
        }
        System.out.println("left battery consumed till Cell L: "+leftI+ " B: "+ leftJ+ " H: "+leftK);
    }

    public void useRightBattery(int energyAmount) {
        countAmount=0;
        tempK=0;
        for(int i=rightI; i<250; i++){
            for(int j=rightJ; j<100; j++){
                for(int k=rightK; k<50; k++){
                    if(countAmount==energyAmount){
                        tempK=rightK+1;
                        break;
                    }

                    energy.getRightBattery().getCells()[i][j][k].dischargeCell();
                    rightK=k;
                    countAmount++;
                }
                rightJ=j;
                if(countAmount==energyAmount){
                    break;
                }
            }
            rightI=i;
            if(countAmount==energyAmount){
                break;
            }
        }
        System.out.println("right battery consumed till Cell L: "+rightI+ " B: "+ rightJ+ " H: "+rightK);
        rightK=tempK;

    }

    public void useBothBatteries(int energyAmount) {
        int energyAmountPerBattery;
        int oneMore;
        if(energyAmount%2!=0){
            energyAmount-=1;
            energyAmountPerBattery=energyAmount/2;
            oneMore=energyAmount/2+1;
        }
        else {
            energyAmountPerBattery=energyAmount/2;
            oneMore=energyAmount/2;
        }

        useLeftBattery(oneMore);  //default extra unit used from left battery
        useRightBattery(energyAmountPerBattery);

    }

    public BatteryManagement getBatteryManagement(){
        return batteryManagement;
    }

    public int[] getLeftIJK(){

        int[] IJK=new int[3];
        IJK[0]=leftI;
        IJK[1]=leftJ;
        IJK[2]=leftK;

        return IJK;
    }

}
