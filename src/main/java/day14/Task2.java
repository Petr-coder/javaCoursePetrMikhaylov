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
        String line = "";
        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                line += scanner.nextLine() + " ";
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        scanner.close();
        return line;
    }

    static boolean checkIfArrayContainsNegativeNumbers(String[] strings) { //Принимаем String массив, чередующий имена и возраст

        for (int i = 1; i < strings.length - 1; i = i + 2) {               //перебираем массив, каждое второе значение массива должно быть возрастом
            if (Integer.parseInt(strings[i]) < 0) {                        //String'овый возраст переводим в int
                return true;                                               //Если возраст меньше нуля - возвращаем "true"
            }                                                              //"true" в методе parseFileToStringList вызывает IncorrectInputFileException
        }
        return false;
    }
}