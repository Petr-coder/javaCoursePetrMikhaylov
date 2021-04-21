package day11.task2;

public class Paladin extends Hero implements Healer {
    static final double HEAL_HIMSELF_AMOUNT = 25;
    static final double HEAL_TEAMMATE_AMOUNT = 10;

    public Paladin() {
        physAtt = 15;
        physDef = 50;
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
    public String toString() {
        return "Paladin{" +
                "health=" + health +
                '}';
    }
}
