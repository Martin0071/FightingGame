package org.example.armies;

import org.example.characters.Warrior;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
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

    public boolean armyIsEmpty() {
        return getTroops().isEmpty();
    }


    public List<Warrior> getTroops() {
        return troops;
    }

    public Iterator<Warrior> firstAliveIterator() {
        return new FirAliveIterator();
    }

    class FirAliveIterator implements Iterator<Warrior> {
        Iterator<Warrior> iterator = troops.iterator();
        Warrior champion;

        @Override
        public boolean hasNext() {
            if (champion != null && champion.isAlive()) {
                return true;
            }
            while (iterator.hasNext()) {
                champion = iterator.next();
                return true;
            }
            return false;
        }

        @Override
        public Warrior next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                return champion;
            }
        }
    }
}
