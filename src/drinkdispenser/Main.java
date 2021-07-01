package drinkdispenser;

import drinkdispenser.DrinkDispenser.*;

import java.util.Dictionary;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code her
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Drink Dispenser");
        System.out.println();
        System.out.println("Lets start by adding some flavor shots and syrups.");
        System.out.println();
        System.out.println("How many flavor shots would you be adding?");
        int shotAmount = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < shotAmount; i++) {
            System.out.println("Enter name of shot:");
            String name = scan.nextLine();
            int currentAmount = (int) (Math.random() * 15) + 5;
            int dispenseAmount = (int) (Math.random() * Math.ceil(currentAmount / 5)) + 1;
            DrinkDispenser.addShot(new Shots(name, currentAmount, dispenseAmount));
        }
        System.out.println("How many syrups would you be adding?");
        int syrupAmount = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < syrupAmount; i++) {
            System.out.println("Enter name of syrup:");
            String name = scan.nextLine();
            int liqAmount = (int) (Math.random() * 15) + 3;
            DrinkDispenser.addSyrup(new Syrups(name, liqAmount));
        }
        System.out.println("Would you like to replace any shots? y/n");
        if (scan.nextLine().toLowerCase(Locale.ROOT).equalsIgnoreCase("y")) {
            System.out.println("How many shots would you like to replace? 0 if changed your mind");
            int shotReplaceAmount = scan.nextInt();
            scan.nextLine();
            for (int i = 0; i < shotReplaceAmount; i++) {
                DrinkDispenser.displayShots();
                System.out.println("Which would you like to replace?");
                System.out.println("Enter index of shot to replace");
                int replace = scan.nextInt();
                scan.nextLine();
                System.out.println("Enter name of shot:");
                String name = scan.nextLine();
                int currentAmount = (int) (Math.random() * 15) + 5;
                int dispenseAmount = (int) (Math.random() * Math.ceil(currentAmount / 5)) + 1;
                DrinkDispenser.replaceShot(new Shots(name, currentAmount, dispenseAmount), replace);
            }
        }
        System.out.println("Would you like to replace any syrups? y/n");
        if (scan.nextLine().toLowerCase(Locale.ROOT).equalsIgnoreCase("y")) {
            System.out.println("How many syrups would you like to replace? 0 if changed your mind");
            int syrupReplaceAmount = scan.nextInt();
            scan.nextLine();
            for (int i = 0; i < syrupReplaceAmount; i++) {
                System.out.println("Which would you like to replace?");
                DrinkDispenser.displaySyrups();
                System.out.println("Enter index of syrup to replace");
                int replace = scan.nextInt();
                scan.nextLine();
                System.out.println("Enter name of syrup:");
                String name = scan.nextLine();
                int liqAmount = (int) (Math.random() * 15) + 3;
                DrinkDispenser.replaceSyrup(new Syrups(name, liqAmount), replace);
            }
        }
        System.out.println("How many drinks would you like to make?");
        int drinksAmount = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < drinksAmount; i++) {
            System.out.println("Would you like to add a flavor shot to your drink? y/n");
            switch (scan.nextLine().toLowerCase(Locale.ROOT)) {
                case "n":
                    DrinkDispenser.displaySyrups();
                    System.out.println("Which syrup flavor would you like? enter index");
                    int index = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Which size would you like? small/medium/large");
                    String size = scan.nextLine();
                    DrinkDispenser.ServeDrink(size, index);
                    break;
                case "y":

            }
        }
    }
}
