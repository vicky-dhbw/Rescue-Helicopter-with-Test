package humancomponents;

public class InfectedCell extends Cell {

    private final Viron[] virons;

    public InfectedCell(CellType cellType) {
        super(cellType);
        virons = new Viron[25];
        for (int i = 0; i < virons.length; i++) {
            virons[i] = new Viron();
        }
    }
}
