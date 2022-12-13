package Sudoku;

public class Solver {
    private boolean solve(Grid grid){
        //iterate over the rows and columns of the grid
        for(int row = 0; row< grid.N ; row++){
            for(int column = 0; column < grid.N; column++){
                //check if the cell you are looking at is an editable cell if it is it should be equal to true
                if(grid.grid[row][column].isEditable() == true){
                    /*loops over each possible number and check in the if statement if that number is valid
                    if it is set that editable cell to be that number and return true else it would return false as
                    you cant set that number to that cell */
                     for(int number = 1; number<= grid.N; number++){
                         if(grid.isValid(row, column, number)){
                             grid.grid[row][column].setStoreInCell(number);
                         }
                     }
                    //return false if no number can be put into that cell
                    return false;
                }
            }
        }
        //return true if grid is solved
        return true;
    }
}
