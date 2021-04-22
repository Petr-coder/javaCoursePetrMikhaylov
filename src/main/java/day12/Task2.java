package day12;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        createListFilledWithEvenNumbersWithTwoRanges(list, 0, 30, 300, 350);
        printList(list);


    }

    static void createListFilledWithEvenNumbersWithTwoRanges(List<Integer> list, int first, int second, int third, int fourth) {
        for (int i = first; i < fourth + 1; i++) {
            if (i == second + 1) {
                i = third;
            }
            if (i % 2 == 0) {
                list.add(i);
            }
        }
    }

    static void printList(List<Integer> list) {
        for (int i : list) {
            System.out.println(i);
        }
    }
}
