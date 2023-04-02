import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void exercise2_1() {
        System.out.println("\nExercise 2-1");
        System.out.println("\nSearch in the same row 2-1");
        Rover rover = new Rover();
        Map map = new Map();


        rover.setStart(2, 1);
        rover.setDestination(2, 7);

        map.print();

        boolean movementResult;
        do {
            movementResult = rover.move(Rover.RIGHT, map);
            map.print();
        } while (!rover.hasReachedDestination() && movementResult);

        displayFinalResult(rover);
    }

    public static void exercise2_2() {
        Rover rover = new Rover();
        Map map = new Map();

        System.out.println("\nExercise 2-2");

        rover.setStart(7, 7);
        rover.setDestination(1, 1);

        map.print();

        boolean movementResult;
        do {
            movementResult = rover.move(Rover.UP, map) || rover.move(Rover.LEFT, map);
            map.print();
        } while (!rover.hasReachedDestination());

        displayFinalResult(rover);
    }

    public static void exercise2_3() {
        Rover rover = new Rover();
        Map map = new Map();

        System.out.println("\nExercise 2-3");

        rover.setStart(0, 0);
        rover.setDestination(0, 7);
        map.markPosition(0, 2, Map.BLOCK);
        map.markPosition(1, 2, Map.BLOCK);
        map.markPosition(2, 2, Map.BLOCK);
        map.markPosition(3, 2, Map.BLOCK);
        map.markPosition(4, 2, Map.BLOCK);
        map.markPosition(4, 1, Map.BLOCK);
        map.markPosition(6, 1, Map.BLOCK);
        map.markPosition(7, 1, Map.BLOCK);
        map.markPosition(6, 4, Map.BLOCK);
        map.markPosition(7, 6, Map.BLOCK);
        map.markPosition(2, 0, Map.BLOCK);

        map.print();

        boolean movementResult;
        do {
            movementResult = rover.move(Rover.RIGHT, map) || rover.move(Rover.DOWN, map);
            map.print();
        } while (!rover.hasReachedDestination());

        displayFinalResult(rover);
    }

    public static void displayFinalResult(Rover rover) {
        if (rover.hasReachedDestination()) {
            System.out.printf("\n\nSUCCESS!\n - Rover arrived at Row: %d  and  Column: %d", rover.getRow(), rover.getColumn());
            System.out.printf("\n - Destination  Row: %d  and  Column: %d\n", rover.getDestinationRow(), rover.getDestinationColumn());
        } else {
            System.out.printf("\n\nFAILURE - Wrong row!\n - Rover is at Row: %d  and  Column: %d", rover.getRow(), rover.getColumn());
            System.out.printf("\n - Destination  Row: %d  and  Column: %d\n", rover.getDestinationRow(), rover.getDestinationColumn());
        }
    }

    private static void menu() {
        int option;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n\nChoose the exercise:\n\n");
            System.out.println("1. Exercise 1 - search in row");
            System.out.println("2. Exercise 2 - search in map");
            System.out.println("3. Exercises 3 and 4 - search with block");
            System.out.println("0. Exit");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    Main.exercise2_1();
                    break;

                case 2:
                    Main.exercise2_2();
                    break;

                case 3:
                    Main.exercise2_3();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Enter a valid option:");
            }
        } while (option != 0);

        scanner.close();
    }
}
