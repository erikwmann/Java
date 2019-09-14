/*
 * A Grid is an 2D array filled with numbers that are unique by row, column, and square.
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
                nums.remove(0); //remove the first element
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
        int check [] = new int [grid.length+1];//array 0 to n
        
        //goes through each row and adds 1 to the index of each number.
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
        int check [] = new int [grid.length+1];//array 0 to n
        
        //goes through each column and adds 1 to the index of each number.
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
    
    //Check squares in a 9x9 Grid
    private boolean checkSquare(int row, int col){
        int check [] = new int [grid.length+1];//array 0 to n
        int rowEnd = 0;
        int colEnd = 0;
        
        //numbers are reduced beacuse the array starts at 0
        //rows
        //between 1 and 3
        if(row <= 2){
            row = 0;
            rowEnd = 2;
        }
        //between 3 and 6
        else if(row > 2 && row <= 5){
            row = 3;
            rowEnd = 5;
        }
        //between 7 and 9
        else{
            row = 6;
            rowEnd = 8;
        }
        
        //cols
        //between 1 and 3
        if(col <= 2){
            col = 0;
            colEnd = 2;
        }
        //between 3 and 6
        else if(col > 2 && col <= 5){
            col = 3;
            colEnd = 5;
        }
        //between 7 and 9
        else{
            col = 6;
            colEnd = 8;
        }
        
        //go through the square and adds 1 to the index of each number.
        for(int i = row; i <= rowEnd;i++){
            for(int j = col; j <= colEnd;j++){
                check[grid[i][j]]+=1; 
            }
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
}
