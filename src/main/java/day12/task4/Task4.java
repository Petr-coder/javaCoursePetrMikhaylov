package day12.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static day12.task4.MusicBand.transferMembers;

public class Task4 {
    public static void main(String[] args) {
        List<MusicBand> bandsList = new ArrayList<>();
        bandsList.add(new MusicBand("Outkast", 1992, new ArrayList<>(Arrays.asList("André \"3000\" Benjamin", "Antwan \"Big Boi\" Patton"))));
        bandsList.add(new MusicBand("Linkin Park", 1996, new ArrayList<>(Arrays.asList("Whatever", "Whatever"))));
        bandsList.add(new MusicBand("Ramsmtein", 1994, new ArrayList<>(Arrays.asList("Whatever", "Whatever"))));
        bandsList.add(new MusicBand("Fall Out Boy", 2001, new ArrayList<>(Arrays.asList("Whatever", "Whatever"))));
        bandsList.add(new MusicBand("Sum 41", 1996, new ArrayList<>(Arrays.asList("Whatever", "Whatever"))));
        bandsList.add(new MusicBand("Imagine Dragons", 2008, new ArrayList<>(Arrays.asList("Whatever", "Whatever"))));
        bandsList.add(new MusicBand("Green day", 1986, new ArrayList<>(Arrays.asList("Whatever", "Whatever"))));
        bandsList.add(new MusicBand("ONEREPUBLIC", 2002, new ArrayList<>(Arrays.asList("Whatever", "Whatever"))));
        bandsList.add(new MusicBand("JAWS", 2012, new ArrayList<>(Arrays.asList("Whatever", "Whatever"))));
        bandsList.add(new MusicBand("Pendulum", 2002, new ArrayList<>(Arrays.asList("Whatever", "Whatever"))));

        System.out.println("Участики в первой группе до ");
        bandsList.get(0).printMembers();
        System.out.println();
        System.out.println("Участики во второй группе до");
        bandsList.get(1).printMembers();
        System.out.println();
        transferMembers(bandsList.get(0), bandsList.get(1));
        System.out.println("Участики в первой группе после");
        bandsList.get(0).printMembers();
        System.out.println("Участики во второй группе после");
        bandsList.get(1).printMembers();
        System.out.println();


    }
}
