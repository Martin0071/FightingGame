package org.example.characters;

import org.example.armies.Army;
import org.example.battles.Battle;
import org.example.characters.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StraightFight {
    @DisplayName("StraightFight")
    @ParameterizedTest(name = "Fights")
    @MethodSource("testStraightFight")
    void testStraightFight(Army army1, Army army2, boolean expected) {

        var test = Battle.straightFight(army1, army2);

        System.out.println();
        assertEquals(expected, test);
    }

    public static List<Arguments> testStraightFight() {

        return List.of(
                arguments(new Army()
                                .addUnits(Defender::new, 2)
                                .addUnits(Healer::new, 1)
                                .addUnits(Vampire::new, 2)
                                .addUnits(Lancer::new, 2)
                                .addUnits(Healer::new, 1)
                                .addUnits(Warrior::new, 1),
                        new Army()
                                .addUnits(Warrior::new, 2)
                                .addUnits(Lancer::new, 4)
                                .addUnits(Healer::new, 1)
                                .addUnits(Defender::new, 2)
                                .addUnits(Vampire::new, 3)
                                .addUnits(Healer::new, 1),
                        false),
                arguments(new Army()
                                .addUnits(Warrior::new, 1)
                                .addUnits(Lancer::new, 1)
                                .addUnits(Healer::new, 1)
                                .addUnits(Defender::new, 2),
                        new Army()
                                .addUnits(Vampire::new, 3)
                                .addUnits(Warrior::new, 1)
                                .addUnits(Healer::new, 1)
                                .addUnits(Lancer::new, 2),
                        false),
                arguments(new Army()
                                .addUnits(Warrior::new, 10),
                        new Army()
                                .addUnits(Warrior::new, 6)
                                .addUnits(Lancer::new, 5),
                        false),

                arguments(new Army()
                                .addUnits(Lancer::new, 5)
                                .addUnits(Vampire::new, 3)
                                .addUnits(Warrior::new, 4)
                                .addUnits(Defender::new, 2),
                        new Army()
                                .addUnits(Warrior::new, 4)
                                .addUnits(Defender::new, 4)
                                .addUnits(Vampire::new, 6)
                                .addUnits(Lancer::new, 5),
                        false),

                arguments(
                        new Army()
                                .addUnits(Lancer::new, 7)
                                .addUnits(Vampire::new, 3)
                                .addUnits(Warrior::new, 4)
                                .addUnits(Defender::new, 2),
                        new Army()
                                .addUnits(Warrior::new, 4)
                                .addUnits(Defender::new, 4)
                                .addUnits(Vampire::new, 6)
                                .addUnits(Lancer::new, 4),
                        true),

                arguments(
                        new Army()
                                .addUnits(Lancer::new, 7)
                                .addUnits(Vampire::new, 3)
                                .addUnits(Healer::new, 1)
                                .addUnits(Warrior::new, 4)
                                .addUnits(Healer::new, 1)
                                .addUnits(Defender::new, 2),
                        new Army()
                                .addUnits(Warrior::new, 4)
                                .addUnits(Defender::new, 4)
                                .addUnits(Healer::new, 1)
                                .addUnits(Vampire::new, 6)
                                .addUnits(Lancer::new, 4),
                        false),

                arguments(new Army()
                                .addUnits(Lancer::new, 4)
                                .addUnits(Warrior::new, 3)
                                .addUnits(Healer::new, 1)
                                .addUnits(Warrior::new, 4)
                                .addUnits(Healer::new, 1)
                                .addUnits(Knight::new, 2),
                        new Army()
                                .addUnits(Warrior::new, 4)
                                .addUnits(Defender::new, 4)
                                .addUnits(Healer::new, 1)
                                .addUnits(Vampire::new, 2)
                                .addUnits(Lancer::new, 4),
                        true)
        );
    }
}