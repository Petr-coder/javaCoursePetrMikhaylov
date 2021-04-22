package day12.task3;

public class MusicBand {

    private String name;
    private int year;

    private static final int BORDERLINE_YEAR = 2000;

    public static int getBorderlineYear() {
        return BORDERLINE_YEAR;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public MusicBand(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return name +
                ", " + year;
    }
}
