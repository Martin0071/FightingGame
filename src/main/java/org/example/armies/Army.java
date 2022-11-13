package org.example.armies;

import org.example.characters.Knight;
import org.example.characters.Warrior;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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


    public List<Warrior> getTroops() {
        return troops;
    }

}
