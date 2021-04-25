package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        File file = new File("people");
        System.out.println(parseFileToStringList(file).toString());
    }

    public static List<String> parseFileToStringList(File file) {
        List<String> result = new ArrayList<>();
        //noinspection finally
        try {
            String[] persons = changeFromFileToString(file).split(" ");
            if (checkIfArrayContainsNegativeNumbers(persons)) {
                throw new IncorrectInputFileException();
            } else {
                for (int i = 0; i < persons.length - 1; i = i + 2) {
                    result.add(persons[i] + " " + persons[i + 1]);
                }
            }

        } catch (IncorrectInputFileException e) {
            System.out.println("Некорректный входной файл");
        } finally {
            return result;
        }
    }

    static String changeFromFileToString(File file) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        String line = "";

        while (scanner.hasNextLine()) {
            line += scanner.nextLine() + " ";
        }
        scanner.close();
        return line;
    }

    static boolean checkIfArrayContainsNegativeNumbers(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            if (i % 2 != 0) {
                if (Integer.parseInt(strings[i]) < 0) {
                    return true;
                }
            }
        }
        return false;
    }
}