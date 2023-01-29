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
        Chart[0][2] = "StuffedPython";
        Chart[0][4] = "CSalt";
        Chart[1][0] = "hAIrspray";
        Chart[2][3] = "JavaBeans";
        Chart[3][1] = "RustedMetal";
        Chart[3][2] = "SwiftShoes";
        Chart[4][0] = "FuRniture";
        Chart[4][3] = "GroovyGear";
        Chart[4][4] = "RadiantRuby";
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

    private static int[] inputHandeler(String s) throws Exception {
        String[] arr = s.split(" ");
        int[] retArr = new int[2];
        if (arr.length == 2) {
            try {
                retArr[0] = Integer.parseInt(arr[0]);
                retArr[0] = Integer.parseInt(arr[1]);
            } catch (Exception e) {
                throw new Exception("inputHandeler Failed");
            }
        } else {
            throw new Exception("inputHandeler Failed");
        }
        return retArr;
    }
}
