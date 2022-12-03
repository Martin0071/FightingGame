package org.example.characters;

import org.example.weapons.Weapon;

public class Warrior implements IWarrior {
    private int health;
    private int attack;

    public void setAttack(int attack) {
        this.attack = attack;
    }

    int initialHealth;

    public Warrior() {
        this(50, 5);
    }

    protected Warrior(int health, int attack) {
        this.health = health;
        initialHealth = health;
        this.attack = attack;
    }

    public void receiveDamage(int attack) {
        setHealth(getHealth() - attack);
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        setHealth(getHealth() + weapon.getHealth());
        setAttack(getAttack() + weapon.getAttack());
    }

    @Override
    public void heal(int healAmount) {
        setHealth(Math.min(initialHealth, getHealth() + healAmount));
    }

    public int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "health=" + health +
                ", attack=" + attack +
                '}';
    }
}
