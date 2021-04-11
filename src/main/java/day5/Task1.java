package day5;

public class Task1 {
    public static void main(String[] args) {
        Car carForCurrentTask = new Car();
        carForCurrentTask.setYearOfProduction(1998);
        carForCurrentTask.setColor("Red");
        carForCurrentTask.setModel("Mazda");

        System.out.println(carForCurrentTask.getYearOfProduction());
        System.out.println(carForCurrentTask.getColor());
        System.out.println(carForCurrentTask.getModel());
    }


}
