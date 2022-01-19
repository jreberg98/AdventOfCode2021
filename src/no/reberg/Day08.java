package no.reberg;

import java.util.ArrayList;

public class Day08 {
    public static int first() {
        ArrayList<String> data = Input.listOfStrings("data/8.csv");
        ArrayList<String> output = new ArrayList<>();

        for (String string : data) {
            output.add(string.split(" \\| ")[1]);
        }

        int count = 0;

        for (String string : output) {
            String[] strings = string.split(" ");
            for (String temp : strings) {
                if (temp.length() == 2 | temp.length() == 4 | temp.length() == 3 | temp.length() == 7) {
                    count++;
                }
            }
        }

        return count;
    }
}
