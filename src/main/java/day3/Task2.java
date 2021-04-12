package day3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextDouble()) {
            double dividend = scanner.nextDouble();
            double divisor = scanner.nextDouble();

            switch ((int) divisor) {
                case 0:
                    break;
                default:
                    System.out.println(dividend / divisor);
                    continue;
            }
            break;
        }
    }
}
