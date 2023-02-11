package org.example.services;

import org.example.enums.ArmorType;
import org.example.pojos.heroes.*;

import java.util.ArrayList;
import java.util.List;

public class HeroManagementService {

    static ArrayList<Hero> heroes = new ArrayList<>();
    public void createHero() {
        Hero mage = new Mage("Erik");
        Hero ranger = new Ranger("Arif");
        Hero rogue = new Rogue("Melvin");
        Hero warrior = new Warrior("Rubin");

        heroes.add(mage);
        heroes.add(ranger);
        heroes.add(rogue);
        heroes.add(warrior);

        for (Hero hero : heroes) {
            System.out.println(hero);
        }

//        Mage mage = new Mage("Erik",1,2, 3, "CLOTH",2);
//        mage.setHeroAttributes(new HeroAttribute(1,1,8));
//        mage.setValidArmorTypes(List.of(ArmorType.CLOTH));
//        mage.setLevel(2);

//        System.out.println(mage);
    }



}
