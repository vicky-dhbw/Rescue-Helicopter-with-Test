package HumanComponents;

public class Cell {
    private CellType cellType;
    private char oxygenCarbonDioxide;
    public Cell(CellType cellType){
        this.cellType = cellType;
        oxygenCarbonDioxide = 'n';//n=null
    }
    public CellType getCellType(){
        return cellType;
    }
    public void setOxygenCarbonDioxide(char oxygen){
        if(cellType == CellType.H){
            oxygenCarbonDioxide = oxygen;
            oxygenCarbonDioxide = 'c';
        }
    }
    public void emptyCarbonDioxide(){
        if(cellType == CellType.H){
            oxygenCarbonDioxide = 'n';
        }
    }

}
