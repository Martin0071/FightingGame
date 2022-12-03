package org.example.characters;

import org.example.weapons.Weapon;

public class Vampire extends Warrior {
    /**
     * Character with the vampirism trait
     *
     * @param vampirism
     */
    private int vampirism;

    public int getVampirism() {
        return vampirism;
    }

    private void setVampirism(int vampirism) {
        this.vampirism = vampirism;
    }


    public Vampire() {
        super(40, 4);
        this.vampirism = 50;
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        setVampirism(Math.max(0, getVampirism() + weapon.getVampirism()));
    }

    @Override
    public void hit(IWarrior opponent) {
        int opponentHealth = opponent.getHealth();
        opponent.receiveDamage(getAttack());
        int healAmount = (opponentHealth - opponent.getHealth()) * getVampirism() / 100;
        heal(healAmount);
    }

}
