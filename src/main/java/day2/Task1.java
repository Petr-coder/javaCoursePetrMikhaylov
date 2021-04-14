package day2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner enterNumberOfFloorsOfBuilding = new Scanner(System.in);
        int numberOfFloorsOfBuilding = enterNumberOfFloorsOfBuilding.nextInt();

        if (numberOfFloorsOfBuilding > 0 && numberOfFloorsOfBuilding < 5) {
            System.out.println("Малоэтажный дом");
        } else if (numberOfFloorsOfBuilding > 4 && numberOfFloorsOfBuilding < 9) {
            System.out.println("Среднеэтажный дом");
        } else if (numberOfFloorsOfBuilding > 8) {
            System.out.println("Многоэтажный дом");
        } else {
            System.out.println("Ошибка ввода");
        }
    }
}
