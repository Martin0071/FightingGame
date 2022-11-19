package org.example.characters;

public class Warrior {
    private int health;
    private final int attack;

    public Warrior() {
        this(50, 5);
    }

    protected Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void hit(Warrior opponent) {
        opponent.receiveDamage(getAttack());
    }
    public void hit(Warrior opponent, Warrior opponent1) {
        opponent.receiveDamage(getAttack());
        opponent1.receiveDamage(getAttack());
    }
    public void receiveDamage(int attack) {
        setHealth(getHealth() - attack);
    }

    public int getHealth() {
        return health;
    }
    public void receiveHealing(int healAmount){
        setHealth(getHealth()+healAmount);
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
