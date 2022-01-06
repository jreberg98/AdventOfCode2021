package no.reberg;

import java.util.ArrayList;

public class Three {

    public static int first() {
        ArrayList<String> data = Input.listOfStrings("data/3.csv");
        int[] total = new int[data.get(0).length()];

        for (String string : data) {
            String[] splitted = string.split("");
            for (int i = 0; i < splitted.length; i++) {
                if (splitted[i].equals("0")) {
                    total[i]--;
                } else {
                    total[i]++;
                }
            }
        }

        int most = 0;
        int least = 0;
        int value = 1;

        for (int i = total.length - 1; i >= 0; i--) {
            if (total[i] > 0) {
                most += value;
            } else {
                least += value;
            }
            value *= 2;
        }

        return most * least;
    }
}
