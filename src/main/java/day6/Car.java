package day6;

public class Car {
    private int year;
    private String color;
    private String model;

    public void info() {
        System.out.println("Это автомобиль");
    }

    public int yearDifference(int inputYear) {
        int yearDifference = inputYear - this.year;
        return Math.abs(yearDifference);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int yearOfProduction) {
        this.year = yearOfProduction;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}