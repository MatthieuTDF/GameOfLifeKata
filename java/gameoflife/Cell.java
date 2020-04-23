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
        if (nbNeighbourCellsAlive == 3) {
            return true;
        }
        else if (isAlive && nbNeighbourCellsAlive == 2) {
            return true;
        }
        else return false;
    }
}
