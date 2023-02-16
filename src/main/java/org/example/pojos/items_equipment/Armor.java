package org.example.pojos.items_equipment;

import org.example.enums.ArmorType;
import org.example.enums.Slot;
import org.example.pojos.heroes.HeroAttribute;

public class Armor extends Item{
    private ArmorType armorType;
    private HeroAttribute armorAttribute;

    public Armor() {
    }

    public Armor(ArmorType armorType, HeroAttribute armorAttribute) {
        this.armorType = armorType;
        this.armorAttribute = armorAttribute;
    }

    public Armor(String name, int requiredLevel, Slot slot, ArmorType armorType, HeroAttribute armorAttribute) {
        super(name, requiredLevel, slot);
        this.armorType = armorType;
        this.armorAttribute = armorAttribute;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public HeroAttribute getArmorAttribute() {
        return armorAttribute;
    }

    public void setArmorAttribute(HeroAttribute armorAttribute) {
        this.armorAttribute = armorAttribute;
    }

    @Override
    public String toString() {
        return " ArmorType = " + armorType +"\t"+
                ", armorAttribute = " + armorAttribute+"\t";
    }
}
