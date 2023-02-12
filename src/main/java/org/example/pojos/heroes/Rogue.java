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

public class Rogue extends Hero {

    public Rogue() {
    }

    public Rogue(String name) {
        super(name);
    }

    public Rogue(String name, String heroClass, int level, HeroAttribute heroAttributes, Map<Slot, Item> equipment, List<WeaponType> validWeaponTypes, List<ArmorType> validArmorTypes) {
        super(name, heroClass, level, heroAttributes, equipment, validWeaponTypes, validArmorTypes);
    }

    @Override
    public int levelUp(int level) {
        return level + 1;
    }

    @Override
    public Map<Slot, Item> equip() {
        Map<Slot, Item> equipment = new HashMap<>();
        Item weapon1 = new Weapon("Dagger", 1, WEAPON, DAGGERS, 0);
        Item weapon2 = new Weapon("Sword", 10, WEAPON, SWORDS, 0);

        Item armor1 = new Armor("Leather", 5, BODY, LEATHER, 0);
        Item armor2 = new Armor("Mail", 15, WEAPON, MAIL, 0);

        if (getLevel() >= 1) {
            equipment.put(WEAPON, weapon1);

        } else if (getLevel() >= 5) {
            equipment.put(BODY, armor1);

        } else if (getLevel() >= 10) {
            equipment.put(WEAPON, weapon2);

        } else if (getLevel() >= 15) {
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
