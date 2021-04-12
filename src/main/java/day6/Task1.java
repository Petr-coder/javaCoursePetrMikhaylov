package day6;

public class Task1 {
    public static void main(String[] args) {
        Car carForCurrentTask = new Car();
        carForCurrentTask.setYear(1998);
        carForCurrentTask.setColor("Red");
        carForCurrentTask.setModel("Mazda");
        carForCurrentTask.info();
        System.out.println(carForCurrentTask.yearDifference(20));
    }
}
