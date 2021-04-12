package day4;

import java.util.Arrays;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {

        int[] array = createAndFillArrayWithRandomNumbers(100);
        System.out.println(Arrays.toString(array));
        printLargestElementOfArray(array);
        printSmallestElementOfArray(array);
        printNumberOfArrayElementsEndingWithZero(array);
        printSumOfArrayElementsEndingWithZero(array);
    }

    static int[] createAndFillArrayWithRandomNumbers(int input) {
        int[] array = new int[input];
        for (int i = 0; i < array.length; i++) {
            int min = 0;
            int max = 10000;
            int diff = max - min;
            Random random = new Random();
            array[i] = random.nextInt(diff + 1) + min;
        }
        return array;
    }


    static void printLargestElementOfArray(int[] array) {
        int largestElementOfArray = 0;
        for (int num : array) {
            if (num > largestElementOfArray)
                largestElementOfArray = num;
        }
        System.out.println("Наибольший элемент массива: " + largestElementOfArray);
    }

    static void printSmallestElementOfArray(int[] array) {
        int smallestElementOfArray = array[0];
        for (int num : array) {
            if (num < smallestElementOfArray)
                smallestElementOfArray = num;
        }
        System.out.println("Наименьший элемент массива: " + smallestElementOfArray);
    }

    static void printNumberOfArrayElementsEndingWithZero(int[] array) {
        int numberOfArrayElementsEndingWithZero = 0;
        for (int num : array) {
            if (num % 10 == 0)
                numberOfArrayElementsEndingWithZero++;
        }
        System.out.println("Количество элементов массива, оканчивающихся на 0: " + numberOfArrayElementsEndingWithZero);
    }

    static void printSumOfArrayElementsEndingWithZero(int[] array) {
        int sumOfArrayElementsEndingWithZero = 0;
        for (int num : array) {
            if (num % 10 == 0)
                sumOfArrayElementsEndingWithZero = sumOfArrayElementsEndingWithZero + num;
        }
        System.out.println("Сумма элементов массива, оканчивающихся на 0: " + sumOfArrayElementsEndingWithZero);
    }
}
