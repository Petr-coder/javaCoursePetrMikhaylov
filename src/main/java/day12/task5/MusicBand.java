package day12.task5;

import java.util.List;

public class MusicBand {

    private String name;
    private int year;
    private List<MusicArtist> members;

    static final int BORDERLINE_YEAR = 2000;

    public MusicBand(String name, int year, List<MusicArtist> members) {
        this.name = name;
        this.year = year;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public List<MusicArtist> getMembers() {
        return members;
    }

    public void printMembers() {
        for (int i = 0; i < getMembers().size(); i++) {
            System.out.println(getMembers().get(i));
        }

    }

    public static void transferMembers(MusicBand band1, MusicBand band2) {
        band2.getMembers().addAll(0, band1.getMembers());
        band1.getMembers().clear();
    }

    @Override
    public String toString() {
        return name +
                ", " + year;
    }
}
