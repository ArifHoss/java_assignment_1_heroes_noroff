package org.example.pojos.heroes;

public class Warrior extends Hero{
    private HeroAttribute heroAttribute;

    public Warrior() {
    }

    public Warrior(String name) {
        super(name);
    }

    public HeroAttribute getHeroAttribute() {
        return heroAttribute;
    }

    public void setHeroAttribute(HeroAttribute heroAttribute) {
        this.heroAttribute = heroAttribute;
    }
}
