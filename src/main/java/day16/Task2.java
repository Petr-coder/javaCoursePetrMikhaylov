package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int[] data = createArrayWithNumbers(1000, 0, 100);
        File file1 = createTXTFile(data);
        File file2 = calculateToNewFile(file1, "src/main/resources/file2.txt");
        printResult(file2);

    }

    public static void printResult(File file) {
        String[] product = null;
        double sum = 0;
        try (Scanner scanner = new Scanner(file);
        ) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                product = line.split(" ");
            }

            for (int i = 0; i < product.length; i++) {
                sum += Double.parseDouble(product[i]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println((int) sum);
    }

    static File createTXTFile(int[] data) {
        File fileTXT1 = new File("src/main/resources/file1.txt");
        fileTXT1.getParentFile().mkdirs();


        try (PrintWriter printWriter = new PrintWriter(fileTXT1);) {


            for (int datum : data) {
                printWriter.print(datum + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileTXT1;
    }

    static int[] createArrayWithNumbers(int arraysSize, int min, int max) {
        int[] array = new int[arraysSize];
        for (int i = 0; i < array.length; i++) {
            int diff = max - min;
            Random random = new Random();
            array[i] = random.nextInt(diff + 1) + min;
        }
        return array;
    }

    static File calculateToNewFile(File fileInput, String pathname) throws NullPointerException {
        int arraySize = 1000;
        int interval = 20;

        File fileTXT2 = new File(pathname);
        fileTXT2.getParentFile().mkdirs();

        try (Scanner scanner = new Scanner(fileInput); PrintWriter printWriter = new PrintWriter(fileTXT2)) {
            String[] product = null;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                product = line.split(" ");
            }


            for (int i = 0; i < arraySize - interval; i = i + interval) {
                int sum = 0;
                for (int j = 0; j < interval; j++) {
                    if (product != null) {
                        sum += Double.parseDouble(product[j]);
                    }
                }
                printWriter.print(sum);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return fileTXT2;
    }
}

