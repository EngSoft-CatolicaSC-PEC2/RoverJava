

public class Rover {
    public static final char RIGHT = 'R';
    public static final char LEFT = 'L';
    public static final char UP = 'U';
    public static final char DOWN = 'D';
    public static final char INVALID = 'I';


    public static final char END = 'E';
    public static final char SUCCESS = 'S';

    private int row;
    private int column;
    private int destinationRow;
    private int destinationColumn;

    final private Map map;

    public Rover(Map map) {
        this.map = map;
    }

    public void setStart(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void setDestination(int row, int column) {
        this.setDestinationRow(row);
        this.setDestinationColumn(column);
        map.markPosition(row,column,Map.DESTINATION);
    }

    public char move(char command) {
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
            makeTrail();
            row = newRow;
            column = newColumn;
            markRover();
            return SUCCESS;
        }

        return INVALID;
    }

    public boolean moveMatrixBlocking() {
        if (column < destinationColumn) {
            return moveBlocking(RIGHT);
        } else if (column > destinationColumn) {
            return moveBlocking(LEFT);
        } else if (row < destinationRow) {
            return moveBlocking(DOWN);
        } else if (row > destinationRow) {
            return moveBlocking(UP);
        }
        return false;
    }



    public int moveMatrix() {
        if (column < destinationColumn) {
            return move(RIGHT);
        } else if (column > destinationColumn) {
            return move(LEFT);
        } else if (row < destinationRow) {
            return move(DOWN);
        } else if (row > destinationRow) {
            return move(UP);
        }
        return INVALID;
    }

    public char moveRow() {

        if (row != destinationRow) {
            return INVALID;
        } else if (column < destinationColumn) {
            return move(RIGHT);
        } else if (column > destinationColumn) {
            return move(LEFT);
        }
        return END;
    }



    public boolean moveBlocking(char command) {
        char mapInfo = readMap(command);
        if (mapInfo == Map.INVALID || mapInfo == Map.BLOCK || mapInfo == Map.TRAIL) {
            command = rotate(command);
            return moveBlocking(command);
        }
        return move(command) == SUCCESS;
    }

    public char readMap(char command) {
        if (command == RIGHT && isRightMapLimit()  ) {
            return map.read(row, column + 1);
        } else if (command == LEFT && isLeftMapLimit() ) {
            return map.read(row, column - 1);
        } else if (command == UP && isUpperMapLimit() ) {
            return map.read(row - 1, column);
        } else if (command == DOWN && isLowerMapLimit() ) {
            return map.read(row + 1, column);
        } else {
            return Map.INVALID;
        }
    }

    public boolean hasReachedDestination() {
        return row == getDestinationRow() && column == getDestinationColumn();
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
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


    public boolean isRightMapLimit() {
        return column < map.getSize() - 1;
    }

    public boolean isLeftMapLimit() {
        return column > 0;
    }

    public boolean isUpperMapLimit() {
        return row > 0;
    }

    public boolean isLowerMapLimit() {
        return row < map.getSize() - 1;
    }

    public void makeTrail() {
        map.markPosition(row, column, Map.TRAIL);
    }
    public void markRover() {
        map.markPosition(row, column, Map.ROVER);
    }


    public char rotate(char command) {
        if (command == RIGHT)
            if (isLowerMapLimit())
                return DOWN;
            else
                return UP;
        if (command == DOWN)
            if (isLeftMapLimit())
                return LEFT;
            else
                return RIGHT;
        if (command == LEFT)
            if (isUpperMapLimit())
                return UP;
            else
                return DOWN;
        if (command == UP)
            if (isRightMapLimit())
                return RIGHT;
            else
                return LEFT;
        return INVALID;
    }
}
