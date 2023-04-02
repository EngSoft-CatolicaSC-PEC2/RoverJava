public class Map {
    public static final char DESTINATION = 'D';

    public static final char ROVER = 'R';

    public static final char TRAIL = 'T';
    public static final char BLOCK = 'B';
    public static final char TERRAIN = '*';
    public static final char INVALID = 'I';

    final private int size;

    final private char[][] map;

    public Map(int size) {
        this.size = size;
        map = new char[size][size];
        load();
    }

    public int getSize(){
        return size;
    }

    public void load() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
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
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(".");

    }

    public boolean isPositionValid(int row, int column) {
        return row >= 0 && row < size && column >= 0 && column < size;
    }

    public char read(int row, int column) {
        return map[row][column];
    }
}
