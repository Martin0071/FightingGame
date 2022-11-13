package org.example.characters;

import org.example.armies.Army;
import org.example.battles.Battle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
    @Test
    void armyTest(){
        //setup
        var myArmy = new Army();
        myArmy.addUnits(Warrior::new,3);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 3);
        assert Battle.fight(myArmy, enemyArmy);

    }
    @Test
    void armyTest2(){
        var army3 = new Army();
        army3.addUnits(Warrior::new, 2);
        army3.addUnits(Knight::new, 1);

        var army4 = new Army();
        army4.addUnits(Warrior::new, 5);
        assert !Battle.fight(army3, army4);
    }
    @Test
    void battleOne(){
        var army1 = new Army();
        army1.addUnits(()-> new Warrior(),11);
        var army2 = new Army();
        army2.addUnits(()-> new Warrior(),7);
        assertTrue(Battle.fight(army1,army2));
    }
    @Test
    void battleTwo(){
        var army1 = new Army();
        army1.addUnits(()-> new Warrior(),2);
        var army2 = new Army();
        army2.addUnits(()-> new Warrior(),3);
        assertFalse(Battle.fight(army1,army2));
    }
    @Test
    void battleThree(){
        var army1 = new Army();
        army1.addUnits(()-> new Warrior(),5);
        var army2 = new Army();
        army2.addUnits(()-> new Warrior(),7);
        assertFalse(Battle.fight(army1,army2));
    }
    @Test
    void battleFour(){
        var army1 = new Army();
        army1.addUnits(()-> new Warrior(),20);
        var army2 = new Army();
        army2.addUnits(()-> new Warrior(),21);
        assertTrue(Battle.fight(army1,army2));
    }
    @Test
    void battleFive(){
        var army1 = new Army();
        army1.addUnits(()-> new Warrior(),10);
        var army2 = new Army();
        army2.addUnits(()-> new Warrior(),11);
        assertTrue(Battle.fight(army1,army2));
    }
    @Test
    void battleSix(){
        var army1 = new Army();
        army1.addUnits(()-> new Warrior(),11);
        var army2 = new Army();
        army2.addUnits(()-> new Warrior(),7);
        assertTrue(Battle.fight(army1,army2));
    }
    @Test
    void demoBattle(){
        var army1 = new Army();
        army1.addUnits(()-> new Warrior(),1);
        army1.addUnits(()-> new Knight(),2);
        var army2 = new Army();
        army2.addUnits(()-> new Warrior(),2);
        army2.addUnits(()-> new Knight(),1);

        assertTrue(Battle.fight(army1,army2));
    }

}