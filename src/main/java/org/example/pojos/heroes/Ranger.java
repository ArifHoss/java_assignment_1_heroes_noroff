package org.example.pojos.heroes;

import org.example.enums.ArmorType;
import org.example.enums.Slot;
import org.example.enums.WeaponType;
import org.example.pojos.items_equipment.Item;

import java.util.List;
import java.util.Map;

public class Ranger extends Hero{


    public Ranger() {
    }

    public Ranger(String name) {
        super(name);
    }

    public Ranger(String name, int level, HeroAttribute heroAttributes, Map<Slot, Item> equipment, List<WeaponType> validWeaponTypes, List<ArmorType> validArmorTypes) {
        super(name, level, heroAttributes, equipment, validWeaponTypes, validArmorTypes);
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
    public void damage() {

    }

    @Override
    public HeroAttribute totalAttributes() {
        return null;
    }

    @Override
    public String display() {
        return null;
    }
}
