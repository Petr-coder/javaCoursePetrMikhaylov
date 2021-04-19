package day11.task2;

public class Warrior extends Hero implements PhysAttack {

    public Warrior() {
        super.health = 100;
        super.physAtt = 30;
        super.physDef = 80;
        super.magicDef = 0;
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
