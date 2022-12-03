package org.example.weapons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Weapon {
    private int health;
    private int attack;
    private int defense;
    private int vampirism;
    private int healPower;

    private Weapon(WeaponBuilder weaponBuilder) {
        this.attack = weaponBuilder.attackPower;
    }
    public static class WeaponBuilder {
        private int attackPower;
        private int health;
        private int defense;
        private int vampirism;
        private int healPower;

        public WeaponBuilder setAttackPower(int attackPower) {
            this.attackPower = attackPower;
            return this;
        }

        public WeaponBuilder setHealth(int health) {
            this.health = health;
            return this;
        }

        public WeaponBuilder setDefense(int defense) {
            this.defense = defense;
            return this;
        }

        public WeaponBuilder setVampirism(int vampirism) {
            this.vampirism = vampirism;
            return this;
        }

        public WeaponBuilder setHealPower(int healPower) {
            this.healPower = healPower;
            return this;
        }

        public Weapon build() {
            return new Weapon(this);
        }

    }


}
