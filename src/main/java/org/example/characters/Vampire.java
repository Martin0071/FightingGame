package org.example.characters;

public class Vampire extends Warrior {
    private static final int VAMPIRISM = 50;

    public Vampire() {
        super(40, 4);
    }

    public static int getVAMPIRISM() {
        return VAMPIRISM;
    }

    /*@Override
    public void hit(Warrior opponent) {
        opponent.receiveDamage(getAttack());
        if(opponent instanceof Defender){
            int damageDealt = getAttack()-((Defender) opponent).getDefense();
            int healAmount = damageDealt*getVAMPIRISM()/100;
            heal(healAmount);
        }
        else{
           heal(getAttack()*getVAMPIRISM()/100);
        }
    }*/
    @Override
    public void hit(Warrior opponent) {
        int opponentHealth = opponent.getHealth();
        opponent.receiveDamage(getAttack());
        int healAmount = (opponentHealth - opponent.getHealth()) * getVAMPIRISM() / 100;
        receiveHealing(healAmount);
    }
}
