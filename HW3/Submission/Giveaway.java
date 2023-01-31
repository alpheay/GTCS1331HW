//I worked on the homework assignment alone, using only course materials.
import java.util.Scanner;

/**
 * @author Sagnik Nandi
 * @version 1.0.0
 */
public class Giveaway {
/**
 *  Main entry point for the program.
 * @param args Command line arguments.
 */
    public static void main(String[] args) {
        //Setup
        Scanner s = new Scanner(System.in);
        String[][] inventory = new String[5][5];
        makeArray(inventory);
        boolean running = true;
        boolean stillRunning = true;

        System.out.println("Welcome to the 1331 Giveaway!");
        try {
            while (running) {
                if (emptyArray(inventory)) {
                    System.out.println("\nSorry, we have no more items!");
                    stillRunning = false;
                }
                if (!stillRunning) {
                    break;
                }
                switch (input(s, "\nWould you like to take an item? [Y]es, [N]o, or [E]xit", true)) {
                case "Y":

                    System.out.println("");
                    printArray(inventory);
                    // int[] toDel = stringInputHandeler(input(s, "\nWhat item are you interested in taking?", true));
                    inventory = outputHandelerEraser(inventory, s);
                    break;

                case "N":
                    print("Next person in line!");
                    break;

                case "E":
                    print("Have a good day!");
                    stillRunning = false;
                    break;
                default:
                    System.out.println("Please input 'Y', 'N', or 'E'");
                }
                if (!stillRunning) {
                    break;
                }
            }
        } catch (Exception e) {
            assert false;
        }

    }

    /**
     * Initializes the inventory array.
     * @param chart Input 2D string array.
     * @return Inventory array.
     */
    private static void makeArray(String[][] chart) {
        for (int i = 0; i < chart.length; i++) {
            for (int j = 0; j < chart.length; j++) {
                chart[i][j] = "x";
            }
        }
        chart[0][2] = "StuffedPython";
        chart[0][4] = "CSalt";
        chart[1][0] = "hAIrspray";
        chart[2][3] = "JavaBeans";
        chart[3][1] = "RustedMetal";
        chart[3][2] = "SwiftShoes";
        chart[4][0] = "FuRniture";
        chart[4][3] = "GroovyGear";
        chart[4][4] = "RadiantRuby";
    }
    /**
     * Initializes the inventory array.
     * @param chart Input 2D string array.
     * @return Inventory array.
     */
    private static void printArray(String[][] chart) {
        for (int i = 0; i < chart.length; i++) {
            for (int j = 0; j < chart.length; j++) {
                System.out.print("|");
                System.out.print(chart[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
    }
    /**
     * Initializes the inventory array.
     * @param chart Input 2D string array.
     * @return Inventory array.
     */
    private static int[] stringInputHandeler(String s) throws Exception {
        String[] arr = s.split(" ");
        int[] retArr = new int[2];
        if (arr.length == 2) {
            try {
                retArr[1] = Integer.parseInt(arr[0]);
                retArr[0] = Integer.parseInt(arr[1]);
            } catch (Exception e) {
                throw new Exception("inputHandeler Failed");
            }
        } else {
            throw new Exception("inputHandeler Failed");
        }
        return retArr;
    }
    /**
     * Initializes the inventory array.
     * @param s String to be parced.
     * @return 2 ints in an array.
     */
    private static String[][] outputHandelerEraser(String[][] chart, Scanner s) throws Exception {
        boolean running = true;
        int[] arr = new int[2];
        while (running) {
            boolean rerun = false;
            arr = stringInputHandeler(input(s, "\nWhat item are you interested in taking?", true));

            if (arr[1] > 4 || arr[0] > 4) {
                System.out.println("\r\nLocation does not exist.");
                rerun = true;
            }
            if (!rerun) {
                if (!chart[arr[1]][arr[0]].equals("x")) {
                    System.out.printf("\nYou successfully took the %s!\n", chart[arr[1]][arr[0]]);
                    running = false;
                } else {
                    System.out.println("\nThere is no item in this location.");
                }
            }
        }
        chart[arr[1]][arr[0]] = "x";
        return chart;
    }
    /**
     * Initializes the inventory array.
     * @param chart Input 2D string array.
     * @param s Scanner object.
     * @return Inventory array.
     */
    private static String input(Scanner s, String text, boolean... newLine) {
        String newLineManager = "";
        if (newLine.length > 0) {
            newLineManager = "\n";
        }
        System.out.print(text + newLineManager);
        String input = s.nextLine();
        return input;
    }
    /**
     * Initializes the inventory array.
     * @param chart Input 2D string array.
     * @param text Shown Text.
     * @param newLine For new line cases.
     * @return String for user input.
     */
    private static void print(String s) {
        System.out.println(s);
    }
    /**
     * Checks for empty array.
     * @param chart Input 2D string array.
     * @return A boolean to signify empty array.
     */
    private static boolean emptyArray(String[][] chart) {
        boolean empty = true;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!chart[i][j].equals("x")) {
                    empty = false;
                }
            }
        }
        return empty;
    }
}
