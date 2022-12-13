package Sudoku;

public class Cell {
    //private instances
    private boolean isEditable;
    private int StoreInCell;

    //getters and setters
    public boolean isEditable(){
        return isEditable;
    }

    public void setEditable(boolean editable){
        isEditable = editable;
    }

    public int getStoreInCell(){
        return StoreInCell;
    }

    public void setStoreInCell(int storeInCell){
        StoreInCell = storeInCell;
    }

    public void setStoreInCell(int storeInCell, boolean isEditable){
        StoreInCell = storeInCell;
        this.isEditable = isEditable;
    }

    //constructor for Cell
    public Cell(boolean isEditable, int storeInCell){
        this.isEditable = isEditable;
        StoreInCell = storeInCell;
    }
}
