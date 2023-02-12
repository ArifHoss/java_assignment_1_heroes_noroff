package org.example.pojos.items_equipment;

import org.example.enums.Slot;

public abstract class Item {
    private String name;
    private int requiredLevel;
    private Slot slot;

    public Item() {
    }

    public String getName() {
        return name;
    }

    public Item(String name, int requiredLevel, Slot slot) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return " Item name = '" + name + '\'' +
                ", requiredLevel = " + requiredLevel +
                ", slot = " + slot;
    }
}
