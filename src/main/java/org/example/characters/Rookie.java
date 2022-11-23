package org.example.characters;

public class Rookie extends Warrior {
    public Rookie(){
        super(1,1);
    }
    @Override
    public int getAttack() {
        return 1;
    }
}
