package gameoflife;

public class Cell {
    private boolean isAlive;

    Cell() {
        this.isAlive = false;
    }

    Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public String toString() {
        return isAlive ? "X" : ".";
    }

    boolean isAlive() {
        return isAlive;
    }

    void setIsAlive(boolean newState) {
        this.isAlive = newState;
    }

    static boolean processState(boolean isAlive, int nbNeighbourCellsAlive) {
        // TODO

        if (isAlive){
            return nbNeighbourCellsAlive == 2 || nbNeighbourCellsAlive == 3;
        }else{
            return nbNeighbourCellsAlive == 3;
        }
    }
}
