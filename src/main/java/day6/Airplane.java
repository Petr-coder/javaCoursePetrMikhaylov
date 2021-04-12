package day6;

public class Airplane {
    private String producer;

    private int year;
    private int length;
    private int weight;
    int fuel;


    public Airplane(String producer, int year, int length, int weight) {
        this.producer = producer;
        this.year = year;
        this.length = length;
        this.weight = weight;
        this.fuel = 0;
    }

    public int getFuel() {
        return fuel;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void fillUp (int n){
        this.fuel = this.fuel + n;
    }
    public void info() {
        System.out.println("Изготовитель: " + this.producer + "," + " год выпуска: " + this.year + "," + " длина: " + this.length + "," + " вес: " + this.weight  + "," + " количество топлива в баке: " + this.fuel);
    }
}
