package day11.task2;

public class Paladin extends Hero implements Healer, PhysAttack {

    public Paladin() {
        super.health = 100;
        super.physAtt = 15;
        super.physDef = 50;
        super.magicDef = 20;
    }

    @Override
    public void healHimself() {
        if (health < MAX_HEALTH) {
            if ((100 - health) < 25) {
                health = MAX_HEALTH;
            } else {
                health += 25;
            }
        }
    }

    @Override
    public void healTeammate(Hero hero) {
        if (hero.health < MAX_HEALTH) {
            if ((100 - hero.health) < 10) {
                hero.health = MAX_HEALTH;
            } else {
                hero.health += 10;
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
}
