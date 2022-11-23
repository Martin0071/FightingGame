package org.example.armies;

import org.example.characters.IWarrior;
import org.example.characters.Lancer;
import org.example.characters.Warrior;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class Army {
    private WarriorInArmy tail;
    static class WarriorInArmy implements IWarrior, Lancer.HasWarriorBehind {
        IWarrior warrior;
        IWarrior nextWarrior;

        public WarriorInArmy(IWarrior warrior) {
            this.warrior = warrior;
        }

        @Override
        public void hit(IWarrior opponent) {
            warrior.hit(opponent);
        }

        @Override
        public int getAttack() {
            return warrior.getAttack();
        }

        @Override
        public int getHealth() {
            return warrior.getHealth();
        }

        @Override
        public void receiveDamage(int attack) {
        warrior.receiveDamage(attack);
        }

        @Override
        public void heal(int healAmount) {

        }

        @Override
        public IWarrior getWarriorBehind() {
            return nextWarrior;
        }

        private void setNextWarrior(IWarrior nextWarrior) {
            this.nextWarrior = nextWarrior;
        }
    }

    public Army() {
    }


    protected Army(List<IWarrior> troops) {
        this.troops = troops;
    }

    List<IWarrior> troops = new ArrayList<>();
    private void addUnit(IWarrior warrior){
        WarriorInArmy wrapped = new WarriorInArmy(warrior);
        if(tail!=null){
            tail.setNextWarrior(wrapped);
        }
        tail = wrapped;
        troops.add(wrapped);
    }
    public void addUnits(Supplier<IWarrior> factory, int numberOfFighters) {
        for (int i = 0; i < numberOfFighters; i++) {
            WarriorInArmy wrapped = new WarriorInArmy(factory.get());
            if(tail!=null){
                tail.setNextWarrior(wrapped);
            }
            tail = wrapped;
            troops.add(wrapped);
        }
    }

    public boolean armyIsEmpty() {
        return getTroops().isEmpty();
    }


    public List<IWarrior> getTroops() {
        return troops;
    }

    public Iterator<IWarrior> firstAliveIterator() {
        return new FirAliveIterator();
    }

    class FirAliveIterator implements Iterator<IWarrior> {
        Iterator<IWarrior> iterator = troops.iterator();
        IWarrior champion;

        @Override
        public boolean hasNext() {
            if (champion != null && champion.isAlive()) {
                return true;
            }
            while (iterator.hasNext()) {
                champion = iterator.next();
                if (champion.isAlive()) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public IWarrior next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                return champion;
            }
        }
    }
}
