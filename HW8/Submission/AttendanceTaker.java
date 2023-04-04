//I worked on the homework assignment alone, using only course materials.
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * Class represting an attendance taker
 * @author Sagnik Nandi
 * @version 1.0.0
 */
public class AttendanceTaker {

    private File inputFile;

    private File outputFile;

    /**
     * constructor for attendance taker
     * @param inputFile file input
     * @param outputFile file output
     */
    public AttendanceTaker(File inputFile, File outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    /**
     * constructor for attendance taker
     * @param input input file as str
     * @param output output file as str
     */
    public AttendanceTaker(String input, String output) {
        this(new File(input), new File(output));
    }

    /**
     * process student attendance for a single student
     * @param args command line args
     */
    public static void main(String[] args) throws FileNotFoundException {
        AttendanceTaker a = new AttendanceTaker(args[0], args[1]);
        a.takeAttendance();
    }

    /**
     * process student attendance
     * @throws FileNotFoundException file not found
     */

    public void takeAttendance() throws FileNotFoundException {
        Scanner filescan = null;
        String[] names = null;


        try {
            filescan = new Scanner(inputFile);

            String data = filescan.nextLine();
            if ((!data.substring(0, 3).equals("|--")
                || !data.substring(data.length() - 3).equals("--|"))
                ||
                data.length() <= 6) {
                throw new BadFileException("The file doesn't have correct beginning or end");
            }

            data = data.substring(3, data.length() - 3);
            names = data.split("---");
            filescan.close();





        } catch (NoSuchElementException n) {
            throw new BadFileException("The input file was empty");
        }

        PrintWriter fileprint = new PrintWriter(outputFile);

        Scanner scan = new Scanner(System.in);

        for (String n : names) {
            try {
                processStudentAttendance(n, scan, fileprint);
            } catch (InvalidNameFormatException i) {
                System.out.printf("Skipping %s because of an invalid name format: %s\n",
                    n,
                    i.getMessage());
            } catch (InvalidAttendanceInformationException i) {
                System.out.printf("Skipping %s because of an invalid attendance information: %s\n",
                    n,
                    i.getMessage());
            }
        }
        scan.close();
        fileprint.close();
    }

    /**
     * process student attendance
     * @param name  student name
     * @param consoleScanner file scanner
     * @param printWriter file writer
     * @throws InvalidAttendanceInformationException invalid attendance info exception
     * @throws InvalidNameFormatException invalid name format exception
     */
    private static void processStudentAttendance(String name, Scanner consoleScanner, PrintWriter printWriter)
        throws InvalidAttendanceInformationException, InvalidNameFormatException {
        if (!name.equals(name.toUpperCase())) {
            printWriter.println("-");
            throw new InvalidNameFormatException("The name isn't uppercase only");
        }
        for (int i = 0; i < name.length(); i++) {
            if ("1234567890".contains(name.substring(i, i + 1))) {
                printWriter.println("-");
                throw new InvalidNameFormatException("The name has a digit");
            }
            if (name.charAt(i) == '|') {
                printWriter.println("-");
                throw new InvalidNameFormatException("The name has a pipe character");
            }
        }
        System.out.print(name + ": ");
        String att = consoleScanner.nextLine();
        if (att.equals("")) {
            printWriter.println("-");
            throw new InvalidAttendanceInformationException("Attendance information missing");
        } else if (!(att.equals("A") || att.equals("P"))) {
            printWriter.println("-");
            throw new InvalidAttendanceInformationException("Attendance information is not P or A");
        } else {
            printWriter.println(att);

        }
    }
}
