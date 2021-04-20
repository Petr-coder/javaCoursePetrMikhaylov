package day11.task2;

public class Shaman extends Hero implements Healer, PhysAttack, MagicAttack {
    double magicAtt;

    public Shaman() {
        super.health = MAX_HEALTH;
        super.physAtt = 10;
        this.magicAtt = 15;
        super.physDef = 20;
        super.magicDef = 20;
    }

    @Override
    public void healHimself() {
        if (health < MAX_HEALTH) {

            if ((100 - health) < 50) {
                health = MAX_HEALTH;
            } else {
                health += 50;
            }
        }
    }

    @Override
    public void healTeammate(Hero hero) {
        if (hero.health < MAX_HEALTH) {

            if ((100 - hero.health) < 30) {
                hero.health = MAX_HEALTH;
            } else {
                hero.health += 30;
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
}
