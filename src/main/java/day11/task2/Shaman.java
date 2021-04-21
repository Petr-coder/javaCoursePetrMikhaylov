package day11.task2;

public class Shaman extends Hero implements Healer, PhysAttack, MagicAttack {
    double magicAtt;
    static final double HEAL_HIMSELF_AMOUNT = 50;
    static final double HEAL_TEAMMATE_AMOUNT = 30;

    public Shaman() {
        physAtt = 10;
        magicAtt = 15;
        physDef = 20;
        magicDef = 20;
    }

    @Override
    public void healHimself() {
        if (health < MAX_HEALTH) {

            if ((MAX_HEALTH - health) < HEAL_HIMSELF_AMOUNT) {
                health = MAX_HEALTH;
            } else {
                health += HEAL_HIMSELF_AMOUNT;
            }

        }
    }

    @Override
    public void healTeammate(Hero hero) {
        if (hero.health < MAX_HEALTH) {

            if ((MAX_HEALTH - hero.health) < HEAL_TEAMMATE_AMOUNT) {
                hero.health = MAX_HEALTH;
            } else {
                hero.health += HEAL_TEAMMATE_AMOUNT;
            }

        }
    }

    @Override
    public void physicalAttack(Hero hero) {
        if (hero.health > 0) {
            hero.health = hero.health - (physAtt * (100 - hero.physDef) / 100);
            if (hero.health < MIN_HEALTH) {
                hero.health = MIN_HEALTH;
            }
        }
    }

    @Override
    public void magicalAttack(Hero hero) {
        double damage = magicAtt * (100 - hero.magicDef) / 100;

        if (hero.health - damage < 0) {
            hero.health = MIN_HEALTH;
        } else {
            hero.health = hero.health - (magicAtt * (100 - hero.magicDef) / 100);
        }
    }

    @Override
    public String toString() {
        return "Shaman{" +
                "health=" + health +
                '}';
    }
}
