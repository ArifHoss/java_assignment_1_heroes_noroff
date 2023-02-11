package org.example.pojos.heroes;

public class Ranger extends Hero{
    private HeroAttribute heroAttribute;

    public Ranger() {
    }

    public Ranger(String name, HeroAttribute heroAttribute) {
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
