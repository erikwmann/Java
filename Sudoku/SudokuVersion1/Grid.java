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
    private int[][] fillGrid(int size){
        int num = random.nextInt(size)+1;//1-size
        
        for(int i = 0; i<grid.length;i++){ 
            for(int j = 0; j<grid.length;j++){
                num = random.nextInt(size)+1;//1-size
                grid[i][j] = num;
            }
        }
        
        return null;
    }
}
