package day6;

public class Task3 {
    public static void main(String[] args) {
        Teacher teacherForCurrentTask = new Teacher("Евгений Вазгенович", "Матан");
        Student studentForCurrentTask = new Student("Егорка");

        teacherForCurrentTask.evaluate(studentForCurrentTask);
    }
}
