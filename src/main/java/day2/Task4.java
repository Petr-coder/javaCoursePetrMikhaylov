package day2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double calculationResult = calculateWithEnteredNumber(x);
        System.out.println(calculationResult);
    }

    static double calculateWithEnteredNumber(double input) {
        double calculationResult;

        if (input >= 5) {
            calculationResult = (Math.pow(input, 2) - 10) / (input + 7);
        } else if (input > -3 && input < 5) {
            calculationResult = (input + 3) * (Math.pow(input, 2) - 2);
        } else {
            calculationResult = 420.0;
        }
        return calculationResult;
    }
}
