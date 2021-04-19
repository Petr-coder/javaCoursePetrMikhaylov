package day11.task2;

public class Task2 {
    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        Paladin paladin = new Paladin();
        Magician magician = new Magician();
        Shaman shaman = new Shaman();

        warrior.physicalAttack(paladin);
        System.out.println(paladin.health);
        paladin.physicalAttack(magician);
        System.out.println(magician.health);
        shaman.healTeammate(magician);
        System.out.println(magician.health);
        magician.magicalAttack(paladin);
        System.out.println(paladin.health);
        shaman.physicalAttack(warrior);
        System.out.println(warrior.health);
        paladin.healHimself();
        System.out.println(paladin.health);
        warrior.physicalAttack(magician);
        System.out.println(magician.health);
        warrior.physicalAttack(magician);
        System.out.println(magician.health);
        warrior.physicalAttack(magician);
        System.out.println(magician.health);
        warrior.physicalAttack(magician);
        System.out.println(magician.health);
        warrior.physicalAttack(magician);
        System.out.println(magician.health);

    }
}
