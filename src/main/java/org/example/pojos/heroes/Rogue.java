package org.example.pojos.heroes;

import org.example.enums.ArmorType;
import org.example.enums.Slot;
import org.example.enums.WeaponType;
import org.example.exceptions.InvalidArmorException;
import org.example.exceptions.InvalidWeaponException;
import org.example.pojos.items_equipment.Armor;
import org.example.pojos.items_equipment.Item;
import org.example.pojos.items_equipment.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.enums.ArmorType.*;
import static org.example.enums.WeaponType.*;

public class Rogue extends Hero {

    private final Map<Slot, Item> equipment = new HashMap<>();

    public Rogue() {
    }

    public Rogue(String name) {
        super(name);
        super.setHeroAttributes(new HeroAttribute(2,6,1));
        List<WeaponType> validWeaponTypes = new ArrayList<>();
        validWeaponTypes.add(DAGGERS);
        validWeaponTypes.add(SWORDS);
        List<ArmorType> validArmorTypes = new ArrayList<>();
        validArmorTypes.add(LEATHER);
        validArmorTypes.add(MAIL);
        setValidWeaponTypes(validWeaponTypes);
        setValidArmorTypes(validArmorTypes);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        super.getHeroAttributes().calculateHeroattributes(new HeroAttribute(1,4,1));
    }

    @Override
    public double calculateDamage() {
        double weaponDamage = 1.0;
        if (getEquipment() != null && getEquipment().containsKey(Slot.WEAPON)) {
            Item item = getEquipment().get(Slot.WEAPON);
            if (item instanceof Weapon) {
                weaponDamage = ((Weapon) item).getWeaponDamage();
            }
        }

        int damagingAttribute = getHeroAttributes().getDexterity();

        double totalDamage = weaponDamage * (1 + damagingAttribute / 100.0);
//        System.out.println("Total Damage: " + totalDamage);
        return totalDamage;
    }

    @Override
    public void equip(Slot slot,Weapon weapon) throws InvalidWeaponException {
        if (getLevel() < weapon.getRequiredLevel()) {
            throw new InvalidWeaponException("Weapon level is too high for this character");
        }
        if (!getValidWeaponTypes().contains(weapon.getWeaponType())) {
            throw new InvalidWeaponException("Weapon type is not allowed for this character");
        }
            equipment.put(slot, weapon);
            setEquipment(equipment);
    }

    @Override
    public void equip(Slot slot,Armor armor) throws InvalidArmorException {
        if (getLevel() < armor.getRequiredLevel()) {
            throw new InvalidArmorException("Armor level is too high for the character");
        }
        if (!getValidArmorTypes().contains(armor.getArmorType())) {
            throw new InvalidArmorException("Armor type is not allowed for this character");
        }

        equipment.put(slot, armor);
        setEquipment(equipment);
    }

    @Override
    public String toString() {
        return "Rogue{" +
                "equipment=" + equipment +
                '}';
    }
}
