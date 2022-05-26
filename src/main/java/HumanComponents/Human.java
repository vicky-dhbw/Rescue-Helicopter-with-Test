package HumanComponents;

public class Human {
    private String firstName;
    private String secondName;
    private Gender gender;
    private String birthDate;
    private final boolean smoker;
    private boolean vaccinated;
    private final Lung leftLung;
    private final Lung rightLung;
    private boolean isAlive;
    private boolean lungsAreFilled;
    private boolean isInfected;

    public Human(boolean isInfected, boolean smoker) {
        this.birthDate = birthDate;
        this.smoker = smoker;
        this.isInfected = isInfected;
        leftLung = new Lung(smoker, isInfected);
        rightLung = new Lung(smoker, isInfected);
        leftLung.setCells();
        rightLung.setCells();
        isAlive = true;
        lungsAreFilled = false;
    }
    public void setHumanProperties(String firstName, String secondName, Gender gender, boolean vaccinated){
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.vaccinated = vaccinated;
    }
    public boolean choke(){
        boolean choke = false;
        double damagedCellsLeftLung = leftLung.getNumberOfDamagedCells()+ leftLung.getNumberOfInfectedCells();
        double damagedCellsRightLung = rightLung.getNumberOfDamagedCells()+ rightLung.getNumberOfInfectedCells();
        double numberOfCells = leftLung.getNumberOfCells();
        double percentageOfDamagedCellsLeftLung = damagedCellsLeftLung/numberOfCells*100;
        double percentageOfDamagedCellsRightLung = damagedCellsRightLung/numberOfCells*100;
        if(percentageOfDamagedCellsLeftLung>79 || percentageOfDamagedCellsRightLung>79 || (percentageOfDamagedCellsLeftLung>64 && percentageOfDamagedCellsRightLung>64)){
            choke = true;
        }
        return choke;
    }
    public void breatheIn(){
        if(!lungsAreFilled){
            if(choke()){
                isAlive = false;
                return;
            }
            leftLung.fillLung();
            rightLung.fillLung();
            lungsAreFilled = true;
        }
    }
    public void breatheOut(){
        if(lungsAreFilled){
            if(isAlive==false){
                return;
            }
            leftLung.emptyLung();
            rightLung.emptyLung();
            lungsAreFilled = false;
        }
    }
}
