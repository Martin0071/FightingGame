package org.example.characters;

import org.example.battles.Battle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {
    private Warrior carl;
    private Knight jim;

    @BeforeEach
    public void setup(){
        carl = new Warrior();
        jim = new Knight();
    }

    @Test
    void firstFight() {
        assertFalse(Battle.fight(carl,jim));
    }

    @Test
    @DisplayName("Fight 2: Between knight and warrior")
    void secondFight(){
        assertTrue(Battle.fight(jim,carl));
    }

    @Test
    @DisplayName("Fight 3")
    void thirdFight(){
        Warrior mars = new Warrior();
        Battle.fight(carl,mars);
        assertTrue(carl.isAlive());
    }

    @Test
    @DisplayName("Fight 4")
    void fourthFight(){
        Battle.fight(jim,carl);
        assertTrue(jim.isAlive());
    }

    @Test
    @DisplayName("Fight 5")
    void fifthFight(){
        Warrior wife = new Warrior();

        Battle.fight(carl,wife);
        assertFalse(wife.isAlive());
    }

    @Test
    @DisplayName("Fight 6")
    void sixthFight(){
        Battle.fight(carl,jim);
        assertTrue(jim.isAlive());
    }

    @Test
    @DisplayName("Fight 7")
    void oneKnightAgainstTwoWarriors(){
        // setup
        Warrior unit_3 = new Warrior();
        // test start here
        Battle.fight(carl,jim);
        assertFalse(Battle.fight(jim, unit_3));
    }
}