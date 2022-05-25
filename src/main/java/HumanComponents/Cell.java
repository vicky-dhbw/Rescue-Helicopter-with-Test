package HumanComponents;

public class Cell {
    private CellType cellType;
    private char oxygenCarbonDioxide;
    public Cell(CellType cellType){
        this.cellType = cellType;
        oxygenCarbonDioxide = 'n';//n=null
    }
    public void setOxygenCarbonDioxide(char oxygen){
        if(cellType == CellType.H){
            oxygenCarbonDioxide = 'o';
            changeOxygenCarbonDioxide();
        }
    }
    public void changeOxygenCarbonDioxide(){
        oxygenCarbonDioxide = 'c';
    }
    public char getOxygenCarbonDioxide(){
        char carbonDioxide = oxygenCarbonDioxide;
        oxygenCarbonDioxide = 'n';
        return carbonDioxide;
    }
}
