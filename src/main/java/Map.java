public class Map {
    public static final int MAP_SIZE = 8;
    public static final char DESTINATION = 'D';
    public static final char TRAIL = 'T';
    public static final char BLOCK = 'B';
    public static final char TERRAIN = '*';
    public static final char INVALID = 'I';

    private char[][] map;

    public Map() {
        map = new char[MAP_SIZE][MAP_SIZE];
        load();
    }

    public void load() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = TERRAIN;
            }
        }
    }

    public void markPosition(int row, int column, char symbol) {
        if (isPositionValid(row, column)) {
            map[row][column] = symbol;
        }
    }

    public void print() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isPositionValid(int row, int column) {
        return row >= 0 && row < MAP_SIZE && column >= 0 && column < MAP_SIZE;
    }
}
