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
    public static boolean fight(Army army1, Army army2){
                while(true) {
                    if(army1.getTroops().get(0).isAlive()) {
                        army1.getTroops().get(0).hit(army2.getTroops().get(0));
                    }
                    else {
                            army1.getTroops().remove(0);
                            if(army1.getTroops().size()<=0){
                                break;
                            }
                            continue;
                        }
                    if(army2.getTroops().get(0).isAlive()){
                        army2.getTroops().get(0).hit(army1.getTroops().get(0));
                    }
                    else{
                        army2.getTroops().remove(0);
                        if(army2.getTroops().size()<=0){
                            break;
                        }
                    }
                }
        return army1.getTroops().size()>0;
    }
}
