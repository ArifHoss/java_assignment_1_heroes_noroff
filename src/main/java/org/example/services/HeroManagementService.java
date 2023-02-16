package org.example.services;

import org.example.pojos.heroes.*;
import org.example.pojos.items_equipment.Armor;
import org.example.pojos.items_equipment.Item;
import org.example.pojos.items_equipment.Weapon;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.example.enums.ArmorType.*;
import static org.example.enums.Slot.*;
import static org.example.enums.WeaponType.*;

public class HeroManagementService {

    public static Scanner sc = new Scanner(System.in);
    static ArrayList<Hero> heroes = new ArrayList<>();
    private static final Weapon weaponAxes = new Weapon("Axes", 1, WEAPON, AXES, 0);
    private static final Weapon weaponBows = new Weapon("Bows", 2, WEAPON, BOWS, 0);
    private static final Weapon weaponDaggers = new Weapon("Dagger", 3, WEAPON, DAGGERS, 0);
    private static final Weapon weaponHammers = new Weapon("Hammers", 4, WEAPON, HAMMERS, 0);
    private static final Weapon weaponStaffs = new Weapon("Staffs", 2, WEAPON, STAFFS, 0);
    private static final Weapon weaponSwords = new Weapon("Swords", 5, WEAPON, SWORDS, 0);
    private static final Weapon weaponWands = new Weapon("Wands", 5, WEAPON, WANDS, 0);

    private static final Armor armorCloth = new Armor("Cloth", 1, LEGS, CLOTH, 0);
    private static final Armor armorLeather = new Armor("Leather", 1, LEGS, LEATHER, 0);
    private static final Armor armorMail = new Armor("Mail", 1, LEGS, MAIL, 0);
    private static final Armor armorPlate = new Armor("Plate", 1, LEGS, PLATE, 0);

    public static void addHeroesMenu() {
        System.out.println("What kind of hero you want to see?");
        System.out.println("=====================");
        System.out.println("1. Mage: ");
        System.out.println("2. Ranger: ");
        System.out.println("3. Rogue: ");
        System.out.println("4. Warrior: ");
        System.out.println("5. All Hero");
        System.out.println("0. Choose 0 to EXIT!!");
        System.out.println("=====================");
        System.out.print("\nMake a choice: ");
        int choice = readIntNumber();
        switch (choice) {
            case 1:
                createMage();
                break;
            case 2:
                createRanger();
                break;

            case 3:
                createRogue();
                break;

            case 4:
                createWarrior();
                break;
            case 5:
                createMage();
                createRanger();
                createRogue();
                createWarrior();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Wrong choice!!");
        }

    }


    public static void createMage() {

        Mage mage = new Mage("Erik");
        mage.setHeroClass("Mage");
        mage.levelUp();
        mage.equip(weaponStaffs);
        heroes.add(mage);
        System.out.println("You just added a Mage " + mage);
        System.out.println("=====================");
    }


    public static void createRanger() {
        Hero ranger = new Ranger("Arif");
        ranger.setHeroClass("Ranger");
        ranger.equip(weaponBows);
        heroes.add(ranger);
        System.out.println("You just added a Ranger " + ranger);
        System.out.println("=====================");

    }

    public static void createRogue() {
        Hero rogue = new Rogue("Melvin");
        rogue.setHeroClass("Rogue");
        rogue.equip(weaponDaggers);
        heroes.add(rogue);
        System.out.println("You just added Rogue " + rogue);
        System.out.println("=====================");

    }

    public static void createWarrior() {
        Hero warrior = new Warrior("Rubin");
        warrior.setHeroClass("Warrior");
        warrior.equip(weaponAxes);
//        warrior.equip(armorMail);
        heroes.add(warrior);
        System.out.println("You just added Warrior " + warrior);
        System.out.println("=====================");

    }


    public static void display() {
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
        System.out.println("=====================");
    }


    public static int readIntNumber() {
        boolean repeat = true;
        while (repeat) {

            try {
                int readNumber = sc.nextInt();
                sc.nextLine();
                repeat = false;
                return readNumber;

            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Choose numeric vale only");
                System.out.println("=====================");
                System.out.print("Make choice again: ");
            }
        }
        return -1;
    }


}
