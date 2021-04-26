package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("test2");
        int sunOfNumbers = printSumDigits(file);
        System.out.println(sunOfNumbers);
    }

    public static int printSumDigits(File file) {
        int result = 0;
        try {
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            String[] digitsString = line.split(" ");


            if (digitsString.length != 10) {
                throw new IncorrectInputFileException();
            }

            for (String digitString : digitsString) {
                result += Integer.parseInt(digitString);
            }
            scanner.close();
           } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IncorrectInputFileException e) {
            System.out.println("Некорректный входной файл");
        }
        return result;
    }
}

