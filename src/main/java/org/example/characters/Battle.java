package org.example.characters;

public class Battle {
    public static boolean fight(Warrior warrior1, Warrior warrior2){
        while(warrior1.isAlive() && warrior2.isAlive()){
            warrior2.health -= warrior1.attack;
            if(warrior2.isAlive()){
                warrior1.health -= warrior2.attack;
            }
        }
        return warrior1.isAlive();

    }
}
