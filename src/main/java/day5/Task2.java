package day5;


public class Task2 {
    public static void main(String[] args) {
        Motorcycle motorcycleForCurrentTask = new Motorcycle(1998, "Black", "Harley-Davidson");
        System.out.println(motorcycleForCurrentTask.getColor());
        System.out.println(motorcycleForCurrentTask.getModel());
        System.out.println(motorcycleForCurrentTask.getYearOfProduction());
    }
}
