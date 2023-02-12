package org.example.services;

import org.example.pojos.heroes.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HeroManagementService {

    public static Scanner sc = new Scanner(System.in);
    static ArrayList<Hero> heroes = new ArrayList<>();

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
        Hero mage = new Mage("Erik");
        mage.setHeroClass("Mage");
        mage.setLevel(2);

        if (mage.getLevel() == 1 && mage.getHeroClass().equals("Mage")) {
            mage.setHeroAttributes(new HeroAttribute(1, 1, 8));
        } else if (mage.getLevel() >= 2 && mage.getHeroClass().equals("Mage")) {
            mage.setHeroAttributes(new HeroAttribute(2, 2, 13));
        }

        if (mage.getHeroClass().equals("Mage")) {
            mage.setEquipment(mage.equip());
        }
        heroes.add(mage);
        System.out.println("You just added a Mage " + mage);
    }


    public static void createRanger() {
        Hero ranger = new Ranger("Arif");
        ranger.setHeroClass("Ranger");
        ranger.setLevel(2);

        if (ranger.getLevel() == 1 && ranger.getHeroClass().equals("Ranger")) {
            ranger.setHeroAttributes(new HeroAttribute(1, 7, 1));
        } else if (ranger.getLevel() >= 2 && ranger.getHeroClass().equals("Ranger")) {
            ranger.setHeroAttributes(new HeroAttribute(2, 12, 2));
        }

        if (ranger.getHeroClass().equals("Ranger")) {
            ranger.setEquipment(ranger.equip());
        }
        heroes.add(ranger);
        System.out.println("You just added a Ranger " + ranger);
        System.out.println("=====================");

    }

    public static void createRogue() {
        Hero rogue = new Rogue("Melvin");
        rogue.setHeroClass("Rogue");
        rogue.setLevel(2);

        if (rogue.getLevel() == 1 && rogue.getHeroClass().equals("Rogue")) {
            rogue.setHeroAttributes(new HeroAttribute(2, 6, 1));
        } else if (rogue.getLevel() >= 2 && rogue.getHeroClass().equals("Rogue")) {
            rogue.setHeroAttributes(new HeroAttribute(3, 10, 2));
        }

        if (rogue.getHeroClass().equals("Rogue")) {
            rogue.setEquipment(rogue.equip());
        }
        heroes.add(rogue);
        System.out.println("You just added Rogue " + rogue);
        System.out.println("=====================");

    }

    public static void createWarrior() {
        Hero warrior = new Warrior("Rubin");
        warrior.setHeroClass("Warrior");
        warrior.setLevel(5);

        if (warrior.getLevel() == 1 && warrior.getHeroClass().equals("Warrior")) {
            warrior.setHeroAttributes(new HeroAttribute(5, 2, 1));
        } else if (warrior.getLevel() >= 2 && warrior.getHeroClass().equals("Warrior")) {
            warrior.setHeroAttributes(new HeroAttribute(8, 4, 2));
        }

        if (warrior.getHeroClass().equals("Warrior")) {
            warrior.setEquipment(warrior.equip());
        }
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
