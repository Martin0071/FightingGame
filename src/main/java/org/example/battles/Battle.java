package org.example.battles;

import org.example.characters.Warrior;

public class Battle {

    /**
     * Fight between a Warrior and a Knight.
     *
     * @param warrior1 Warrior object
     * @param warrior2 Knight object
     * @return Is the Warrior 1 alive
     */
    public static boolean fight(Warrior warrior1, Warrior warrior2){
        while(warrior1.isAlive() && warrior2.isAlive()){
            warrior2.setHealth(warrior2.getHealth() - warrior1.getAttack());
            if(warrior2.isAlive()){
                warrior1.setHealth(warrior1.getHealth()- warrior2.getAttack());
            }
        }
        return warrior1.isAlive();
    }
    /*TODO:
        Create class army with addUnits method
       Overload method fight for armies


     */
}
