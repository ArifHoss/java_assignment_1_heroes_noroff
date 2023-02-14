package org.example.pojos.heroes;

import org.example.enums.ArmorType;
import org.example.enums.Slot;
import org.example.enums.WeaponType;
import org.example.pojos.items_equipment.Armor;
import org.example.pojos.items_equipment.Item;
import org.example.pojos.items_equipment.Weapon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.enums.ArmorType.*;
import static org.example.enums.Slot.*;
import static org.example.enums.WeaponType.*;

public class Warrior extends Hero {

    public Warrior() {
    }

    public Warrior(String name) {
        super(name);
    }

    public Warrior(String name, String heroClass, int level, HeroAttribute heroAttributes, Map<Slot, Item> equipment, List<WeaponType> validWeaponTypes, List<ArmorType> validArmorTypes) {
        super(name, heroClass, level, heroAttributes, equipment, validWeaponTypes, validArmorTypes);
    }

//    @Override
//    public int levelUp(int level) {
//        if (level == 0) {
//            return level + 1;
//        } else {
//            return level++;
//        }
//    }

    @Override
    public Map<Slot, Item> equip() {

        Map<Slot, Item> equipment = new HashMap<>();

        Item weapon1 = new Weapon("Axe", 1, WEAPON, AXES, 0);
        Item weapon2 = new Weapon("Hammer", 2, WEAPON, HAMMERS, 0);
        Item weapon3 = new Weapon("Sword", 3, WEAPON, SWORDS, 0);

        Item armorMail1 = new Armor("Mail", 1, HEAD, MAIL, 1);
        Item armorMail2 = new Armor("Mail", 2, BODY, MAIL, 1);
        Item armorMail3 = new Armor("Mail", 3, LEGS, MAIL, 1);

        Item armorPlate1 = new Armor("Plate", 4, HEAD, PLATE, 1);
        Item armorPlate2 = new Armor("Plate", 5, BODY, PLATE, 1);
        Item armorPlate3 = new Armor("Plate", 6, LEGS, PLATE, 1);

        if (getLevel() >= 1) {
            equipment.put(WEAPON, weapon1);
            equipment.put(HEAD, armorMail1);

        } else if (getLevel() >= 2) {
            equipment.put(WEAPON, weapon2);
            equipment.put(BODY, armorMail2);

        } else if (getLevel() >= 3) {
            equipment.put(WEAPON, weapon3);
            equipment.put(BODY, armorMail3);

        } else if (getLevel() >= 4) {
            equipment.put(HEAD, armorPlate1);

        }else if (getLevel() >= 5) {
            equipment.put(BODY, armorPlate2);

        }else if (getLevel() >= 6) {
            equipment.put(LEGS, armorPlate3);
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
