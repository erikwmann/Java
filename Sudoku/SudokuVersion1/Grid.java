/*
 * A grid is an 2D array
 */

import java.util.Random;
public class Grid
{
    private int grid [][];
    Random random;
    
    public Grid(int size){
        grid = new int [size][size];
        
        random = new Random();
        fillGrid(size);
    }
    
    //Prints the grid row by row
    public void printGrid(){
        System.out.println();
        for(int i = 0; i<grid.length;i++){ 
            for(int j = 0; j<grid.length;j++){
                System.out.print("  " + grid[i][j] + "  ");
            }
            System.out.println("\n");
        }
    }
    
    //Fills the grid with random numbers
    private void fillGrid(int size){
        int num = random.nextInt(size)+1;//1 to size
        
        for(int i = 0; i<grid.length;i++){ 
            for(int j = 0; j<grid.length;j++){   
                num = random.nextInt(size)+1;//1 to size
                grid[i][j] = num;
                
                //If the check come back false reset the squre and decrement j
                if(!(checkRow(i) && checkCol(j) && checkSquare(i, j))){
                    grid[i][j] = 0;
                    j--;
                }
            }
        }
    }
    
    //Check a row for two of the same number
    private boolean checkRow(int row){
        int check [] = new int [grid.length+1];//Array 0 to n
        
        //Goes through each row and adds 1 to the index of each number.
        for(int i= 0; i<grid.length; i++){
            check[grid[row][i]]+=1; 
        }
        
        //check to see if more than one number is the same
        //i starts at one because we don't care about 0s
        for(int i= 1; i<check.length; i++){
            if(check[i] > 1){
                return false;
            }
        }
        return true;
    }
    
    //Check a column for two of the same number
    private boolean checkCol(int col){
        int check [] = new int [grid.length+1];//Array 0 to n
        
        //Goes through each column and adds 1 to the index of each number.
        for(int i= 0; i<grid.length; i++){
            check[grid[i][col]]+=1; 
        }
        
        //check to see if more than one number is the same
        //i starts at one because we don't care about 0s
        for(int i= 1; i<check.length; i++){
            if(check[i] > 1){
                return false;
            }
        }
        return true;
    }
    
    //Check squares
    private boolean checkSquare(int row, int column){
        
        return true;
    }
}
