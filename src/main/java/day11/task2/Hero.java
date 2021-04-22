package day11.task2;

public abstract class Hero implements PhysAttack {
    double health;
    double physDef;
    double magicDef;
    double physAtt;

    static final int MAX_HEALTH = 100;
    static final int MIN_HEALTH = 0;

    public Hero() {
        health = MAX_HEALTH;
    }

    @Override
    public void physicalAttack(Hero hero) {
        double damage = physAtt * (MAX_HEALTH - hero.physDef) / 100;

        if (hero.health - damage < 0) {
            hero.health = MIN_HEALTH;
        } else {
            hero.health = hero.health - damage;
        }
    }
}
