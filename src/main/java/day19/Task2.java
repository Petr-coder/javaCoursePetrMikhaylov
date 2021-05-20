package day19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
 * @author Neil Alishev
 */
public class Task2 {
    final static int LOWER_LIMIT = 500_000_000;
    final static int UPPER_LIMIT = 600_000_000;

    public static void main(String[] args) {

        File file = new File("src/main/resources/numbers19.txt");


        long start = System.currentTimeMillis();
        Set<Integer> set = writeFileToHashset(file);
        int countOfNumbersSet = countNumbersInRangeInSet(LOWER_LIMIT, UPPER_LIMIT, set);
        long end = System.currentTimeMillis();

        System.out.println(countOfNumbersSet);

        long start2 = System.currentTimeMillis();
        List<Integer> list = writeFileToList(file);
        int countOfNumbersList = countNumbersInRangeInList(LOWER_LIMIT, UPPER_LIMIT, list);
        long end2 = System.currentTimeMillis();

        System.out.println(countOfNumbersList);

        System.out.println("Замер времени работы программы через HashSet " + (end - start));
        System.out.println("Замер времени работы программы через List " + (end2 - start2));
        //Таки ArrayList даже быстрее получается. Или я не так понял задачу?
    }

    static Set<Integer> writeFileToHashset(File file) {
        Set<Integer> set = new HashSet<>();

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                set.add(Integer.parseInt(scanner.nextLine()));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Нет такого файла");
        }
        return set;
    }

    static Integer countNumbersInRangeInSet(int start, int end, Set<Integer> set) {
        int count = 0;

        Iterator<Integer> itr = set.iterator();

        while (itr.hasNext()) {
            int node = itr.next();

            if (node >= start && node <= end) {
                count++;
            }
        }
        return count;
    }

    static List<Integer> writeFileToList(File file) {
        List<Integer> list = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                list.add(Integer.parseInt(scanner.nextLine()));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Нет такого файла");
        }
        return list;
    }

    static Integer countNumbersInRangeInList(int start, int end, List<Integer> list) {
        int count = 0;


        for (Integer color : list) {
            if (color >= start && color <= end) {
                count++;
            }
        }

        return count;
    }
}
