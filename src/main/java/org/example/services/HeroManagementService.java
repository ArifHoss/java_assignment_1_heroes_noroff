package org.example.services;

import org.example.exceptions.InvalidWeaponException;
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
    private static final Weapon weaponAxes = new Weapon("Axes", 1, WEAPON, AXES, 10);
    private static final Weapon weaponBows = new Weapon("Bows", 1, WEAPON, BOWS, 0);
    private static final Weapon weaponDaggers = new Weapon("Dagger", 1, WEAPON, DAGGERS, 0);
    private static final Weapon weaponHammers = new Weapon("Hammers", 1, WEAPON, HAMMERS, 0);
    private static final Weapon weaponStaffs = new Weapon("Staffs", 1, WEAPON, STAFFS, 0);
    private static final Weapon weaponSwords = new Weapon("Swords", 1, WEAPON, SWORDS, 0);
    private static final Weapon weaponWands = new Weapon("Wands", 1, WEAPON, WANDS, 0);

    private static final Armor armorCloth = new Armor("Cloth", 1, LEGS, CLOTH, new HeroAttribute());
    private static final Armor armorLeather = new Armor("Leather", 1, LEGS, LEATHER, new HeroAttribute());
    private static final Armor armorMail = new Armor("Mail", 1, LEGS, MAIL, new HeroAttribute());
    private static final Armor armorPlate = new Armor("Plate", 1, LEGS, PLATE, new HeroAttribute());

    public static void addHeroesMenu() throws InvalidWeaponException {
        System.out.println("What kind of hero you want to see?");
        System.out.println("=====================");
        System.out.println("1. Mage: ");
        System.out.println("2. Ranger: ");
        System.out.println("3. Rogue: ");
        System.out.println("4. Warrior: ");
        System.out.println("5. All Heroes: ");
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


    public static void createMage() throws InvalidWeaponException {

        Mage mage = new Mage("Erik");
        mage.setHeroClass("Mage");
        mage.levelUp();
        mage.equip(WEAPON,weaponStaffs);
        heroes.add(mage);
        System.out.println("You just added a Mage " + mage);
        System.out.print("Mage Erik's ");
        mage.totalAttributes();

        System.out.print("Mage Erik's ");
        mage.damage();
        System.out.println("=====================");
    }


    public static void createRanger() throws InvalidWeaponException {
        Hero ranger = new Ranger("Arif");
        ranger.setHeroClass("Ranger");
        ranger.levelUp();
        ranger.equip(WEAPON,weaponBows);
        heroes.add(ranger);
        System.out.println("You just added a Ranger " + ranger);

        System.out.print("Ranger Arif's ");
        ranger.totalAttributes();

        System.out.print("Ranger Arif's ");
        ranger.damage();
        System.out.println("=====================");

    }

    public static void createRogue() throws InvalidWeaponException {
        Hero rogue = new Rogue("Melvin");
        rogue.setHeroClass("Rogue");
        rogue.levelUp();
        rogue.equip(WEAPON,weaponDaggers);
        heroes.add(rogue);
        System.out.println("You just added Rogue " + rogue);
        System.out.print("Rogue Melvin's ");
        rogue.totalAttributes();

        System.out.print("Rogue Melvin's ");
        rogue.damage();
        System.out.println("=====================");

    }

    public static void createWarrior() throws InvalidWeaponException {
        Hero warrior = new Warrior("Rubin");
        warrior.setHeroClass("Warrior");
        warrior.levelUp();
        warrior.equip(WEAPON,weaponAxes);
        heroes.add(warrior);
        System.out.println("You just added Warrior " + warrior);
        System.out.print("Warrior Rubin's ");
        warrior.totalAttributes();

        System.out.print("Warrior Rubin's ");
        warrior.damage();
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
