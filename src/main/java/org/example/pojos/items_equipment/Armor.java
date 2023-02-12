package org.example.pojos.items_equipment;

import org.example.enums.ArmorType;
import org.example.enums.Slot;

public class Armor extends Item{
    private ArmorType armorType;
    private int armorAttribute;

    public Armor() {
    }

    public Armor(ArmorType armorType, int armorAttribute) {
        this.armorType = armorType;
        this.armorAttribute = armorAttribute;
    }

    public Armor(String name, int requiredLevel, Slot slot, ArmorType armorType, int armorAttribute) {
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

    public int getArmorAttribute() {
        return armorAttribute;
    }

    public void setArmorAttribute(int armorAttribute) {
        this.armorAttribute = armorAttribute;
    }

    @Override
    public String toString() {
        return " ArmorType = " + armorType +"\t"+
                ", armorAttribute = " + armorAttribute+"\t";
    }
}
