package day18;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(count7(12378787));
    }

    public static int count7(int input) {
        if (input == 0)
            return 0;
        if (input % 10 == 7) {
            return 1 + count7(input / 10);
        } else return count7(input / 10);


    }
}

