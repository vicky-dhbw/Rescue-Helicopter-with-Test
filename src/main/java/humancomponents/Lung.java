package humancomponents;

import java.util.Random;

public class Lung {
    private final boolean isInfected;
    private final Cell[][] cells;
    private final boolean smoker;
    private double numberOfDamagedCells;
    private final double numberOfCells;
    private int numberOfInfectedCells;
    private SeverityCovid severityCovid;
    private int probability = 0;

    public Lung(boolean smoker, boolean isInfected) {
        this.isInfected = isInfected;
        this.smoker = smoker;
        cells = new Cell[50][20];
        numberOfCells = 50 * 20;
        numberOfInfectedCells = 0;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public double getNumberOfCells() {
        return numberOfCells;
    }

    public double getNumberOfDamagedCells() {
        return numberOfDamagedCells;
    }

    public int getNumberOfInfectedCells() {
        return numberOfInfectedCells;
    }

    //setDamagedCells searches ramdomly a free place in cells to put a damaged Cell on it.
    public void setDamagedCells() {
        int positioni = new Random().nextInt(50);
        int positionj = new Random().nextInt(20);
        if (cells[positioni][positionj] == null) {
            cells[positioni][positionj] = new Cell(CellType.D);
        } else {
            setDamagedCells();
        }
    }

    //setCells is used, when creating a new human in the constructor of human.
    public void setCells() {
        if (smoker) { //If smoker 20 percent of the Cells are damaged from begin on.
            numberOfDamagedCells = numberOfCells / 5; //20 percent are damaged if smoker is true
            for (int i = 0; i < numberOfDamagedCells; i++) {
                setDamagedCells();
            }
        }
        if (isInfected) { //Infected humans(patients) net to setSeverityCovid
            //and also probability for infection of healthy cells.
            setSeverityCovid();
            probability = setProbabilityForInfection();
        }
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 20; j++) {
                if (cells[i][j] == null) { //damaged Cells have been set, so only free places can contain healthy Cells.
                    //Probability for infection of the other cells is implemented here.
                    if (isInfected && new Random().nextInt(100) < probability && (cells[i][j].getCellType() == CellType.H)) {
                        cells[i][j] = new InfectedCell(CellType.I);
                    }
                    //the left free places can store a healthy Cell
                    else{
                        cells[i][j] = new Cell(CellType.H);
                    }
                }
            }
        }
        setNumberOfInfectedCells(); //actualisation of numberOfInfectedCells.
    }

    //severityCovid depends on the percentage of infectedCells of the Lung.
    public void setSeverityCovid() {
        if (numberOfInfectedCells / numberOfCells * 100 < 4) {
            severityCovid = SeverityCovid.S0;
        } else if (numberOfInfectedCells / numberOfCells * 100 < 6) {
            severityCovid = SeverityCovid.S1;
        } else if (numberOfInfectedCells / numberOfCells * 100 < 11) {
            severityCovid = SeverityCovid.S2;
        } else {
            severityCovid = SeverityCovid.S3;
        }
    }

    //emtyLung is called by breatheOut in Human.
    public void emptyLung() {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 20; j++) {
                cells[i][j].emptyCarbonDioxide();
            }
        }
    }

    //fillLung is called by breatheIn in Human.
    public void fillLung() {
        if (isInfected) {
            setSeverityCovid();
            probability = setProbabilityForInfection();
        }
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 20; j++) {
                cells[i][j].setOxygenCarbonDioxide('o');
                //every Cell can be infected dependend on the probability for infection and the boolean isInfected
                if (isInfected && new Random().nextInt(100) < probability && (cells[i][j].getCellType() == CellType.H)) {
                    cells[i][j].setCellType();
                }
            }
        }
        setNumberOfInfectedCells();
    }

    //setNumberOfInfectedCells checks how many Cells are infected
    public void setNumberOfInfectedCells() {
        numberOfInfectedCells = 0;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 20; j++) {
                if (cells[i][j].getCellType() == CellType.I) {
                    numberOfInfectedCells += 1;
                }
            }
        }
    }

    //probability depends on severityCovid and the boolean smoker.
    public int setProbabilityForInfection() {
        switch (severityCovid) {
            case S0:
                if (!smoker) {
                    return 2;
                } else {
                    return 4;
                }
            case S1:
                if (!smoker) {
                    return 3;
                } else {
                    return 6;
                }
            case S2:
                if (!smoker) {
                    return 6;
                } else {
                    return 10;
                }
            case S3:
                if (!smoker) {
                    return 10;
                } else {
                    return 15;
                }
            default:
                return 0;
        }
    }
}
