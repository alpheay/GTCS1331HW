package HW2.Submission;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Scanner;

public class TravelBuddy {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        
        
        System.out.print("Welcome to Travel Buddy Service! Please enter your name here:");
        String name = sc.next();
        name = fixName(name);
        printList();

        sc.close();
    }

    public static String fixName(String name) {
        name = name.toLowerCase();
        name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        
        return name;
    }

    public static void printList() {
        HashMap<String, Double> Menu = new HashMap<String, Double>();
        Menu.put("The Hive", 6.00);
        Menu.put("Invention Studio", 7.50);
        Menu.put("Klaus", 6.90);
        Menu.put("CULC", 3.20);

        for (String i : Menu.keySet()) {
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String moneyString = formatter.format(Menu.get(i));
            System.out.println(i + " - " + moneyString);
        }
    }

}

