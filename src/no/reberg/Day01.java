package no.reberg;

import java.util.ArrayList;

public class Day01 {
    public static int first (){
        ArrayList<Integer> data = Input.listOfInts("data/1-1.csv");

        int counter = 0;
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i - 1) < data.get(i)) {
                counter++;
            }
        }
        return counter;
    }

    public static int second () {
        ArrayList<Integer> data = Input.listOfInts("data/1-1.csv");

        int counter = 0;

        for (int i = 3; i < data.size(); i++) {
            if ((data.get(i - 1) + data.get(i - 2) + data.get(i - 3))
                    < (data.get(i) + data.get(i - 1) + data.get(i - 2))) {
                counter++;
            }
        }

        return counter;
    }
}
