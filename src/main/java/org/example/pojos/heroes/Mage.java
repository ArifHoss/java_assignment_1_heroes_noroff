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

    @Override
    public Map<Slot, Item> equip() {

        Map<Slot, Item> equipment = new HashMap<>();

        List<WeaponType> validWeaponTypes = new ArrayList<>();
        validWeaponTypes.add(STAFFS);
        validWeaponTypes.add(WANDS);
        setValidWeaponTypes(validWeaponTypes);

        Weapon weapon = new Weapon("Staffs", 1, WEAPON, STAFFS, 0);
        Weapon weapon1 = new Weapon("Wand", 2, WEAPON, WANDS, 0);
        Armor armor = new Armor("Cloth", 3, BODY, CLOTH, 0);

        if (getLevel() == weapon.getRequiredLevel() && getValidWeaponTypes().contains(weapon.getWeaponType())) {
            equipment.put(WEAPON, weapon);
        }

        if (getLevel() == weapon1.getRequiredLevel() && getValidWeaponTypes().contains(weapon1.getWeaponType())) {
            equipment.put(WEAPON, weapon1);
        }

        if (getLevel() == armor.getRequiredLevel() && getValidArmorTypes().contains(armor.getArmorType())) {
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
