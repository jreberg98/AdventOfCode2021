package no.reberg;

import java.util.ArrayList;

public class Day07 {
    public static int first () {
        ArrayList<Integer> data = Input.intsSeparatedByComma("data/7.csv");

        int least = Integer.MAX_VALUE;
        int temp;

        for (int i = 0; i < 1500; i++) {
            temp = 0;
            for (int current : data) {
                temp += Math.abs(current - i);
            }
            if (temp < least) {
                least = temp;
            }
        }

        return least;
    }

    public static int second() {
        ArrayList<Integer> data = Input.intsSeparatedByComma("data/7.csv");

        int least = Integer.MAX_VALUE;
        int temp;

        for (int i = 0; i < 1500; i++) {
            temp = 0;
            for (int current : data) {
                temp += fuelCost(current, i);
            }
            if (temp < least) {
                least = temp;
            }
        }

        return least;
    }

    private static int fuelCost(int a, int b) {
        if (a == b) {
            return 0;
        }

        int diff = Math.abs(a - b);
        int total = 0;
        for (int i = 0; i <= diff; i++) {
            total += i;
        }

        return total;
    }
}
