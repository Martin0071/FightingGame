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


    public static boolean fight(Warrior warrior1, Warrior warrior2) {
        while (warrior1.isAlive() && warrior2.isAlive()) {
            warrior1.hit(warrior2);
            if (warrior2.isAlive()) {
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
        var firstArmyIterator = army1.firstAliveIterator();
        var secondArmyIterator = army2.firstAliveIterator();
        while (firstArmyIterator.hasNext() && secondArmyIterator.hasNext()) {
            fight(firstArmyIterator.next(), secondArmyIterator.next());
        }
        return firstArmyIterator.hasNext();
    }
}
