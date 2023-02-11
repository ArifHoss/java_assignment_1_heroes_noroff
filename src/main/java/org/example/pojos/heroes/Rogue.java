package org.example.pojos.heroes;

public class Rogue extends Hero{
    private HeroAttribute heroAttribute;

    public Rogue() {
    }

    public Rogue(String name, HeroAttribute heroAttribute) {
        super(name);
        this.heroAttribute = heroAttribute;
    }

    public HeroAttribute getHeroAttribute() {
        return heroAttribute;
    }

    public void setHeroAttribute(HeroAttribute heroAttribute) {
        this.heroAttribute = heroAttribute;
    }
}
