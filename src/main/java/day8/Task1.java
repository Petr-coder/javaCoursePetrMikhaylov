package day8;

public class Task1 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        String viaStringBuilder = generateStringInSpecifiedRangeWithStringBuilder(0, 20000);
        long end = System.currentTimeMillis();
        System.out.println(viaStringBuilder);


        long start2 = System.currentTimeMillis();
        String viaString = generateStringInSpecifiedRangeWithString(0, 20000);
        long end2 = System.currentTimeMillis();
        System.out.println(viaString);

        System.out.println("Замер времени работы программы через StringBuilder " + (end - start));
        System.out.println("Замер времени работы программы через String " + (end2 - start2));
    }


    static String generateStringInSpecifiedRangeWithStringBuilder(int initial, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = initial; i < end + 1; i++) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    static String generateStringInSpecifiedRangeWithString(int initial, int end) {
        StringBuilder string = new StringBuilder(new String());
        for (int i = initial; i < end + 1; i++) {
            string.append(" ").append(i);
        }
        return string.toString();
    }
}