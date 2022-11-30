package org.example.characters;

import org.example.weapons.Weapon;

public class Warlord extends Defender implements IWarrior{

    @Override
    public int getAttack() {
        return 0;
    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void receiveDamage(int attack) {

    }

    @Override
    public void heal(int healAmount) {

    }

    @Override
    public void equipWeapon(Weapon weapon) {

    }
}
