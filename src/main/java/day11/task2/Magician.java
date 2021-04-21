package day11.task2;

public class Magician extends Hero implements MagicAttack, PhysAttack {
    double magicAtt;

    public Magician() {
        physAtt = 5;
        magicAtt = 20;
        magicDef = 80;
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
        return "Magician{" +
                "health=" + health +
                '}';
    }

}
