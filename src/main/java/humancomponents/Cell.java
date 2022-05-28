package humancomponents;

public class Cell {
    private CellType cellType;
    private char oxygenCarbonDioxide;

    public Cell(CellType cellType) {
        this.cellType = cellType;
        oxygenCarbonDioxide = 'n';//Before breathing oxygenCarbonDioxide is n (null) in the Cell.
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    //setOxygenCarbonDioxide gets 'o' from the method fillLung in the class Lung.
    public void setOxygenCarbonDioxide(char oxygen) {
        if (cellType == CellType.H) { /*only a healthy Cell can breathe.*/
            oxygenCarbonDioxide = oxygen;
            oxygenCarbonDioxide = 'c'; //Automatically the Oxygen is changed into CarbonDioxide ('c')
            //and stored in the cell after breathIn --> fillLung
        }
    }

    public void emptyCarbonDioxide() {
        oxygenCarbonDioxide = 'n'; // When 'c' (CarbonDioxide is breathedOut oxygenCarbonDioxide is null ('n').
    }
}
