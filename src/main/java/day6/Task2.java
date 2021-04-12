package day6;

public class Task2 {
    public static void main(String[] args) {
        Airplane airplaneForCurrentTask = new Airplane("Boing", 2020, 100, 10000);
        airplaneForCurrentTask.setYear(2021);
        airplaneForCurrentTask.setLength(99);
        airplaneForCurrentTask.fillUp(11);
        airplaneForCurrentTask.fillUp(33);
        airplaneForCurrentTask.info();
    }
}
