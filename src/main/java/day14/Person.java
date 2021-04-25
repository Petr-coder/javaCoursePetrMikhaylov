package day14;

public class Person {
    String name;
    int year;

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public Person(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return "{name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
