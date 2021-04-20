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
        double damage = physAtt * (100 - hero.physDef) / 100;

        if (hero.health - damage < 0) {
            hero.health = MIN_HEALTH;
        } else {
            hero.health = hero.health - (physAtt * (100 - hero.physDef) / 100);
        }
    }
}
