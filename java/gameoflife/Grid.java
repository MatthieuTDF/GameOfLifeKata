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
        this.cells = new Cell[sizeGrid][sizeGrid];
        for (int i=0; i<sizeGrid; i++) {
            for (int j=0; j<sizeGrid; j++) {
                this.cells[i][j] = new Cell(rd.nextBoolean());
            }
        }
    }

    public int getnbAliveNeighbours(int i, int j) {
        int result =0;
        for (int k=i-1; k<i+2; k++) {
            for (int l=j-1; l<j+2; l++) {
                if (!(k==i && l==j)) {
                    if (k>=0 && l>=0 && k<this.sizeGrid && l<this.sizeGrid) {
                        if (this.cells[k][l].isAlive()) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    public void generateNextState() {
        int[][] nbAliveNeighbours = new int[this.sizeGrid][this.sizeGrid];
        for (int i=0; i<sizeGrid; i++) {
            for (int j=0; j<sizeGrid; j++) {
                nbAliveNeighbours[i][j] = getnbAliveNeighbours(i, j);
            }
        }
        for (int i=0; i<sizeGrid; i++) { // getnbAliveNeighbours
            for (int j=0; j<sizeGrid; j++) {
                this.cells[i][j].setIsAlive(Cell.processState(this.cells[i][j].isAlive(), nbAliveNeighbours[i][j]));
            }
        }
    }

    public String toString() {
        // return this.cells.toString();
        String result = "";
        for (int i=0; i<this.sizeGrid; i++) {
            for (int j=0; j<this.sizeGrid; j++) {
                result = result.concat(this.cells[i][j].toString());
                if (j!=this.sizeGrid-1)
                    result = result.concat(" ");
            }
            if (i != this.sizeGrid-1)
                result = result.concat("\n");
        }
        return result;
    }
}
