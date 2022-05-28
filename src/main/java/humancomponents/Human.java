package humancomponents;

import java.util.Random;

public abstract class Human {
    private final boolean smoker;
    private final Lung leftLung;
    private final Lung rightLung;
    private final boolean isInfected;
    private String firstName;
    private String secondName;
    private Gender gender;
    private String birthDate;
    private boolean vaccinated;
    private boolean isAlive;
    private boolean lungsAreFilled;

    public Human(boolean isInfected) {

        this.smoker = new Random().nextBoolean();
        this.isInfected = isInfected;
        leftLung = new Lung(smoker, isInfected);
        rightLung = new Lung(smoker, isInfected);
        leftLung.setCells();
        rightLung.setCells();
        isAlive = true;
        lungsAreFilled = false;
    }

    public void setHumanProperties(String firstName, String secondName, Gender gender, boolean vaccinated) {

        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
        this.vaccinated = vaccinated;
    }
    //choke defines whether the infected human chokes or not.
    public boolean choke() {

        boolean choke = false;
        double damagedCellsLeftLung = leftLung.getNumberOfDamagedCells() + leftLung.getNumberOfInfectedCells();
        double damagedCellsRightLung = rightLung.getNumberOfDamagedCells() + rightLung.getNumberOfInfectedCells();
        double numberOfCells = leftLung.getNumberOfCells();
        double percentageOfDamagedCellsLeftLung = damagedCellsLeftLung / numberOfCells * 100;
        double percentageOfDamagedCellsRightLung = damagedCellsRightLung / numberOfCells * 100;
        //The If defines the condition for choke
        if (percentageOfDamagedCellsLeftLung > 79 || percentageOfDamagedCellsRightLung > 79 || (percentageOfDamagedCellsLeftLung > 64 && percentageOfDamagedCellsRightLung > 64)) {
            choke = true;
        }

        return choke;
    }

    //breatheIn fills both Lungs
    public void breatheIn() {

        if (!lungsAreFilled) { // Lungs can only be filled, if they are empty.
            if (choke()) { // If the human chokes he is not longer alive and cannot fill Lungs anymore.
                isAlive = false;
                return;
            }
            leftLung.fillLung();
            rightLung.fillLung();
            lungsAreFilled = true;
        }
    }

    public void breatheOut() {
        if (lungsAreFilled) { //Lungs can only be emptied, if they are full.
            if (!isAlive) { // Can only breathe out when isAlive ==true
                return;
            }
            leftLung.emptyLung();
            rightLung.emptyLung();
            lungsAreFilled = false;
        }
    }

    public boolean isSmoker() {
        return smoker;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public boolean isInfected() {
        return isInfected;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Gender getGender() {
        return gender;
    }
}
