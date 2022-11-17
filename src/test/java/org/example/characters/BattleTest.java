package org.example.characters;

import org.example.armies.Army;
import org.example.battles.Battle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {
    private Warrior carl;
    private Knight jim;

    @BeforeEach
    public void setup() {
        carl = new Warrior();
        jim = new Knight();
    }

    @Test
    void firstFight() {
        assertFalse(Battle.fight(carl, jim));
    }

    @Test
    @DisplayName("Fight 2: Between knight and warrior")
    void secondFight() {
        assertTrue(Battle.fight(jim, carl));
    }

    @Test
    @DisplayName("Fight 3")
    void thirdFight() {
        Warrior mars = new Warrior();
        Battle.fight(carl, mars);
        assertTrue(carl.isAlive());
    }

    @Test
    @DisplayName("Fight 4")
    void fourthFight() {
        Battle.fight(jim, carl);
        assertTrue(jim.isAlive());
    }

    @Test
    @DisplayName("Fight 5")
    void fifthFight() {
        Warrior wife = new Warrior();

        Battle.fight(carl, wife);
        assertFalse(wife.isAlive());
    }

    @Test
    @DisplayName("Fight 6")
    void sixthFight() {
        Battle.fight(carl, jim);
        assertTrue(jim.isAlive());
    }

    @Test
    @DisplayName("Fight 7")
    void oneKnightAgainstTwoWarriors() {
        // setup
        Warrior unit_3 = new Warrior();
        // test start here
        Battle.fight(carl, jim);
        assertFalse(Battle.fight(jim, unit_3));
    }

    @Test
    @DisplayName("Fight 8")
    void defenderHealthCheck() {
        var unit1 = new Defender();
        var unit2 = new Rookie();
        Battle.fight(unit1, unit2);
        assertEquals(60, unit1.getHealth());
    }

    @Test
    @DisplayName("Fight 9")
    void rookieVsDefender() {
        var unit1 = new Defender();
        var unit2 = new Rookie();
        var unit3 = new Warrior();
        Battle.fight(unit1, unit2);
        assertTrue(Battle.fight(unit1, unit3));
    }

    @Test
    void armyTest() {
        //setup
        var myArmy = new Army();
        myArmy.addUnits(Warrior::new, 3);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 3);
        assertTrue(Battle.fight(myArmy, enemyArmy));

    }

    @Test
    void armyTest2() {
        var army3 = new Army();
        army3.addUnits(Warrior::new, 2);
        army3.addUnits(Knight::new, 1);

        var army4 = new Army();
        army4.addUnits(Warrior::new, 5);
        assertFalse(Battle.fight(army3, army4));
    }

    @Test
    void battleOne() {
        var army1 = new Army();
        army1.addUnits(Warrior::new, 11);
        var army2 = new Army();
        army2.addUnits(Warrior::new, 7);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void battleTwo() {
        var army1 = new Army();
        army1.addUnits(Warrior::new, 2);
        var army2 = new Army();
        army2.addUnits(Warrior::new, 3);
        assertFalse(Battle.fight(army1, army2));
    }

    @Test
    void battleThree() {
        var army1 = new Army();
        army1.addUnits(Warrior::new, 5);
        var army2 = new Army();
        army2.addUnits(Warrior::new, 7);
        assertFalse(Battle.fight(army1, army2));
    }

    @Test
    void battleFour() {
        var army1 = new Army();
        army1.addUnits(Warrior::new, 20);
        var army2 = new Army();
        army2.addUnits(Warrior::new, 21);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void battleFive() {
        var army1 = new Army();
        army1.addUnits(Warrior::new, 10);
        var army2 = new Army();
        army2.addUnits(Warrior::new, 11);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void battleSix() {
        var army1 = new Army();
        army1.addUnits(Warrior::new, 11);
        var army2 = new Army();
        army2.addUnits(Warrior::new, 7);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void demoBattle() {
        var army1 = new Army();
        army1.addUnits(Warrior::new, 1);
        army1.addUnits(Knight::new, 2);
        var army2 = new Army();
        army2.addUnits(Warrior::new, 2);
        army2.addUnits(Knight::new, 1);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void testFight() {
        var warrior = new Warrior();
        var defender = new Defender();
        assertFalse(Battle.fight(warrior, defender));
    }

    @Test
    void battle7() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior::new, 5);
        army1.addUnits(Defender::new, 4);
        army1.addUnits(Defender::new, 5);
        army2.addUnits(Warrior::new, 4);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void battle8() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Defender::new, 5);
        army1.addUnits(Warrior::new, 20);
        army2.addUnits(Warrior::new, 21);
        army1.addUnits(Defender::new, 4);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void battle9() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Warrior::new, 10);
        army1.addUnits(Defender::new, 5);
        army2.addUnits(Warrior::new, 5);
        army1.addUnits(Defender::new, 10);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void battle10() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Defender::new, 2);
        army1.addUnits(Warrior::new, 1);
        army1.addUnits(Defender::new, 1);
        army2.addUnits(Warrior::new, 5);
        assertFalse(Battle.fight(army1, army2));
    }

    /* @ParameterizedTest
     @MethodSource("myMethod")
     void battle(){

     }
     private static List<Arguments> myMethod() {
         return List.of(
                 Arguments.of(),
                 Arguments.of("", true),
                 Arguments.of("  ", true),
                 Arguments.of("not blank", false)
         );
     }*/
    @Test
    void battle11() {
        var army1 = new Army();
        var army2 = new Army();
        army1.addUnits(Defender::new, 5);
        army1.addUnits(Vampire::new, 6);
        army1.addUnits(Warrior::new, 7);
        army2.addUnits(Warrior::new, 6);
        army2.addUnits(Defender::new, 6);
        army2.addUnits(Vampire::new, 6);
        assertFalse(Battle.fight(army1, army2));
    }

}