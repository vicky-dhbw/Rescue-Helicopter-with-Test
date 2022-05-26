package HumanComponents;

public class Human {
    private final String firstName;
    private final String secondName;
    private final Gender gender;
    private String birthDate;
    private final boolean smoker;
    private final boolean vaccinated;
    private final Lung leftLung;
    private final Lung rightLung;
    private boolean isAlive;
    private boolean lungsAreFilled;

    public Human(String firstName, String secondName, Gender gender, String birthDate, boolean smoker, boolean vaccinated) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.smoker = smoker;
        this.vaccinated = vaccinated;
        leftLung = new Lung(smoker);
        rightLung = new Lung(smoker);
        leftLung.setCells();
        rightLung.setCells();
        isAlive = true;
        lungsAreFilled = false;
    }
    private boolean choke(){
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
