package org.example.characters;

import org.example.armies.Army;
import org.example.services.CanProcessCommand;
import org.example.services.ChampionHitCommand;
import org.example.services.Command;

public class Healer extends Warrior implements IWarrior, CanProcessCommand {
    private static final int HEALING_POWER = 2;

    public static int getHealingPower() {
        return HEALING_POWER;
    }

    public Healer() {
        super(60, 0);
    }

    @Override
    public void hit(IWarrior opponent) {
        //DO NOTHING
    }

    public void heal(IWarrior patient) {
            if(patient instanceof Army.WarriorInArmy){
                Warrior unwrappedWarrior = ((Army.WarriorInArmy) patient).unwrapped();
                unwrappedWarrior.heal(getHealingPower());

            }

    }

    @Override
    public void processCommand(Command command, IWarrior sender) {
        if (command instanceof ChampionHitCommand) {
            heal(sender);
        }
    }
}
