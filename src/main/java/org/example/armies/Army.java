package org.example.armies;

import org.example.characters.Warrior;
import org.example.services.ChampionHitCommand;
import org.example.characters.IWarrior;
import org.example.characters.Lancer;
import org.example.services.CanProcessCommand;
import org.example.services.Command;
import org.example.weapons.Weapon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class Army implements Iterable<IWarrior>{
    private WarriorInArmy tail;

    public static class WarriorInArmy implements IWarrior, Lancer.HasWarriorBehind, CanProcessCommand {
        IWarrior warrior;
        WarriorInArmy nextWarrior;
        public WarriorInArmy(IWarrior warrior) {
            this.warrior = warrior;
        }

        @Override
        public void hit(IWarrior opponent) {
            warrior.hit(opponent);
            processCommand(ChampionHitCommand.INSTANCE,this);
        }

        @Override
        public void processCommand(Command command, IWarrior sender) {
            if(warrior instanceof CanProcessCommand war) {
                war.processCommand(command,sender);
            }
            if(nextWarrior!=null) {
                nextWarrior.processCommand(command, this);
            }
        }
       public Warrior unwrapped() {
           return (Warrior) warrior;
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
        public void equipWeapon(Weapon weapon) {
            warrior.equipWeapon(weapon);
        }

        @Override
        public IWarrior getWarriorBehind() {
            return nextWarrior;
        }

        private void setNextWarrior(WarriorInArmy nextWarrior) {
            this.nextWarrior = nextWarrior;
        }
    }

    public Army() {
    }
    public void equipWarriorAtPosition(int pos, Weapon weapon){
        troops.get(pos).equipWeapon(weapon);
    }
    protected Army(List<IWarrior> troops) {
        this.troops = troops;
    }

    List<IWarrior> troops = new ArrayList<>();
    public Army addUnits(Supplier<IWarrior> factory, int numberOfFighters) {
        for (int i = 0; i < numberOfFighters; i++) {
            WarriorInArmy wrapped = new WarriorInArmy(factory.get());
            if(tail!=null){
                tail.setNextWarrior(wrapped);
            }
            tail = wrapped;
            troops.add(wrapped);
        }
        return this;
    }
    public List<IWarrior> getTroops() {
        return troops;
    }

    @Override
    public Iterator<IWarrior> iterator() {
        return new ArmyIterator();
    }
    class ArmyIterator implements Iterator<IWarrior> {
        Iterator<IWarrior> iterator = troops.iterator();
        IWarrior nextAlive;
        @Override
        public boolean hasNext() {
          return iterator.hasNext();
        }

        @Override
        public IWarrior next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            else {
                nextAlive= iterator.next();
                if(!nextAlive.isAlive()){
                    iterator.remove();
                }
                    return ((WarriorInArmy) nextAlive).unwrapped();
            }
        }
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
