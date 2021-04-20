package day11.task2;

public class Magician extends Hero implements MagicAttack, PhysAttack {
    double magicAtt;

    public Magician() {
        super.health = MAX_HEALTH;
        super.physAtt = 5;
        this.magicAtt = 20;
        super.physDef = 0;
        super.magicDef = 80;

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
    public void physicalAttack(Hero hero) {
        double damage = physAtt * (100 - hero.physDef) / 100;

        if (hero.health - damage < 0) {
            hero.health = MIN_HEALTH;
        } else {
            hero.health = hero.health - (physAtt * (100 - hero.physDef) / 100);
        }
    }

}
