package org.example.pojos.heroes;

import org.example.enums.ArmorType;
import org.example.enums.*;
import org.example.enums.WeaponType;
import org.example.pojos.items_equipment.*;

import java.util.*;

import static org.example.enums.ArmorType.*;
import static org.example.enums.Slot.*;
import static org.example.enums.WeaponType.*;

public class Mage extends Hero {
    public Mage() {
    }

    public Mage(String name) {
        super(name);
    }

    public Mage(String name, String heroClass, int level, HeroAttribute heroAttributes, Map<Slot, Item> equipment, List<WeaponType> validWeaponTypes, List<ArmorType> validArmorTypes) {
        super(name, heroClass, level, heroAttributes, equipment, validWeaponTypes, validArmorTypes);
    }

    @Override
    public Map<Slot, Item> equip() {

        Map<Slot, Item> equipment = new HashMap<>();

        Weapon weapon1 = new Weapon("Staffs", 1, WEAPON, STAFFS, 0);
        Weapon weapon2 = new Weapon("Wand", 5, WEAPON, WANDS, 0);
        Armor armor = new Armor("Cloth", 10, BODY, CLOTH, 0);

        if (getLevel() >= 1) {
            equipment.put(WEAPON, weapon1);

        } else if (getLevel() >= 5) {
            equipment.put(WEAPON, weapon2);

        } else if (getLevel() >= 10) {
            equipment.put(BODY, armor);

        }

        return equipment;
    }

    @Override
    public void damage() {

    }

    @Override
    public void totalAttributes() {

        HeroAttribute attributes = new HeroAttribute(1, 1, 8);

        int strength = attributes.getStrength();
        int dexterity = attributes.getDexterity();
        int intelligence = attributes.getIntelligence();

        int totalAttributes = strength + dexterity + intelligence;
        System.out.println("Mage total attributes: " + totalAttributes);
    }

    @Override
    public String display() {
        StringBuilder sb = new StringBuilder();
        Mage mage = new Mage("Erik");
        sb.append("Name: " + mage.getName() + "\t");
        sb.append("Class: " + mage.getClass() + "\t");
        sb.append("Level: " + mage.getLevel() + "\t");
        sb.append("Total Strength: " + mage.getHeroAttributes().getStrength() + "\t");
        sb.append("Total Dexterity: " + mage.getHeroAttributes().getDexterity() + "\t");
        sb.append("Total Intelligence: " + mage.getHeroAttributes().getIntelligence() + "\t");
        sb.append("Equipment: " + mage.getEquipment() + "\t");
        return sb.toString();
    }


}
