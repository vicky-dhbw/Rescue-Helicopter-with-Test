package TechnicsComponents;

public class Battery {

    private final Cell[][][] cells;
    private int countI;
    private int countJ;
    private int countK;
    public Battery() {
        cells= new Cell[250][100][50];
        for(int i=0; i<250; i++) {
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 50; k++) {
                    cells[i][j][k]=new Cell();
                }
            }
        }
    }

    public Cell[][][] getCells(){
        return cells;
    }
}
