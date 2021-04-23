package day4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int sizeOfArray = enterSizeOfArray();
        int[] array = createAndFillArrayWithRandomNumbers(sizeOfArray);
        printArraySize(array);
        System.out.println(Arrays.toString(array));
        printQuantityOfNumbersMoreThenEight(array);
        printQuantityOfNumbersEqualToOne(array);
        printQuantityOfEvenNumbers(array);
        printQuantityOfOddNumbers(array);
        printSumOfAllElementsOfArray(array);
    }

    static int enterSizeOfArray() {
        Scanner inputSizeOfArray = new Scanner(System.in);
        return inputSizeOfArray.nextInt();
    }

    static int[] createAndFillArrayWithRandomNumbers(int input) {
        int[] array = new int[input];
        for (int i = 0; i < array.length; i++) {
            int min = 0;
            int max = 10;
            int diff = max - min;
            Random random = new Random();
            array[i] = random.nextInt(diff + 1) + min;
        }
        return array;
    }

    static void printArraySize(int[] array) {
        System.out.println("Длина массива: " + array.length);
    }

    static void printQuantityOfNumbersMoreThenEight(int[] array) {
        int quantityOfNumbersMoreThenEight = 0;

        for (int value : array) {
            if (value > 8)
                quantityOfNumbersMoreThenEight++;
        }
        System.out.println("Количество чисел больше 8: " + quantityOfNumbersMoreThenEight);
    }

    static void printQuantityOfNumbersEqualToOne(int[] array) {
        int quantityOfNumbersEqualToOne = 0;
        for (int value : array) {
            if (value == 1)
                quantityOfNumbersEqualToOne++;
        }
        System.out.println("Количество чисел равных 1: " + quantityOfNumbersEqualToOne);
    }

    static void printQuantityOfEvenNumbers(int[] array) {
        int quantityOfEvenNumbers = 0;
        for (int value : array) {
            if (value % 2 == 0)
                quantityOfEvenNumbers++;
        }
        System.out.println("Количество четных чисел: " + quantityOfEvenNumbers);
    }

    static void printQuantityOfOddNumbers(int[] array) {
        int quantityOfOddNumbers = 0;
        for (int value : array) {
            if (value % 2 != 0)
                quantityOfOddNumbers++;
        }
        System.out.println("Количество нечетных чисел: " + quantityOfOddNumbers);
    }

    static void printSumOfAllElementsOfArray(int[] array) {
        int sumOfAllElementsOfArray = 0;
        for (int value : array) {
            sumOfAllElementsOfArray = sumOfAllElementsOfArray + value;
        }
        System.out.println("Сумма всех элементов массива: " + sumOfAllElementsOfArray);
    }
}
