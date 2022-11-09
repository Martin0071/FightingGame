package org.example.characters;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    @Test
    @DisplayName("Fight")
    void firstFight() {
        Warrior carl = new Warrior();
        Knight jim = new Knight();

        assertFalse(Battle.fight(carl,jim));
    }
    @Test
    @DisplayName("Fight 2")
    void secondFight(){
        Knight rmon = new Knight();
        Warrior slevin = new Warrior();

        assertTrue(Battle.fight(rmon,slevin));
    }
    @Test
    @DisplayName("Fight 3")
    void thirdFight(){
        Warrior bob = new Warrior();
        Warrior mars = new Warrior();
        Battle.fight(bob,mars);
        assertTrue(bob.isAlive());

    }
    @Test
    @DisplayName("Fight 4")
    void fourthFight(){
        Knight zeus = new Knight();
        Warrior godkiller = new Warrior();
        Battle.fight(zeus,godkiller);
        assertTrue(zeus.isAlive());
    }
    @Test
    @DisplayName("Fight 5")
    void fifthFight(){
        Warrior husband = new Warrior();
        Warrior wife = new Warrior();
        Battle.fight(husband,wife);
        assertFalse(wife.isAlive());
    }
    @Test
    @DisplayName("Fight 6")
    void sixthFight(){
        Warrior dragon = new Warrior();
        Knight knight = new Knight();
        Battle.fight(dragon,knight);
        assertTrue(knight.isAlive());
    }
    @Test
    @DisplayName("Fight 7")
    void seventhFight(){
        Warrior unit_1 = new Warrior();
        Knight unit_2 = new Knight();
        Warrior unit_3 = new Warrior();
        Battle.fight(unit_1,unit_2);
        assertFalse(Battle.fight(unit_2,unit_3));
    }
}