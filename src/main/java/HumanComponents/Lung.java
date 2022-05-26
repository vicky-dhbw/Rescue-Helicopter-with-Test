package HumanComponents;

import java.util.Random;

public class Lung {
    private final boolean isInfected;
    private final Cell[][] cells;
    private final boolean smoker;
    private double numberOfDamagedCells;
    private double numberOfCells;
    private int numberOfInfectedCells;
    private SeverityCovid severityCovid;
    private int probability = 0;
    public Lung(boolean smoker, boolean isInfected){
        this.isInfected = isInfected;
        this.smoker = smoker;
        cells = new Cell[50][20];
        numberOfCells = 50*20;
        numberOfInfectedCells = 0;
    }

    public Cell[][] getCells() {
        return cells;
    }
    public double getNumberOfCells(){
        return numberOfCells;
    }
    public double getNumberOfDamagedCells(){
        return numberOfDamagedCells;
    }
    public int getNumberOfInfectedCells(){
        return numberOfInfectedCells;
    }
    public void setDamagedCells(){
        int positioni = new Random().nextInt(50);
        int positionj = new Random().nextInt(20);
        if(cells[positioni][positionj] == null){
            cells[positioni][positionj] = new Cell(CellType.D);
        }
        else{
            setDamagedCells();
        }
    }
    public void setCells(){
        if(smoker){
            numberOfDamagedCells = numberOfCells/5; //20 percent are damaged if smoker is true
            for(int i=0; i<numberOfDamagedCells; i++){
                setDamagedCells();
            }
        }
        if(isInfected){
            setSeverityCovid();
            probability = setProbabilityForInfection();
        }
        for(int i=0; i<50; i++){
            for(int j=0; j<20; j++){
                if(cells[i][j] == null){
                    cells[i][j] = new Cell(CellType.H);
                    if(isInfected && new Random().nextInt(100)<probability && (cells[i][j].getCellType()==CellType.H)){
                        cells[i][j] = new InfectedCell(CellType.I);
                    }
                }
            }
        }
        setNUmberOfInfectedCells();
    }
    public void setSeverityCovid(){
        if(numberOfInfectedCells/numberOfCells*100<4){
            severityCovid = SeverityCovid.S0;
        }
        else if(numberOfInfectedCells/numberOfCells*100<6){
            severityCovid = SeverityCovid.S1;
        }
        else if(numberOfInfectedCells/numberOfCells*100<11){
            severityCovid = SeverityCovid.S2;
        }
        else{
            severityCovid = SeverityCovid.S3;
        }
    }
    public void emptyLung(){
        for(int i=0; i<50; i++){
            for(int j=0; j<20; j++){
                    cells[i][j].emptyCarbonDioxide();
            }
        }
    }
    public void fillLung(){
        if(isInfected){
            setSeverityCovid();
            probability = setProbabilityForInfection();
        }
        for(int i=0; i<50; i++){
            for(int j=0; j<20; j++){
                cells[i][j].setOxygenCarbonDioxide('o');
                if(isInfected && new Random().nextInt(100)<probability && (cells[i][j].getCellType()==CellType.H)){
                    cells[i][j] = new InfectedCell(CellType.I);
                }
            }
        }
        setNUmberOfInfectedCells();
    }
    public void setNUmberOfInfectedCells(){
        numberOfInfectedCells=0;
        for(int i=0; i<50; i++){
            for(int j=0; j<20; j++){
                if(cells[i][j].getCellType()==CellType.I){
                    numberOfInfectedCells+=1;
                }
            }
        }
    }
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
