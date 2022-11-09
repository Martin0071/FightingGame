package org.example.characters;

public class Warrior {
    int health;
    int attack;

    public Warrior() {
        this.health = 50;
        this.attack = 5;
    }

    public  boolean isAlive(){
        return health > 0;
    }
}
