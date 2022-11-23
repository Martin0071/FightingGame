package org.example.characters;

public class Vampire extends Warrior {
    private static final int VAMPIRISM = 50;

    public Vampire() {
        super(40, 4);
    }

    public static int getVAMPIRISM() {
        return VAMPIRISM;
    }
    @Override
    public void hit(IWarrior opponent) {
        int opponentHealth = opponent.getHealth();
        opponent.receiveDamage(getAttack());
        int healAmount = (opponentHealth - opponent.getHealth()) * getVAMPIRISM() / 100;
        heal(healAmount);
    }
}
