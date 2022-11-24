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

    private Army army1;

    private Army army2;

    @BeforeEach
    public void setup() {
        carl = new Warrior();
        jim = new Knight();

        army1 = new Army();
        army2 = new Army();
    }
    /*interface Warrior{

    }
    interface Defender{

    }
    interface Vampire extends Warrior,Defender{

    }
    class WarriorImp implements Warrior{

    }*/

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
        army1.addUnits(Warrior::new, 2);
        army1.addUnits(Knight::new, 1);

        army2.addUnits(Warrior::new, 5);
        assertFalse(Battle.fight(army1, army2));
    }

    @Test
    void battleOne() {
        army1.addUnits(Warrior::new, 11);
        army2.addUnits(Warrior::new, 7);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void battleTwo() {
        army1.addUnits(Warrior::new, 2);
        army2.addUnits(Warrior::new, 3);
        assertFalse(Battle.fight(army1, army2));
    }

    @Test
    void battleThree() {
        army1.addUnits(Warrior::new, 5);
        army2.addUnits(Warrior::new, 7);
        assertFalse(Battle.fight(army1, army2));
    }

    @Test
    void battleFour() {
        army1.addUnits(Warrior::new, 20);
        army2.addUnits(Warrior::new, 21);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void battleFive() {
        army1.addUnits(Warrior::new, 10);
        army2.addUnits(Warrior::new, 11);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void battleSix() {
        army1.addUnits(Warrior::new, 11);
        army2.addUnits(Warrior::new, 7);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void demoBattle() {
        army1.addUnits(Warrior::new, 1);
        army1.addUnits(Knight::new, 2);
        army2.addUnits(Warrior::new, 2);
        army2.addUnits(Knight::new, 1);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void defenderVsVampire() {
        var defender = new Defender();
        var vampire = new Vampire();
        assertTrue(Battle.fight(defender, vampire));
    }

    @Test
    void battle7() {
        army1.addUnits(Warrior::new, 5);
        army1.addUnits(Defender::new, 4);
        army1.addUnits(Defender::new, 5);
        army2.addUnits(Warrior::new, 4);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void battle8() {
        army1.addUnits(Defender::new, 5);
        army1.addUnits(Warrior::new, 20);
        army2.addUnits(Warrior::new, 21);
        army1.addUnits(Defender::new, 4);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void battle9() {

        army1.addUnits(Warrior::new, 10);
        army1.addUnits(Defender::new, 5);
        army2.addUnits(Warrior::new, 5);
        army1.addUnits(Defender::new, 10);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    void battle10() {

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
        army1.addUnits(Defender::new, 5);
        army1.addUnits(Vampire::new, 6);
        army1.addUnits(Warrior::new, 7);
        army2.addUnits(Warrior::new, 6);
        army2.addUnits(Defender::new, 6);
        army2.addUnits(Vampire::new, 6);
        assertFalse(Battle.fight(army1, army2));
    }
    @Test
    void battle12() {
        army1.addUnits(Defender::new, 2);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Warrior::new, 4);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Vampire::new, 3);
        assertFalse(Battle.fight(army1, army2));
    }
    @Test
    void battle13() {
        army1.addUnits(Defender::new, 11);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Warrior::new, 4);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Vampire::new, 13);
        assertTrue(Battle.fight(army1, army2));
    }
    @Test
    void battle14() {
        army1.addUnits(Defender::new, 9);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Warrior::new, 8);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Vampire::new, 13);
        assertTrue(Battle.fight(army1, army2));
    }
    @Test
    void smokeTest() {
       /* army1.addUnits(Lancer::new, 5);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Warrior::new, 4);
        army1.addUnits(Defender::new, 2);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Vampire::new, 6);
        army2.addUnits(Lancer::new,5);
        assertFalse(Battle.straightFight(army1, army2));*/
        army1.addUnits(Warrior::new,2);
        army2.addUnits(Rookie::new,2);
        assertTrue(Battle.straightFight(army1,army2));
    }
    @Test
    void battle15() {
        army1.addUnits(Lancer::new, 5);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Warrior::new, 4);
        army1.addUnits(Defender::new, 2);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Vampire::new, 6);
        army2.addUnits(Lancer::new,5);
        assertFalse(Battle.fight(army1, army2));
    }
    @Test
    void battle16() {
        army1.addUnits(Lancer::new, 7);
        army1.addUnits(Vampire::new, 3);
        army1.addUnits(Warrior::new, 4);
        army1.addUnits(Defender::new, 2);
        army2.addUnits(Warrior::new, 4);
        army2.addUnits(Defender::new, 4);
        army2.addUnits(Vampire::new, 6);
        army2.addUnits(Lancer::new,4);
        assertTrue(Battle.fight(army1, army2));
    }
    @Test
    void battle17() {
        army1.addUnits(Warrior::new,2);
        army2.addUnits(Lancer::new,1);
        army2.addUnits(Warrior::new,1);
        assertFalse(Battle.fight(army1, army2));
    }
    @Test
    void customBattle(){
        army1.addUnits(Lancer::new, 1);
        army2.addUnits(Rookie::new,2);
        assertTrue(Battle.fight(army1,army2));
    }
    @Test
    void customBattle2(){
        army1.addUnits(Rookie::new,2);
        army2.addUnits(Lancer::new,1);
        assertFalse(Battle.fight(army1,army2));
    }
    @Test
    void battleBetweenLancerAndWarrior(){
        Lancer lancer = new Lancer();
        Warrior warrior = new Warrior();
        assertTrue(Battle.fight(lancer,warrior));
    }
}