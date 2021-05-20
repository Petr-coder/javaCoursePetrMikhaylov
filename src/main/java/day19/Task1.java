package day19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Neil Alishev
 */

public class Task1 {
    final static int NUMBER_OF_FREQUENTLY_USED_WORDS = 100;

    public static void main(String[] args) {

        File file = new File("src/main/resources/dushi.txt");
        String[] words = convertFileToString(file);

        Map<String, Integer> map = convertStringToHashMap(words);
        List<Map.Entry<String, Integer>> listOfWOrds = convertToReverseValueList(map);

        printMaximumValues(NUMBER_OF_FREQUENTLY_USED_WORDS, listOfWOrds);
        System.out.println("В произведении слово \"Чичиков\" было использовано " + map.get("Чичиков") + " раз");

    }

    static List<Map.Entry<String, Integer>> convertToReverseValueList(Map<String, Integer> map) {
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(
                set);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        return list;
    }

    static void printMaximumValues(int quantity, List<Map.Entry<String, Integer>> list) {
        int count = 1;
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            count++;

            if (count == quantity + 1) {
                break;
            }
        }
    }

    static Map<String, Integer> convertStringToHashMap(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int count = 1;

        for (String x : words) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, count);
            }
        }
        return map;
    }


    static String[] convertFileToString(File file) {
        String[] result = null;

        try (Scanner scanner = new Scanner(file)) {
            String interim = "";

            while (scanner.hasNextLine()) {
                interim = interim + scanner.nextLine();
            }

            result = interim.split("[.,:;()?!\"\\s–]+");
        } catch (FileNotFoundException e) {
            System.out.println("Нет такого файла");
        }

        return result;
    }
}
