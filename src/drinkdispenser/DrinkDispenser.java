package drinkdispenser;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class DrinkDispenser {
    public static List<CupHolder> cupHolders = new ArrayList<>();
    public static List<Shots> shots = new ArrayList<>();
    public static List<Syrups> syrups = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void addSyrup(Syrups syrup) {
        syrups.add(syrup);
    }

    public static void addShot(Shots shot) {
        shots.add(shot);
    }

    public static void replaceSyrup(Syrups newSyrup, int index) {
        for (int i = 0; i < syrups.size(); i++) {
            if (i == index) {
                syrups.remove(i);
                syrups.add(newSyrup);
            }
        }

    }

    public static void replaceShot(Shots newShot, int index) {
        for (int i = 0; i < shots.size(); i++) {
            if (i == index) {
                shots.remove(i);
                shots.add(newShot);
            }

        }
    }

    public static void displayShots() {
        for (int i = 0; i < shots.size(); i++) {
            System.out.println("Shot: " + shots.get(i).name + ", amount left: " + shots.get(i).currentAmount + ", index: " + i);
        }
    }

    public static void displaySyrups() {
        for (int i = 0; i < syrups.size(); i++) {
            System.out.println("Syrup: " + syrups.get(i).drinkName + ", amount left: " + syrups.get(i).volume + ", index: " + i);
        }
    }

    public static void ServeDrink(String size, int syrupIndex) {
        switch (size.toLowerCase(Locale.ROOT)) {
            case "small":
                    System.out.println("How many of these drinks would you like?");
                    int cupAmountS = sc.nextInt();
                    sc.nextLine();
                if (syrups.get(syrupIndex).volume > 1 * cupAmountS) {
                    syrups.get(syrupIndex).volume -= 1 * cupAmountS;
                    cupHolders.add(new CupHolder("small", cupAmountS));
                    System.out.println(cupAmountS + " small cups of " + syrups.get(syrupIndex).drinkName + " made.");
                } else {
                    System.out.println("Not enough syrup, sorry.");
                }
                break;
            case "medium":
                    System.out.println("How many of these drinks would you like?");
                    int cupAmountM = sc.nextInt();
                    sc.nextLine();
                if (syrups.get(syrupIndex).volume > 2 * cupAmountM) {
                    syrups.get(syrupIndex).volume -= 2 * cupAmountM;
                    cupHolders.add(new CupHolder("medium", cupAmountM));
                    System.out.println(cupAmountM + " medium cups of " + syrups.get(syrupIndex).drinkName + " made.");
                } else {
                    System.out.println("Not enough syrup, sorry.");
                }
                break;
            case "large":
                    System.out.println("How many of these drinks would you like?");
                    int cupAmountL = sc.nextInt();
                    sc.nextLine();
                if (syrups.get(syrupIndex).volume > 4 * cupAmountL) {
                    syrups.get(syrupIndex).volume -= 4 * cupAmountL;
                    cupHolders.add(new CupHolder("large", cupAmountL));
                    System.out.println(cupAmountL + " large cups of " + syrups.get(syrupIndex).drinkName + " made.");
                } else {
                    System.out.println("Not enough syrup, sorry.");
                }
                break;
        }
    }

    //PLACEHOLDER
    public static void ServeDrink(String size, int syrupIndex, int shotIndex, int shotCount) {
        switch (size.toLowerCase(Locale.ROOT)) {
            case "small":
                if (syrups.get(syrupIndex).volume > 1) {
                    syrups.get(syrupIndex).volume -= 1;
                    System.out.println("How many of these drinks would you like? 1-4");
                    int cupAmount = sc.nextInt();
                    if (cupAmount < 1 || cupAmount > 4) {
                        System.out.println("smh");
                        break;
                    }
                    sc.nextLine();
                    cupHolders.add(new CupHolder("small", cupAmount));
                } else {
                    System.out.println("Not enough syrup, sorry.");
                }
                break;
            case "medium":
                if (syrups.get(syrupIndex).volume > 2) {
                    syrups.get(syrupIndex).volume -= 2;
                    System.out.println("How many of these drinks would you like?");
                    int cupAmount = sc.nextInt();
                    sc.nextLine();
                    if (cupAmount < 1 || cupAmount > 4) {
                        System.out.println("smh");
                        break;
                    }
                    cupHolders.add(new CupHolder("medium", cupAmount));
                } else {
                    System.out.println("Not enough syrup, sorry.");
                }
                break;
            case "large":
                if (syrups.get(syrupIndex).volume > 4) {
                    syrups.get(syrupIndex).volume -= 4;
                    System.out.println("How many of these drinks would you like?");
                    int cupAmount = sc.nextInt();
                    sc.nextLine();
                    if (cupAmount < 1 || cupAmount > 4) {
                        System.out.println("smh");
                        break;
                    }
                    cupHolders.add(new CupHolder("large", cupAmount));
                } else {
                    System.out.println("Not enough syrup, sorry.");
                }
                break;
        }
    }
}
