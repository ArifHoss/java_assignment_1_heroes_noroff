package org.example.pojos.items_equipment;

import org.example.enums.ArmorType;

public class Armor extends Item{
    private ArmorType armorType;
    private int armorAttribute;

    public Armor() {
    }

    public Armor(ArmorType armorType, int armorAttribute) {
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
}
