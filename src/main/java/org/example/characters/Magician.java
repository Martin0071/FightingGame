package org.example.characters;

import lombok.Getter;
import lombok.Setter;
import org.example.armies.Army;
import org.example.services.CanProcessCommand;
import org.example.services.ChampionHitCommand;
import org.example.services.Command;
import org.example.weapons.MagicWand;
import org.example.weapons.Weapon;

@Getter
@Setter
public class Magician extends Warrior implements CanProcessCommand {
    void boostDamageSpell(IWarrior warrior) {
        if (warrior instanceof Army.WarriorInArmy ally && getMp() > 20) {
            ally.unwrapped().setAttack((int) (ally.getAttack() + ally.getAttack() * 0.2));
            setMp(getMp() - 20);
        }
    }
    void damageSpell(IWarrior opponent){
        if(getMp()>25){
            opponent.receiveDamage(getMagicDamage());
            setMp(getMp()-25);
        }
    }

    private int magicDamage;
    private int mp;

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public Magician() {
        super(30, 0);
        this.mp = 100;
        this.magicDamage=15;
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(new MagicWand());
    }

    @Override
    public void hit(IWarrior opponent) {
        damageSpell(opponent);
    }

    @Override
    public void processCommand(Command command, IWarrior sender) {
        if (command instanceof ChampionHitCommand&&!(((Army.WarriorInArmy)sender).unwrapped() instanceof Magician)) {
            boostAttack(sender);
        }
    }

    private void boostAttack(IWarrior sender) {
        boostDamageSpell(sender);
    }
}
