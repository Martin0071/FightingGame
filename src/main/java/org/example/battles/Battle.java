package org.example.battles;

import org.example.armies.Army;
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
           warrior1.hit(warrior2);
           if(warrior2.isAlive()){
               warrior2.hit(warrior1);
           }
        }
        return warrior1.isAlive();
    }

    /**
     * Fight between two armies.
     *
     * @param army1 Army object
     * @param army2 Army object
     * @return Is the first army alive
     */
    public static boolean fight(Army army1, Army army2) {
        while (!army1.armyIsEmpty() && !army2.armyIsEmpty()) {
            if (army1.getFirstFromArmy().isAlive()) {
                fight(army1.getFirstFromArmy(),army2.getFirstFromArmy());
            } else {
                army1.getTroops().remove(army1.getFirstFromArmy());
                continue;
            }
            if (army2.getFirstFromArmy().isAlive()) {
                fight(army2.getFirstFromArmy(),army1.getFirstFromArmy());
            } else {
                army2.getTroops().remove(army2.getFirstFromArmy());
            }
        }
        return !army1.getTroops().isEmpty();
    }
}
