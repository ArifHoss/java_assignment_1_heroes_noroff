package org.example.pojos.heroes;

import org.example.enums.ArmorType;
import org.example.enums.Slot;
import org.example.enums.WeaponType;
import org.example.pojos.items_equipment.Armor;
import org.example.pojos.items_equipment.Item;
import org.example.pojos.items_equipment.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.enums.ArmorType.*;
import static org.example.enums.Slot.*;
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
        super.getHeroAttributes().addAttributes(new HeroAttribute(1,4,1));
    }

    @Override
    public void equip(Slot slot,Weapon weapon) {
        if (getLevel() >= weapon.getRequiredLevel() && getValidWeaponTypes().contains(weapon.getWeaponType())) {
            equipment.put(slot, weapon);
            setEquipment(equipment);
        }
    }

    @Override
    public void equip(Slot slot,Armor armor) {
        if (getLevel() >= armor.getRequiredLevel() && getValidArmorTypes().contains(armor.getArmorType())) {
            equipment.put(slot, armor);
            setEquipment(equipment);
        }
    }

}
