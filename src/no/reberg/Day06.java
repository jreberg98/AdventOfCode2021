package no.reberg;

import java.util.ArrayList;

public class Day06 {
    public static int first () {
        ArrayList<Integer> data = Input.intsSeparatedByComma("data/6.csv");

        int newFish;
        for (int i = 0; i < 80; i++) {
            // Subtracts 1 from each fish
            for (int j = 0; j < data.size(); j++) {
                data.set(j, data.get(j) - 1);
            }

            // Checks how many new fish there should be
            newFish = 0;
            for (int j = 0; j < data.size(); j++) {
                if (data.get(j) == -1) {
                    newFish++;
                    data.set(j, 6);
                }
            }

            // Adds fish
            for (int j = 0; j < newFish; j++) {
                data.add(8);
            }
        }

        return data.size();
    }

    public static long second () {
        ArrayList<Integer> data = Input.intsSeparatedByComma("data/6.csv");

        long[] fish = new long[10];

        for (int i : data) {
            fish[i]++;
        }

        for (int i = 0; i < 256; i++) {
            fish[9] = fish[0];
            fish[7] += fish[0];

            for (int j = 1; j < fish.length; j++) {
                fish[j -1] = fish[j];
            }
            fish[9] = 0;
        }

        long counter = 0;
        for (long i : fish) {
            counter += i;
        }

        return counter;


    }
}
