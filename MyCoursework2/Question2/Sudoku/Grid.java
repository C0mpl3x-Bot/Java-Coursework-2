package Sudoku;

public class Grid {
    public Cell[][] grid = new Cell[9][9];
    public int N = 9;

    //check for duplicate in row
    // we check if a possible number is already in a row
    private boolean InRow(int row, int number) {
        for (int i = 0; i < N; i++)
            if (grid[row][i].getStoreInCell() == number)
                return true;

        return false;
    }

    //check for a duplicate in column
    //we check if a possible number is already in a column
    private boolean InColumn(int column, int number) {
        for (int i = 0; i < N; i++)
            if (grid[i][column].getStoreInCell() == number)
                return true;

        return false;
    }

    //check for a duplicate in the inner 3 by 3 grid
    //we check if a possible number is in its 3x3 box
    private boolean InSubBox(int row, int column, int number) {
        int r = row - row % 3;
        int c = column - column % 3;

        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (grid[i][j].getStoreInCell() == number)
                    return true;

        return false;
    }

    //check if the number is in neither row column or 3x3 grid so the number you want to put in is valid
    //combined method to check if a number possible to a row,column position is ok
    public boolean isValid(int row, int column, int number) {
        return !InRow(row, number)  &&  !InColumn(column, number)  &&  !InSubBox(row, column, number);
    }


    //Overrides toString method so that the 2d array / sudoku grid would be printed out.
    @Override
    public String toString() {
        String PrintGrid = "";
        /* for loop, loops over the size of the 2d array and gets each individual number in each cell by iterating through
        the rows and columns and getting the number stored in that cell and adding it to the string PrintGrid and then it returns Print Grid
        which should print the 2d array in the text file. */
        for (int row = 0; row <N; row++) {
            for (int column = 0; column < N; column++) {
                 PrintGrid += " " + grid[row][column].getStoreInCell();
            }

           PrintGrid += "\n";
        }
        //Print the String PrintGrid which is the 2d array
        return PrintGrid;

    }
}
