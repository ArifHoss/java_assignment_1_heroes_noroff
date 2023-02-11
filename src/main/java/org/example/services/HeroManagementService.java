package org.example.services;

import org.example.enums.Slot;
import org.example.pojos.heroes.Mage;
import org.example.pojos.items_equipment.Item;

import java.util.Map;

public interface HeroManagementService {

    void createHero();

    int levelUp();

    Map<Slot, Item> equip();

    int damage();

    int totalAttributes();

    void display();

}
