package day18;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(count7(12378787));
    }

    public static int count7(int input) {
        int count = 0;

        if (input == 0)
            return count;

        if (input % 10 == 7)
            count = count + 1;

        input = input / 10;
        return count = count + count7(input);

    }
}

