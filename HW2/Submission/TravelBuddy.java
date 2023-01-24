//I worked on the homework assignment alone, using only course materials.

import java.text.NumberFormat;
import java.util.Scanner;

/**
* @author Sagnik Nandi
* @version 1.0
*/
public class TravelBuddy {
    /**
    * Main method for running the Travel Buddy program.
    * @param args The command line arguments.
    */
    public static void main(String[] args) {

        //Running Flag
        boolean running = true;

        while (running) {
            Scanner sc = new Scanner(System.in);

            double runningTotal = 0.0;
            double multiplier1 = 1.0;
            double multiplier2 = 1.0;
            double discount = 0.0;

            //Starting
            System.out.print("Welcome to Travel Buddy Service! Please enter your name here: ");
            String name = sc.nextLine();
            name = fixName(name);
            printServices();

            //Going Where
            System.out.println("\r\nWhere would you like to go, " + name + "?");
            String destination = sc.nextLine();
            double runningCount = 0.0;
            switch (destination) {
            case "The Hive":
                runningCount += 6.0;
                break;
            case "Invention Studio":
                runningCount += 7.5;
                break;
            case "Klaus":
                runningCount += 6.9;
                break;
            case "CULC":
                runningCount += 3.2;
                break;
            default:
                System.out.println("That destination is invalid, goodbye!");
            }
            if (runningCount == 0.0) {
                break;
            }
            runningTotal = runningCount;

            //ChickfilA Handeling
            if (destination.equals("Klaus") || destination.equals("CULC")) {
                System.out.println("\r\nWould you like to stop by Chick-fil-a on the way? (Yes/No)");
                String cfaAwnser = sc.nextLine();

                if (cfaAwnser.equals("Yes")) {
                    multiplier1 = 1.5;
                } else if (cfaAwnser.equals("No")) {
                    assert true;
                } else {
                    break;
                }
            }
            System.out.printf("\r\nYour current total is %s", printMoney(runningTotal * multiplier1 * multiplier2));

            // Discount
            System.out.println("\r\nDo you have a discount? (Yes/No)");
            String discountAwnser = sc.nextLine();
            if (discountAwnser.equals("Yes")) {
                System.out.println("\r\nWhat is the discount code?");
                String code = sc.nextLine();
                if (code.equals("CS1331")) {
                    System.out.println("\r\nYou have received 25% off your ride!");
                    multiplier2 = 0.75;
                } else if (code.equals("IKNOWTHEOWNER")) {
                    System.out.println("\r\nHow much would you like to take off?");
                    try {
                        discount = sc.nextDouble();
                    } catch (Exception e) {
                        discount = 1.0;
                    }
                    System.out.printf("\r\nTaking off %s from your total..\n", printMoney(discount));
                } else {
                    System.out.println("That discount does not exist! Better luck next time!");
                }
            }

            //Farwell Notice
            double finalTotal = runningTotal * multiplier1 * multiplier2 - discount;
            if (finalTotal < 0) {
                finalTotal = 0;
            }
            System.out.printf("\r\nThank you for riding with the Travel Buddy Service, %s! You are now %s poorer!"
                + " We hope you ride with us again! :)", name, printMoney(finalTotal));

            //Ending Things
            running = false;
            sc.close();
        }
    }

    /**
    * Fixes User Entered Name
    * @param name Needs a name input to provided by user.
    * @return Returns user entered name with fixed formatting.
    */
    public static String fixName(String name) {
        name = name.toLowerCase();
        name = name.substring(0, 1).toUpperCase() + name.substring(1);

        return name;
    }

    /**
    * Prints Money String
    * @param x A cost, as a double for the input.
    * @return String output of the double as a monetary value.
    */
    public static String printMoney(double x) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(x);

        return moneyString;
    }

    /**
    * Prints Services Screen
    */
    public static void printServices() {
        System.out.println("The Hive - " + printMoney(6.0));
        System.out.println("Invention Studio - " + printMoney(7.5));
        System.out.println("Klaus - " + printMoney(6.9));
        System.out.println("CULC - " + printMoney(3.2));
    }

}