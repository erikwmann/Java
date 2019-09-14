public class Driver{
    public static void main(String[]args){
        int gridSize = 9;
        System.out.println("Let's play Sudoku!");
        
        Grid grid = new Grid(gridSize);
        grid.printGrid();
    }
}