package day12.task5;

public class MusicArtist {
    private String firstAndLastName;
    int age;

    public MusicArtist(String firstAndLastName, int age) {
        this.firstAndLastName = firstAndLastName;
        this.age = age;
    }

    public String getFirstAndLastName() {
        return firstAndLastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return firstAndLastName +
                ", " + age;
    }
}

