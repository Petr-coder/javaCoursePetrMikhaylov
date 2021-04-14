package day4;

import java.util.Arrays;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        int[] array = createAndFillArrayWithRandomNumbers(100);
        System.out.println(Arrays.toString(array));
        System.out.println(findMaximumAmongSumsOfNeighboringElements(array, 3));
        System.out.println(findFirstIndexOfNeighboringElementsWithMaximumSize(array, 3));
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

    static int findMaximumAmongSumsOfNeighboringElements(int[] array, int amountOfElements) {
        int sum = 0;
        int maximumSum = 0;

        for (int i = 0; i < array.length - (amountOfElements - 1); i++) {

            for (int j = i; j < i + amountOfElements ; j++) {
                sum += array[j];
            }

            if (sum > maximumSum) {
                maximumSum = sum;
            }
            sum = 0;
        }
        return maximumSum;
    }

    static int findFirstIndexOfNeighboringElementsWithMaximumSize(int[] array, int amountOfElements) {
        int sum = 0;
        int maximimSum = 0;
        int firstIndex = 0;

        for (int i = 0; i < array.length - (amountOfElements - 1); i++) {

            for (int j = i; j < i + amountOfElements; j++) {
                sum += array[j];
            }

            if (sum > maximimSum) {
                maximimSum = sum;
                firstIndex = i;
            }
            sum = 0;
        }
        return firstIndex;
    }
}
