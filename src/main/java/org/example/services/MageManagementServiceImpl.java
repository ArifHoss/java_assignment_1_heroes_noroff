package org.example.services;

import org.example.enums.ArmorType;
import org.example.enums.Slot;
import org.example.pojos.heroes.HeroAttribute;
import org.example.pojos.heroes.Mage;
import org.example.pojos.items_equipment.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MageManagementServiceImpl implements HeroManagementService {
    @Override
    public void createHero() {
        Mage mage = new Mage("Erik");
        mage.setHeroAttributes(new HeroAttribute(1,1,8));
        mage.setValidArmorTypes(List.of(ArmorType.CLOTH));
        mage.setLevel(2);

        System.out.println(mage);
    }

    @Override
    public int levelUp() {
        return 0;
    }

    @Override
    public Map<Slot, Item> equip() {
        return null;
    }

    @Override
    public int damage() {
        return 0;
    }

    @Override
    public int totalAttributes() {
        return 0;
    }

    @Override
    public void display() {
//        for (Mage mage : mages) {
//            System.out.println(mage);
//        }
        System.out.println("           ************          ");
    }


}
