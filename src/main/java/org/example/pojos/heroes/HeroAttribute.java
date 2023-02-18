package org.example.pojos.heroes;

import java.util.Objects;

public class HeroAttribute {

    private int strength;
    private int dexterity;
    private int intelligence;

    public HeroAttribute() {
    }

    public HeroAttribute(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HeroAttribute attribute)) return false;
        return getStrength() == attribute.getStrength() && getDexterity() == attribute.getDexterity() && getIntelligence() == attribute.getIntelligence();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStrength(), getDexterity(), getIntelligence());
    }

    public void addAttributes(HeroAttribute heroAttribute) {
        this.strength += heroAttribute.getStrength();
        this.dexterity += heroAttribute.getDexterity();
        this.intelligence += heroAttribute.getIntelligence();

    }


    @Override
    public String toString() {
        return "strength = " + strength +
                ", dexterity = " + dexterity +
                ", intelligence = " + intelligence;
    }

}
