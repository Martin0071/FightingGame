package org.example.characters;

import org.example.weapons.Weapon;

public class Defender extends Warrior {
    private int defense;

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public Defender() {
        super(60, 3);
        this.defense=2;
    }
    public Defender(int health, int attack, int defense){
        super(health,attack);
        this.defense=defense;
    }

    @Override
    public void receiveDamage(int attack) {
        int receivedDamage = Math.max(0,attack - getDefense());
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
