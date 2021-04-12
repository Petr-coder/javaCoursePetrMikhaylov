package day4;

import java.util.Arrays;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        int[] array = createAndFillArrayWithRandomNumbers(100);
        System.out.println(Arrays.toString(array));
        System.out.println(findMaximumAmongSumsOfThreeNeighboringElements(array));
        System.out.println(findFirstIndexOfThreeNeighboringElementsWithMaximumSize(array));
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

    static int findMaximumAmongSumsOfThreeNeighboringElements(int[] array) {
        int sumOfThreeNeighboringElements = array[0] + array[1] + array[2];

        for (int i = 0; i < array.length - 2; i++) {
            if ((array[i] + array[i + 1] + array[i + 2]) > sumOfThreeNeighboringElements) {
                sumOfThreeNeighboringElements = array[i] + array[i + 1] + array[i + 2];
            }
        }
        return sumOfThreeNeighboringElements;
    }

    static int findFirstIndexOfThreeNeighboringElementsWithMaximumSize(int[] array) {
        int sumOfThreeNeighboringElements = array[0] + array[1] + array[2];
        int firstIndexOfThreeNeighboringElementsWithMaximumSize = 0;
        for (int i = 0; i < array.length - 2; i++) {
            if ((array[i] + array[i + 1] + array[i + 2]) > sumOfThreeNeighboringElements) {
                sumOfThreeNeighboringElements = array[i] + array[i + 1] + array[i + 2];
                firstIndexOfThreeNeighboringElementsWithMaximumSize = i;
            }
        }
        return firstIndexOfThreeNeighboringElementsWithMaximumSize;
    }
}
