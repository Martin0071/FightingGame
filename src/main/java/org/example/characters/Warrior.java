package org.example.characters;

public class Warrior implements IWarrior {
    private int health;
    private final int attack;

    public Warrior() {
        this(50, 5);
    }

    protected Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }
    public void receiveDamage(int attack) {
        setHealth(getHealth() - attack);
    }

    @Override
    public void heal(int healAmount) {
        setHealth(getHealth()+healAmount);
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
