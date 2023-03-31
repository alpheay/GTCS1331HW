//I worked on the homework assignment alone, using only course materials.
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class takes attendance for a class.
 * @author Sagnik Nandi
 * @version 1.0.0
 */
public class AttendanceTaker {

    private File inputFile;

    private File outputFile;

    /**
     * Constructor
     * @param inputFile input file
     * @param outputFile output file
     */
    public AttendanceTaker(File inputFile, File outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    /**
     * Constructor
     * @param inputFile input file
     * @param outputFile output file
     */
    public AttendanceTaker(String inputFile, String outputFile) {
        this(
            new File(inputFile),
            new File(outputFile)
            );
    }

    /**
     * Main method
     * @param args Command line args
     * @throws FileNotFoundException if file not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        AttendanceTaker taker = new AttendanceTaker(args[0], args[1]);
        taker.takeAttendance();
    }

    /**
     * Takes attendance for a student
     * @throws FileNotFoundException if file not found
     */
    public void takeAttendance() throws FileNotFoundException {
        Scanner scanner = null;
        String[] studentNames = null;


        try {
            scanner = new Scanner(inputFile);

            String info = scanner.nextLine();
            if ((!info.substring(0, 3).equals("|--")
                || !info.substring(info.length() - 3).equals("--|"))
                || info.length() <= 6) {

                throw new BadFileException("The file doesn't have corret beginning or end");
            }

            info = info.substring(3, info.length() - 3);
            studentNames = info.split("---");
            scanner.close();

        } catch (NoSuchElementException error) {

            throw new BadFileException("The input file was empty");

        }
        PrintWriter filePrintWriter = new PrintWriter(outputFile);

        Scanner processStudentAttendanceScanner = new Scanner(System.in);

        for (String s:studentNames) {

            try {

                processStudentAttendance(s, processStudentAttendanceScanner, filePrintWriter);

            } catch (InvalidNameFormatException excpetion) {
                String str = String.format("Skipping %s because of an invalid name format: %s\n",
                    s,
                    excpetion.getMessage()
                );

                System.out.println(str);

            } catch (InvalidAttendanceInformationException excpetion) {
                String str = String.format("Skipping %s because of an invalid attendance information: %s\n",
                    s,
                    excpetion.getMessage()
                );
                System.out.printf(str);
            }
        }
        processStudentAttendanceScanner.close();
        filePrintWriter.close();
    }

    /**
     * Processes student attendance
     * @param name name of student
     * @param consoleScanner scanner
     * @param printWriter printwriter
     * @throws InvalidAttendanceInformationException if attendance info is invalid
     * @throws InvalidNameFormatException if name is invalid
     */
    private static void processStudentAttendance(String name, Scanner consoleScanner, PrintWriter printWriter)
        throws InvalidAttendanceInformationException, InvalidNameFormatException {
        if (!name.equals(name.toUpperCase())) {
            printWriter.println("-");
            throw new InvalidNameFormatException("The name isn't uppercase only");
        }
        for (int x = 0; x < name.length(); x++) {
            if ("0123456789".contains(name.substring(x, x + 1))) {
                printWriter.println("-");
                throw new InvalidNameFormatException("The name has a digit");
            }
            if (name.charAt(x) == '|') {
                printWriter.println("-");
                throw new InvalidNameFormatException("The name has a pipe character");
            }
        }

        System.out.print(name + ": ");
        String curr = consoleScanner.nextLine();
        if (curr.equals("")) {
            printWriter.println("-");
            throw new InvalidAttendanceInformationException("Attendance information missing");
        } else if (!(curr.equals("A") || curr.equals("P"))) {
            printWriter.println("-");
            throw new InvalidAttendanceInformationException("Attendance information is not P or A");
        } else {
            printWriter.println(curr);

        }
    }
}
