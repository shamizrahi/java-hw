/**
 * Sudoku2.java - Sharon's Version
 * 
 * Implementation of a class that represents a Sudoku puzzle and solves
 * it using recursive backtracking.
 *
 * Computer Science 112, Boston University
 *
 * your name: Sharon Mizrahi
 * Partner: Roberto Rodas-Herndon
 *
 */

import java.io.*;   // allows us to read from a file
import java.util.*;

public class Sudoku2 {    

    private int[][] grid;

    private boolean[][] valIsFixed;
    
    private boolean[][][] subgridHasVal;

    private boolean[][] row_has_val; // check row vals

    private boolean[][] col_has_val; // check col vals

    
    /* 
     * Constructs a new Puzzle object, which initially
     * has all empty cells.
     */
    public Sudoku2() {
        this.grid = new int[9][9];
        this.valIsFixed = new boolean[9][9];

        this.subgridHasVal = new boolean[3][3][10];        

        this.row_has_val = new boolean[9][10]; //9 spaces in rows and up to 10 is the possible value
        this.col_has_val = new boolean[9][10]; //9 spaces in cols and up to 10 is the possible value

    }
    

    public void placeVal(int val, int row, int col) {
        this.grid[row][col] = val;
        this.subgridHasVal[row/3][col/3][val] = true;
        this.row_has_val[row][val] = true;
        this.col_has_val[col][val] = true;
        
    }
        

    public void removeVal(int val, int row, int col) {
        this.grid[row][col] = 0;
        this.subgridHasVal[row/3][col/3][val] = false;
        this.row_has_val[row][val] = false;
        this.col_has_val[col][val] = false;

        
    }  
        

    public void readConfig(Scanner input) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int val = input.nextInt();
                this.placeVal(val, r, c);
                if (val != 0) {
                    this.valIsFixed[r][c] = true;
                }
            }
            input.nextLine();
        }
    }
                
     
    public void printGrid() {
        for (int r = 0; r < 9; r++) {
            this.printRowSeparator();
            for (int c = 0; c < 9; c++) {
                System.out.print("|");
                if (this.grid[r][c] == 0) {
                    System.out.print("   ");
                } else {
                    System.out.print(" " + this.grid[r][c] + " ");
                }
            }
            System.out.println("|");
        }
        this.printRowSeparator();
    }
        
    // A private helper method used by display() 
    // to print a line separating two rows of the puzzle.
    private static void printRowSeparator() {
        for (int i = 0; i < 9; i++) {
            System.out.print("----");
        }
        System.out.println("-");
    }
    
    /*** ADD ANY ADDITIONAL METHODS HERE. ***/

         

    private boolean solveRB(int n) {

        int row = n / 9;
        int col = n % 9;
                
        if( n == 81 ){
            return true;
        }else if (this.valIsFixed[row][col] == true) {
            return solveRB(n + 1);

        }else{

          for(int i = 1; i < 10; i++){
                    if(row_has_val[row][i] == false && col_has_val[col][i] == false && subgridHasVal[row/3][col/3][i] == false){
                        placeVal(i, row, col);

                        if(solveRB( n + 1)){
                            return true;
                        }else{

                        removeVal(i, row, col);

                    }

                }

            }
        }
        
        return false;
    
    }
    
    /*
     * public "wrapper" method for solveRB().
     * Makes the initial call to solveRB, and returns whatever it returns.
     */
    public boolean solve() { 
        boolean foundSol = this.solveRB(0);
        return foundSol;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Sudoku puzzle = new Sudoku();
        
        System.out.print("Enter the name of the puzzle file: ");
        String filename = scan.nextLine();
        
        try {
            Scanner input = new Scanner(new File(filename));
            puzzle.readConfig(input);
        } catch (IOException e) {
            System.out.println("error accessing file " + filename);
            System.out.println(e);
            System.exit(1);
        }
        
        System.out.println();
        System.out.println("Here is the initial puzzle: ");
        puzzle.printGrid();
        System.out.println();
        
        if (puzzle.solve()) {
            System.out.println("Here is the solution: ");
        } else {
            System.out.println("No solution could be found.");
            System.out.println("Here is the current state of the puzzle:");
        }
        puzzle.printGrid();  
    }    
}
