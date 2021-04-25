package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

    }

    public static List<Person> parseFileToObjList(File file) {
        List<Person> personList = new ArrayList<>();
        try {
            String[] persons = changeFromFileToString(file).split(" ");
            if (checkIfArrayContainsNegativeNumbers(persons)) {
                throw new IncorrectInputFileException();
            } else {
                for (int i = 0; i < persons.length - 1; i = i + 2) {
                    personList.add(new Person(persons[i], Integer.parseInt(persons[i + 1])));
                }
            }

        } catch (IncorrectInputFileException e) {
            System.out.println("Некорректный входной файл");
        } finally {
            return personList;
        }
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

    static String changeFromFileToString(File file) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
         } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        StringBuilder line = new StringBuilder();

        while (scanner.hasNextLine()) {
            line.append(scanner.nextLine()).append(" ");
        }
        scanner.close();
        return line.toString();
    }
}
