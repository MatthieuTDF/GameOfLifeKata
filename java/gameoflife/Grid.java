package gameoflife;

import java.util.Random;

public class Grid {
    private Cell[][] cells;
    private int sizeGrid;
    private Random rd;

    public Grid(int sizeGrid) {
        this.rd = new Random();
        this.sizeGrid = sizeGrid;
        generateRandomInitialState();
    }

    Grid(int sizeGrid, Cell[][] cells) {
        this.sizeGrid = sizeGrid;
        this.cells = cells;
    }

    private void generateRandomInitialState() {
        this.cells = new Cell[sizeGrid][sizeGrid];              // initialize cells array
        for (int i=0; i<sizeGrid; i++) {
            for (int j=0; j<sizeGrid; j++) {
                this.cells[i][j] = new Cell(rd.nextBoolean());  // fills cells with random bools
            }
        }
    }

    public int getnbAliveNeighbours(int i, int j) { 
        int result =0;
        for (int k=i-1; k<i+2; k++) {
            for (int l=j-1; l<j+2; l++) {
                if (!(k==i && l==j)) {  // avoid counting current cell
                    if (k>=0 && l>=0 && k<this.sizeGrid && l<this.sizeGrid) {   // avoid out of range indexes
                        if (this.cells[k][l].isAlive()) {
                            result++;   // if target cell is alive, increment the number of alive neighbours
                        }
                    }
                }
            }
        }
        return result;
    }

    public void generateNextState() {
        int[][] nbAliveNeighbours = new int[this.sizeGrid][this.sizeGrid];  // initialze an array of the same size as cells
        for (int i=0; i<sizeGrid; i++) {
            for (int j=0; j<sizeGrid; j++) {
                nbAliveNeighbours[i][j] = getnbAliveNeighbours(i, j); // nbAliveNeighbours[i][j] = number of alive neighbours of cell
            }
        }
        for (int i=0; i<sizeGrid; i++) {
            for (int j=0; j<sizeGrid; j++) {
                this.cells[i][j].setIsAlive(Cell.processState(this.cells[i][j].isAlive(), nbAliveNeighbours[i][j])); // processes cells
            }
        }
    }

    public String toString() {
        String result = ""; // initialize our return with an empty string to concat with/to
        for (int i=0; i<this.sizeGrid; i++) {
            for (int j=0; j<this.sizeGrid; j++) {
                result = result.concat(this.cells[i][j].toString());    // concat current cell's value
                if (j!=this.sizeGrid-1)
                    result = result.concat(" ");                        // concat additional space UNLESS we're at the last cell of the row...
            }
            if (i != this.sizeGrid-1)
                result = result.concat("\n");                           // unless we're at the last row, concat a carriage return
        }
        return result;
    }
}
