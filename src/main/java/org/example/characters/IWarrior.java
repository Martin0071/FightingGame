package org.example.characters;


import org.example.weapons.Weapon;

public interface IWarrior {
   default void hit(IWarrior opponent){
       opponent.receiveDamage(getAttack());
   }

    int getAttack();

    int getHealth();
    default boolean isAlive(){
        return getHealth()>0;
    }
    void receiveDamage(int attack);
    void heal(int healAmount);
    void equipWeapon(Weapon weapon);
}
