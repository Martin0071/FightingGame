package org.example.characters;

import org.example.services.CanProcessCommand;
import org.example.services.ChampionHitCommand;
import org.example.services.Command;

public class Healer extends Warrior implements IWarrior, CanProcessCommand {
    public Healer() {
        super(60, 0);
    }

    @Override
    public void hit(IWarrior opponent) {
    }

    public void heal(IWarrior patient) {
     if(patient instanceof Warrior p){
         p.heal(2);
     }
    }

    @Override
    public void processCommand(Command command, IWarrior sender) {
        if (command instanceof ChampionHitCommand) {
            heal(sender);
        }
    }
}