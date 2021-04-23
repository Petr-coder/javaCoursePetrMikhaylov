package day12;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Audi");
        list.add("BMW");
        list.add("Lada");
        list.add("Tesla");
        list.add("Lamborghini");

        printList(list);

        System.out.println();
        list.add(3, "Toyota");
        list.remove(0);

        printList(list);
    }


    static void printList(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }


}
