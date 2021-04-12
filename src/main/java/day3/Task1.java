package day3;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String city = scanner.nextLine();

            switch (city) {
                case "Москва":
                case "Владивосток":
                case "Ростов":
                    System.out.println("Россия");
                    continue;
                case "Рим":
                case "Милан":
                case "Турин":
                    System.out.println("Италия");
                    continue;
                case "Ливерпуль":
                case "Манчестер":
                case "Лондон":
                    System.out.println("Англия");
                    continue;
                case "Берлин":
                case "Мюнхен":
                case "Кёльн":
                    System.out.println("Германия");
                    continue;
                case "Stop":
                    break;
                default:
                    System.out.println("Неизвестная страна");
                    continue;
            }
            break;
        }
    }
}
