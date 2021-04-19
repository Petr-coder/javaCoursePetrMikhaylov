package day11.task2;

public class Magician extends Hero implements MagicAttack, PhysAttack {
    public Magician() {
        super.health = MAX_HEALTH;
        super.physAtt = 5;
        super.magicAtt = 20;
        super.physDef = 0;
        super.magicDef = 80;

    }

    @Override
    public void magicalAttack(Hero hero) {
        if (hero.health > 0) {
            hero.health = hero.health - (magicAtt * (100 - hero.magicDef) / 100);
            if (hero.health < MIN_HEALTH) {
                hero.health = MIN_HEALTH;
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
