package day3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int counter = 5;

        while (counter > 0) {
            double dividend = scanner.nextDouble();
            double divisor = scanner.nextDouble();
            counter--;

            switch ((int) divisor) {
                case 0:
                    System.out.println("Деление на 0");
                    break;
                default:
                    System.out.println(dividend / divisor);
                    continue;
            }
        }
    }
}
