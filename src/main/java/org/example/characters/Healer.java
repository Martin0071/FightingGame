package org.example.characters;

import org.example.armies.Army;
import org.example.services.CanProcessCommand;
import org.example.services.ChampionHitCommand;
import org.example.services.Command;
import org.example.weapons.Weapon;

public class Healer extends Warrior implements IWarrior, CanProcessCommand {
    private int healingPower = 2;

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }

    public int getHealingPower() {
        return healingPower;
    }

    public Healer() {
        super(60, 0);
    }

    @Override
    public void hit(IWarrior opponent) {
        //DO NOTHING
    }

    public void heal(IWarrior patient) {
            if(patient instanceof Army.WarriorInArmy warriorInArmy){
                Warrior unwrappedWarrior = warriorInArmy.unwrapped();
                unwrappedWarrior.heal(getHealingPower());

            }

    }
    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        setHealingPower(Math.max(0,getHealingPower()+weapon.getHealPower()));
    }

    @Override
    public void processCommand(Command command, IWarrior sender) {
        if (command instanceof ChampionHitCommand) {
            heal(sender);
        }
    }
}
