package org.example.characters;

import org.example.weapons.Weapon;

public class Defender extends Warrior {
    private int defense = 2;

    public void setDefense(int defense) {
        this.defense = defense;
    }

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

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        setDefense(Math.max(0,getDefense()+ weapon.getDefense()));
    }

    public int getDefense() {
        return defense;
    }

    @Override
    public String toString() {
        return "Defender{" +
                "defense=" + getDefense() +
                '}';
    }
}
