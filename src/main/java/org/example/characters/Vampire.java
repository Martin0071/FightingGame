package org.example.characters;

public class Vampire extends Warrior {
    private static final int VAMPIRISM = 50;

    public Vampire() {
        super(40, 4);
    }

    public static int getVAMPIRISM() {
        return VAMPIRISM;
    }

    private void heal(int healAmount) {
        setHealth(getHealth() + healAmount);
    }

    /*@Override
    public void hit(Warrior opponent) {
        opponent.receiveDamage(getAttack());
        if(opponent instanceof Defender){
            int damageDealt = getAttack()-((Defender) opponent).getDefense();
            int healAmount = damageDealt*getVAMPIRISM()/100;
            this.heal(healAmount);
        }
        else{
           heal(getAttack());
        }
    }*/
    @Override
    public void hit(Warrior opponent) {
        int opponentHealth = opponent.getHealth();
        opponent.receiveDamage(getAttack());
        int healAmount = (opponentHealth - opponent.getHealth()) * getVAMPIRISM() / 100;
        heal(healAmount);
    }
}
