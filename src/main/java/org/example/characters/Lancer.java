package org.example.characters;
interface DealtDamageAware extends IWarrior{
    default int hitAndReportDamage(IWarrior opponent){
        int opponentHealth = opponent.getHealth();
        opponent.receiveDamage(getAttack());
        var healthAfter = opponent.getHealth();
        return opponentHealth-healthAfter;
    }
}
public class Lancer extends Warrior implements DealtDamageAware {
    private static final int PIERCING_POWER = 50;

    public static int getPiercingPower() {
        return PIERCING_POWER;
    }

    public Lancer(){
        super(50,6);
    }
    public interface HasWarriorBehind{
        IWarrior getWarriorBehind();
    }

    @Override
    public void hit(IWarrior opponent) {
           var dealtDamage = hitAndReportDamage(opponent);
            if(opponent instanceof HasWarriorBehind oponentWithNext){
            var nextWarrior = oponentWithNext.getWarriorBehind();
            if(nextWarrior!=null){
                nextWarrior.receiveDamage(dealtDamage * getPiercingPower() / 100);
            }
            }
    }
}
