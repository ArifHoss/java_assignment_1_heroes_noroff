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

    @Override
    public int levelUp(int level) {
        if (level == 0) {
            return level + 1;
        } else {
            return level++;
        }
    }

    @Override
    public Map<Slot, Item> equip() {

        Map<Slot, Item> equipment = new HashMap<>();

        Item weapon1 = new Weapon("Axe", 1, WEAPON, AXES, 0);
        Item weapon2 = new Weapon("Hammer", 5, WEAPON, HAMMERS, 0);
        Item weapon3 = new Weapon("Sword", 10, WEAPON, SWORDS, 0);

        Item armor1 = new Armor("Mail", 1, BODY, MAIL, 1);
        Item armor2 = new Armor("Plate", 5, BODY, PLATE, 0);

        if (getLevel() >= 1) {
            equipment.put(WEAPON, weapon1);
            equipment.put(BODY, armor1);

        } else if (getLevel() >= 5) {
            equipment.put(WEAPON, weapon2);
            equipment.put(BODY, armor2);

        } else if (getLevel() >= 10) {
            equipment.put(WEAPON, weapon3);
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
