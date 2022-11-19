package org.example.characters;

public class Lancer extends Warrior{
    private static final int PIERCINGPOWER = 50;

    public static int getPIERCINGPOWER() {
        return PIERCINGPOWER;
    }

    public Lancer(){
        super(50,6);
    }

    @Override
    public void hit(Warrior opponent, Warrior opponent1) {
            int opponentHealth = opponent.getHealth();
            opponent.receiveDamage(getAttack());
            int nextAttackDamage = (opponentHealth - opponent.getHealth()) * getPIERCINGPOWER() / 100;
            opponent1.receiveDamage(nextAttackDamage);
    }
}
