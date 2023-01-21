package HW2.Submission;

//I worked on the homework assignment alone, using only course materials.

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Scanner;

public class TravelBuddy {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        
        
        System.out.print("Welcome to Travel Buddy Service! Please enter your name here: ");
        String name = sc.next();
        name = fixName(name);
        
        System.out.println("\r\n Where would you like to go, " + name + "?");

        sc.close();
    }

    public static String fixName(String name) {
        name = name.toLowerCase();
        name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        
        return name;
    }

    public static String printMoney(double x) {
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String moneyString = formatter.format(x);
            
            return moneyString;
    }

    
}

