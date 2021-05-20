package day19.task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Neil Alishev
 */

public class Task3 {
    private static final int MINIMUM_VALUE_COORDINATE = 0;
    private static final int MAXIMUM_VALUE_COORDINATE = 0;

    public static void main(String[] args) {

        File file = new File("src/main/resources/taxi_cars.txt");
        HashMap<Integer, Point> hashMap = writeFileToHashMap(file);
        List<Integer> listOfCoordinates = getCoordinates();
        printIDsOfCars(listOfCoordinates, hashMap);
        int count = countCarsQuantityInSquare(listOfCoordinates, hashMap);
        System.out.println("Общее количество машин в квадрате " + count);
    }

    static void printIDsOfCars(List<Integer> listOfFour, HashMap<Integer, Point> hashMap) {
        for (Map.Entry<Integer, Point> entry : hashMap.entrySet()) {
            int xCar = entry.getValue().getX();
            int yCar = entry.getValue().getY();
            if ((xCar > listOfFour.get(0) && yCar < listOfFour.get(1)) && (xCar < listOfFour.get(2) && yCar > listOfFour.get(3))) {
                System.out.println(entry.getKey());
            }
        }

    }


    static int countCarsQuantityInSquare(List<Integer> list, HashMap<Integer, Point> hashMap)
            throws IllegalArgumentException {

        if (!checkIfFigureIsSquare(list)) {
            throw new IllegalArgumentException("Фигура не является квадратом");
        }

        int count = 0;

        for (Map.Entry<Integer, Point> entry : hashMap.entrySet()) {
            int xCar = entry.getValue().getX();
            int yCar = entry.getValue().getY();
            if ((xCar > list.get(0) && yCar < list.get(1)) && (xCar < list.get(2) && yCar > list.get(3))) {
                count++;
            }
        }

        return count;
    }

    static HashMap<Integer, Point> writeFileToHashMap(File file) {
        HashMap<Integer, Point> hashMap = new HashMap<>();

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String[] interim = scanner.nextLine().split(" ");
                hashMap.put(Integer.parseInt(interim[0]), new Point(Integer.parseInt(interim[1]), Integer.parseInt(interim[2])));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Нет такого файла");
        }
        return hashMap;
    }

    static boolean checkIfFigureIsSquare(List<Integer> list) {
        Point B = new Point(list.get(0), list.get(1));
        Point D = new Point(list.get(2), list.get(3));
        Point A = new Point(B.getX(), D.getY());
        Point C = new Point(D.getX(), B.getY());

        int d2 = distSq(A, B);
        int d3 = distSq(A, C);
        int d4 = distSq(A, D);

        if (d2 == 0 || d3 == 0 || d4 == 0)
            return false;

        if (d2 == d3 && 2 * d2 == d4
                && 2 * distSq(B, D) == distSq(B, C)) {
            return true;
        }

        if (d3 == d4 && 2 * d3 == d2
                && 2 * distSq(C, B) == distSq(C, D)) {
            return true;
        }
        if (d2 == d4 && 2 * d2 == d3
                && 2 * distSq(B, C) == distSq(B, D)) {
            return true;
        }

        return false;
    }

    static int distSq(Point p, Point q) {
        return (p.getX() - q.getX()) * (p.getX() - q.getX()) + (p.getY() - q.getY()) * (p.getY() - q.getY());
    }

    static List<Integer> getCoordinates() {
        System.out.println("Введите координаты двух точек квадрата, расположенных по диагонали друг от друга");

        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList();

        int count = 0;

        while (scanner.hasNextLine()) {
            int interim = Integer.parseInt(scanner.nextLine());

            if (interim < MINIMUM_VALUE_COORDINATE || interim > MAXIMUM_VALUE_COORDINATE) {
                System.out.println("Аргумент не может быть меньше " + MINIMUM_VALUE_COORDINATE + "и больше "
                        + MAXIMUM_VALUE_COORDINATE + ". Введите еще раз целочисленное число");
            } else {
                list.add(interim);
                count++;
            }

            if (count == 4) {
                break;
            }
        }
        scanner.close();

        return list;
    }
}

