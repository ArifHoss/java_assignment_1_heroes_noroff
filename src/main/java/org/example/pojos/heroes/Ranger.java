package org.example.pojos.heroes;

import org.example.enums.Slot;
import org.example.pojos.items_equipment.Armor;
import org.example.pojos.items_equipment.Item;
import org.example.pojos.items_equipment.Weapon;

import java.util.HashMap;
import java.util.Map;

import static org.example.enums.ArmorType.LEATHER;
import static org.example.enums.ArmorType.MAIL;
import static org.example.enums.Slot.*;
import static org.example.enums.WeaponType.BOWS;

public class Ranger extends Hero {


    public Ranger() {
    }

    public Ranger(String name) {
        super(name);
    }


    @Override
    public Map<Slot, Item> equip() {

        Map<Slot, Item> equipment = new HashMap<>();


        Item weapon1 = new Weapon("Bow", 1, WEAPON, BOWS, 0);

        Item armor1 = new Armor("Leather", 5, LEGS, LEATHER, 0);
        Item armor2 = new Armor("Mail", 10, BODY, MAIL, 0);

        if (getLevel() >= 1) {
            equipment.put(WEAPON, weapon1);

        } else if (getLevel() >= 5) {
            equipment.put(LEGS, armor1);

        } else if (getLevel() >= 10) {
            equipment.put(BODY, armor2);
        }
        return equipment;
    }

    @Override
    public void damage() {

    }

    @Override
    public void totalAttributes() {
    }

    @Override
    public String display() {
        return null;
    }
}
