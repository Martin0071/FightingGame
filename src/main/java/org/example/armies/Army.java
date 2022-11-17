package org.example.armies;

import org.example.characters.Warrior;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Army {
    public Army() {
    }

    protected Army(List<Warrior> troops) {
        this.troops = troops;
    }

    List<Warrior> troops = new ArrayList<>();

    public void addUnits(Supplier<Warrior> factory, int numberOfFighters) {
        for (int i = 0; i < numberOfFighters; i++) {
            troops.add(factory.get());
        }
    }
    public Warrior getFirstFromArmy(){
       return getTroops().get(0);
    }
    public boolean armyIsEmpty(){
        return getTroops().isEmpty();
    }


    public List<Warrior> getTroops() {
        return troops;
    }

}
