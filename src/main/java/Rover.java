public class Rover {
    public static final char RIGHT = 'R';
    public static final char LEFT = 'L';
    public static final char UP = 'U';
    public static final char DOWN = 'D';

    private int row;
    private int column;
    private int destinationRow;
    private int destinationColumn;

    public Rover() {

    }

    public void setStart(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void setDestination(int row, int column) {
        this.setDestinationRow(row);
        this.setDestinationColumn(column);
    }

    public boolean move(char command, Map map) {
        int newRow = row;
        int newColumn = column;

        if (command == RIGHT) {
            newColumn++;
        } else if (command == LEFT) {
            newColumn--;
        } else if (command == UP) {
            newRow--;
        } else if (command == DOWN) {
            newRow++;
        }

        if (map.isPositionValid(newRow, newColumn)) {
            row = newRow;
            column = newColumn;
            map.markPosition(row, column, Map.TRAIL);
            return true;
        }

        return false;
    }

    public boolean hasReachedDestination() {
        return row == getDestinationRow() && column == getDestinationColumn();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getDestinationRow() {
        return destinationRow;
    }

    public void setDestinationRow(int destinationRow) {
        this.destinationRow = destinationRow;
    }

    public int getDestinationColumn() {
        return destinationColumn;
    }

    public void setDestinationColumn(int destinationColumn) {
        this.destinationColumn = destinationColumn;
    }
}
