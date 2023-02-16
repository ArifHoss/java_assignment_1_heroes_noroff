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
    private Map<Slot, Item> equipment = new HashMap<>();
    private List<WeaponType> validWeaponTypes = new ArrayList<>();
    private List<ArmorType> validArmorTypes = new ArrayList<>();

    public Mage() {
    }

    public Mage(String name) {
        super(name);
        super.setHeroAttributes(new HeroAttribute(1, 1, 8));
        validWeaponTypes.add(STAFFS);
        validWeaponTypes.add(WANDS);
        validArmorTypes.add(CLOTH);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        super.getHeroAttributes().addAttributes(new HeroAttribute(1, 1, 5));


    }

    @Override
    public Map<Slot, Item> equip(Weapon weapon) {

        if (getLevel() >= weapon.getRequiredLevel() && getValidWeaponTypes().contains(weapon.getWeaponType())) {
            equipment.put(WEAPON, weapon);
        }

        return equipment;
    }

    @Override
    public Map<Slot, Item> equip(Armor armor) {
        if (getLevel() >= armor.getRequiredLevel() && getValidArmorTypes().contains(armor.getArmorType())) {
            equipment.put(WEAPON, armor);
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
