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
        // TODO
        this.cells = new Cell[sizeGrid][sizeGrid];
        for (int i = 0; i<sizeGrid;  i++){
            for (int j = 0; j<sizeGrid;  j++){
                this.cells[i][j] = new Cell(rd.nextBoolean());
            }
        }

    }

    public int getAliveNeighbours(int posx, int posy){
        int res = 0;
        for (int k = posx - 1; k < posx +2 ; k++){
            for (int l = posy-1; l < posy + 2; l++){
                if (k != posx && l != posy){
                    if (k >= 0 && l >= 0 && k < this.sizeGrid && l < this.sizeGrid){
                        if (this.cells[k][l].isAlive()){
                            res ++;
                        }
                    }
                }
            }
        }
        return res;
    }

    public void generateNextState() {
        // TODO
        for (int i = 0; i< this.sizeGrid;  i++) {
            for (int j = 0; j < this.sizeGrid; j++) {
                int neighbours = getAliveNeighbours(i, j);
                boolean alive = this.cells[i][j].isAlive();
                this.cells[i][j].setIsAlive(Cell.processState(alive, neighbours));
            }
        }
    }

    public String toString() {
        // TODO
        String output = "";
        for (int i = 0; i < this.sizeGrid;  i++) {
            for (int j = 0; j < this.sizeGrid; j++) {
                output = output.concat(this.cells[i][j].toString());
                if (j == this.sizeGrid - 1){
                    output = output.concat("\n");
                }
            }

        }
        return output;
    }
}
