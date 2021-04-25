package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("test2");
        printSumDigits(file);
    }

    public static void printSumDigits(File file) {
        try {
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            String[] digitsString = line.split(" ");
            int result = 0;

            if (digitsString.length != 10) {
                throw new IncorrectInputFileException();
            }

            for (String digitString : digitsString) {
                result += Integer.parseInt(digitString);
            }
            scanner.close();
            System.out.println(result);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IncorrectInputFileException e) {
            System.out.println("Некорректный входной файл");
        }
    }
}
