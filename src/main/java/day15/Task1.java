package day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws IOException {
        File fileInput = new File("src/main/resources/shoes.csv");
        File fileOutput = new File("src/main/resources/missing_shoes.txt");
        fileOutput.getParentFile().mkdirs();
        Scanner scanner = null;
        PrintWriter printWriter = new PrintWriter(fileOutput);

        try {
            scanner = new Scanner(fileInput);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] product = line.split(";");

                if (Integer.parseInt(product[2]) == 0) {
                    printWriter.println(product[0] + ", " + product[1] + ", " + product[2]);
                }
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
