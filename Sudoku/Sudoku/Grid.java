/*
 * A grid is an 2D array
 */

public class Grid
{
    private int grid [][];
    int gridTest[][] =  {
                                {1, 2, 3, 4, 5},
                                {1, 2, 3, 4, 5},
                                {1, 2, 3, 4, 5},
                                {1, 2, 3, 4, 5},
                                {1, 2, 3, 4, 5},
                            };
    
    public Grid(int size){
        //grid = new int [size][size];
        grid = gridTest;
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
}
