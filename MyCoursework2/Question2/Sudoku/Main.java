package Sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    //calls new instance of the grid class.
    public static Grid grid = new Grid();

    public static void main(String[] args) {
        //gets the file for extensionPuzzle and populates the grid array with the values from it.
        //calls the File you want to use
        File gridFile = new File("extensionPuzzle.txt");
        //program statements to monitor for exceptions are placed in the try block
        try {
            int row = 0;
            Scanner in = new Scanner(gridFile);
            /*while there is another line in the text file if the number it is looking at is equal to 0
            it would make it so it is editable and it would set that value to it
            if it is not equal then it would not be editable so it would be false and the vale it was looking at would
            be set so it is not editable */
            while (in.hasNextLine()) {
                String[] nextLine = in.nextLine().split(",");
                for(int i = 0;i< nextLine.length;i++){
                    int unknown = Integer.parseInt(nextLine[i]);
                    Cell c;
                    if(unknown == 0){
                        c = new Cell(true,unknown);
                    }
                    else{
                        c = new Cell(false,unknown);
                    }
                    //it would add that number to the 2d grid using the row and column it was looking at on the text file
                    grid.grid[row][i] = c;
                }
                //after each line the you would increment the row to use the next row in the text file
                row++;
            }
        }
        //block of code to be run if an exception is raised in the try block
        catch (FileNotFoundException e){
            System.out.println("can't find the file");
        }
        Solver solve = new Solver();

        //calls the overridden toString in grid and print it out to the console
        System.out.println(grid.toString());
    }

}
