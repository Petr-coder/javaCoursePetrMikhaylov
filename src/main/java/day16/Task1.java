package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("test3");
        printResult(file);
    }

    public static void printResult(File file) {
        String[] digitsArray = convertFileToString(file);
        double result = calculateArithmeticMean(digitsArray);
        printInTwoFormats(result);
    }

    static String[] convertFileToString(File file) {
        String[] digitsString = null;
        try {
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            digitsString = line.split(" ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return digitsString;
    }

    static double calculateArithmeticMean(String[] array) {
        double result = 0;

        for (int i = 0; i < array.length; i++) {
            result += Double.parseDouble(array[i]);
        }
        return result / array.length;
    }

    static void printInTwoFormats(double input) {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        otherSymbols.setDecimalSeparator(',');
        String pattern = "###0.000";

        DecimalFormat decimalFormat = new DecimalFormat(pattern,otherSymbols);
        System.out.print(input + " --> ");
        System.out.print(decimalFormat.format(input));
    }
}

