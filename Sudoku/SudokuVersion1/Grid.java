/*
 * A grid is an 2D array
 */

import java.util.ArrayList;
import java.util.Collections;
public class Grid
{
    private int grid [][];
    ArrayList numList;
    
    public Grid(int size){
        grid = new int [size][size];
        
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
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int temp;
        int timeout =0;
        for(int i = 0; i<grid.length;i++){ 
            for(int k = 1; k<=grid.length;k++){
                nums.add(k);
            }
            Collections.shuffle(nums);
            for(int j = 0; j<grid.length;j++){            
                temp = nums.get(0);
                grid[i][j] = temp; //get first element
                nums.remove(0);
                //If the check come back false reset the squre and decrement j
                if(!(checkRow(i) && checkCol(j) && checkSquare(i, j))){
                    grid[i][j] = 0; //reset the square
                    nums.add(temp); //append the failed number to the end of the array
                    j--;
                }
                
                //if the row cannot be filled due to invalid number positions
                if(timeout > grid.length + 1){
                    rowReset(i); //reset the row
                    i--; //do the row over
                    j+=grid.length; //stop filling the row
                }
                //printGrid();
                timeout++;
            }
            nums.clear();//removes all elements from the arraylist
            timeout = 0; //reset the timeout
        }
    }
    
    //Reset a row on the grid
    private void rowReset(int row){
        for(int i =0; i<grid.length;i++){
            grid[row][i] = 0;
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
