package no.reberg;

import java.util.ArrayList;

public class Day09 {
    public static int first() {
        ArrayList<ArrayList<Integer>> data = Input.dobbelListOfDigits("data/9.csv");

        for (ArrayList<Integer> array : data) {
            for (int i : array) {
                System.out.print(i);
            }
            System.out.println();
        }

        return 0;
    }
}
