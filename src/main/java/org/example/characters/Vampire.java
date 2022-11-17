package org.example.characters;

public class Vampire extends Warrior{
    private static final int VAMPIRISM = 50;

    public static int getVAMPIRISM() {
        return VAMPIRISM;
    }

    @Override
    public int getHealth() {
        return health;
    }

    private int health = 40;

    public void setHealth(int health) {
        this.health = health;
    }

    public Vampire(){
        super(40,4);
    }
    private void heal(int healAmount){
        setHealth(getHealth()+healAmount);
    }

    @Override
    public void hit(Warrior opponent) {
        int damageDealt = opponent.getHealth();
        opponent.receiveDamage(getAttack());
        int healAmount = damageDealt-opponent.getHealth()*getVAMPIRISM()/100;
        heal(healAmount);
    }
}
