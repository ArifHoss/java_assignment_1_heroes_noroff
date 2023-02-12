package org.example.services;

import org.example.pojos.heroes.*;

import java.util.ArrayList;

public class HeroManagementService {

    public static ArrayList<Hero> heroes = new ArrayList<>();
    static Hero mage = new Mage("Erik");
    static Hero ranger = new Ranger("Arif");
    static Hero rogue = new Rogue("Melvin");
    static Hero warrior = new Warrior("Rubin");
    public static void createMage() {
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
    }


    public static void createRanger() {
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

    }

    public static void createRogue(){
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

    }

    public static void createWarrior() {
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

    }



    public static void display() {
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }



}
