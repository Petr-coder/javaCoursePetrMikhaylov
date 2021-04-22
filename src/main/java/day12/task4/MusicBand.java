package day12.task4;

import java.util.List;

public class MusicBand {

    private String name;
    private int year;
    private List<String> members;

    private static final int BORDERLINE_YEAR = 2000;

    public MusicBand(String name, int year, List<String> members) {
        this.name = name;
        this.year = year;
        this.members = members;
    }

    public static int getBorderlineYear() {
        return BORDERLINE_YEAR;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public List<String> getMembers() {
        return members;
    }

    void printMembers() {
        for (int i = 0; i < getMembers().size(); i++) {
            System.out.println(getMembers().get(i));
        }

    }

    public static void transferMembers(MusicBand band1, MusicBand band2) {
        for (int i = band1.getMembers().size() - 1; i >= 0; i--) {
            band2.getMembers().add(band1.getMembers().get(i));
            band1.getMembers().remove(i);
        }
    }

    @Override
    public String toString() {
        return name +
                ", " + year;
    }
}
