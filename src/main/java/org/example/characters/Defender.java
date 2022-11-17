package org.example.characters;

public class Defender extends Warrior {
    private static final int DEFENSE = 2;

    public Defender() {
        super(60, 3);
    }

    @Override
    public void receiveDamage(int attack) {
        int receivedDamage = attack - getDefense();
        if (receivedDamage <= 0) {
            receivedDamage = 0;
        }
        super.receiveDamage(receivedDamage);
    }

    public int getDefense() {
        return DEFENSE;
    }

    @Override
    public String toString() {
        return "Defender{" +
                "defense=" + getDefense() +
                '}';
    }
}
