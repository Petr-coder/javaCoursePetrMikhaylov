package day12.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static day12.task3.MusicBand.BORDERLINE_YEAR;

public class Task3 {
    public static void main(String[] args) {
        List<MusicBand> musicBands = new ArrayList<>();
        musicBands.add(new MusicBand("Outkast", 1992));
        musicBands.add(new MusicBand("Linkin Park", 1996));
        musicBands.add(new MusicBand("Ramsmtein", 1994));
        musicBands.add(new MusicBand("Fall Out Boy", 2001));
        musicBands.add(new MusicBand("Sum 41", 1996));
        musicBands.add(new MusicBand("Imagine Dragons", 2008));
        musicBands.add(new MusicBand("Green day", 1986));
        musicBands.add(new MusicBand("ONEREPUBLIC", 2002));
        musicBands.add(new MusicBand("JAWS", 2012));
        musicBands.add(new MusicBand("pendulum", 2002));

        printArrayList(musicBands);
        System.out.println();
        Collections.shuffle(musicBands);
        printArrayList(groupsAfter2000(musicBands));
    }

    public static List<MusicBand> groupsAfter2000(List<MusicBand> bands) {
        List<MusicBand> result = new ArrayList<>();

        for (int i = 0; i < bands.size(); i++) {
            if (bands.get(i).getYear() > BORDERLINE_YEAR) {
                result.add(bands.get(i));
            }
        }
        return result;
    }

    private static void printArrayList(List<MusicBand> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
}

