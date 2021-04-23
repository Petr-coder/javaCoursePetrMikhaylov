package day6;

class Motorcycle {
    private int yearOfProduction;
    private String color;
    private String model;

    void info(){
        System.out.println("Это мотоцикл");
    }

    int yearDifference(int inputYear){
        int yearDifference = inputYear - this.yearOfProduction;
        return Math.abs(yearDifference);
    }

     Motorcycle(int yearOfProduction, String color, String model) {
        this.yearOfProduction = yearOfProduction;
        this.color = color;
        this.model = model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }
}