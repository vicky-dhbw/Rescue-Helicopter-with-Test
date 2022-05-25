package HumanComponents;

import java.util.Random;

public class Lung {
    private final Cell[][] cells;
    private final boolean smoker;

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
    public void setCells(){
        if(smoker){
            for(int i=0; i<cells.length/10*2; i++){
                setDamagedCells();
            }
        }
        for(int i=0; i<50; i++){
            for(int j=0; j<20; j++){
                if(cells[i][j] == null){
                    cells[i][j] = new Cell(CellType.H);
                }
            }
        }
    }
}
