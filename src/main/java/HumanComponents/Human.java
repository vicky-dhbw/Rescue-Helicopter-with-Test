package HumanComponents;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Human {
    private final String firstName;
    private final String secondName;
    private final Gender gender;

    private final Date birthDate;
    private final boolean smoker;
    private final boolean vaccinated;
    private final Lung leftLung;
    private final Lung rightLung;

    private boolean isAlive;

    public Human(String firstName, String secondName, Gender gender, Date birthDate, boolean smoker, boolean vaccinated){
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
    }
    public boolean choke(){
        boolean choke = false;
        int damagedCellsLeftLung = 0;
        int damagedCellsRightLung = 0;
        for(int i=0; i<50; i++){
            for(int j=0; j<20; j++){
                if(leftLung.getCells()[i][j].getCellType()==CellType.D || leftLung.getCells()[i][j].getCellType()==CellType.I){
                    damagedCellsLeftLung+=1;
                }
                if(rightLung.getCells()[i][j].getCellType()==CellType.D || rightLung.getCells()[i][j].getCellType()==CellType.I){
                    damagedCellsRightLung+=1;
                }
            }
        }
        int percentageOfDamagedCellsLeftLung = damagedCellsLeftLung/leftLung.getCells().length*100;
        int percentageOfDamagedCellsRightLung = damagedCellsRightLung/rightLung.getCells().length*100;
        if(percentageOfDamagedCellsLeftLung>79 || percentageOfDamagedCellsRightLung>79 || (percentageOfDamagedCellsLeftLung>64 && percentageOfDamagedCellsRightLung>64)){
            choke = true;
        }
        return choke;
    }
    public void breatheIn(){
        if(choke()){
            isAlive = false;
            return;
        }
        leftLung.fillLung();
        rightLung.fillLung();
    }
    public void breatheOut(){
        if(isAlive==false){
            return;
        }
        leftLung.emptyLung();
        rightLung.emptyLung();
    }
}
