public class Giveaway {

    public static void main(String[] args) {
        String[][] Chart = new String[5][5];
        makeArray(Chart);
        printArray(Chart);
    }

    private static void makeArray(String[][] Chart) {
        for (int i = 0; i < Chart.length; i++) {
            for (int j = 0; j < Chart.length; j++) {
                Chart[i][j] = "x";
            }
        }
        
    }

    private static void printArray(String[][] Chart) {
        for (int i = 0; i < Chart.length; i++) {
            for (int j = 0; j < Chart.length; j++) {
                System.out.print("|");
                System.out.print(Chart[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
    }
}
