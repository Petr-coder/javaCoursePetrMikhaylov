package day4;

import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int[][] arrayForTask = new int[12][8];
        arrayForTask = fillArray(arrayForTask);

        System.out.println(Arrays.deepToString(arrayForTask));
        printIndexOfLineWithMaximumSumOfLine(arrayForTask);
    }

    static int[][] fillArray(int[][] array) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 8; j++) {
                int min = 0;
                int max = 5;
                int diff = max - min;
                Random random = new Random();
                array[i][j] = random.nextInt(diff + 1) + min;
            }
        }
        return array;
    }

    static void printIndexOfLineWithMaximumSumOfLine(int[][] array) {

        int[] arraySumLine = new int[12];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 8; j++) {
                arraySumLine[i] = arraySumLine[i] + array[i][j];
            }
        }
        System.out.println(findIndexWithMaximumAmount(arraySumLine));
    }

    static int findIndexWithMaximumAmount(int[] array) {
        int indexOfLineWithMaximumSumOfLine = 0;
        int sumOfLine = 0;

        for (int j = 0; j < array.length; j++) {
            if (array[j] >= sumOfLine) {
                indexOfLineWithMaximumSumOfLine = j;
                sumOfLine = array[j];
            }
        }
        return indexOfLineWithMaximumSumOfLine;
    }
}

