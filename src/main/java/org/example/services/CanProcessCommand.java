package org.example.services;

import org.example.characters.IWarrior;

public interface CanProcessCommand {
   default void processCommand(Command command, IWarrior sender){
   }

}
