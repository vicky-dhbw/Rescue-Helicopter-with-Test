package HumanComponents;

import java.util.Random;

public class Lung {
    private final Cell[][] cells;
    private final boolean smoker;
    private int numberOfDamagedCells;
    private SeverityCovid severityCovid;

    Random random = new Random();
    public Lung(boolean smoker){
        this.smoker = smoker;
        cells = new Cell[50][20];
    }
    public void setDamagedCells(){
        int positioni = random.nextInt()%50;
        int positionj = random.nextInt()%20;
        if(cells[positioni][positionj] == null){
            cells[positioni][positionj] = new Cell(CellType.D);
        }
        else{
            setDamagedCells();
        }
    }
    public void setInfectedCells(){
        int positioni = random.nextInt()%50;
        int positionj = random.nextInt()%20;
        if(cells[positioni][positionj] == null){
            cells[positioni][positionj] = new InfectedCell(CellType.I);
        }
        else{
            setInfectedCells();
        }
    }
    public void setCells(){
        if(smoker){
            numberOfDamagedCells = cells.length/10*2;
            for(int i=0; i<cells.length/10*2; i++){
                setDamagedCells();
            }
        }
        setSeverityCovid();
        for(int i=0; i<50; i++){
            for(int j=0; j<20; j++){
                if(cells[i][j] == null){
                    cells[i][j] = new Cell(CellType.H);
                }
            }
        }
    }
    public void setSeverityCovid(){
        if(numberOfDamagedCells/cells.length*100<4){
            severityCovid = SeverityCovid.S0;
        }
        else if(numberOfDamagedCells/cells.length*100<6){
            severityCovid = SeverityCovid.S1;
        }
        else if(numberOfDamagedCells/cells.length*100<11){
            severityCovid = SeverityCovid.S2;
        }
        else{
            severityCovid = SeverityCovid.S3;
        }
    }
    public void emptyLung(){
        for(int i=0; i<50; i++){
            for(int j=0; j<20; j++){
                if(cells[i][j] == null){
                    cells[i][j].emptyCarbonDioxide();
                }
            }
        }
    }
    public void fillLung(){
        int probability = setProbabilityForInfection();
        for(int i=0; i<50; i++){
            for(int j=0; j<20; j++){
                cells[i][j].setOxygenCarbonDioxide('o');
                if(random.nextInt()%100<probability){
                    cells[i][j] = new InfectedCell(CellType.I);
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
