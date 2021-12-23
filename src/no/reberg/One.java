package no.reberg;

import java.util.ArrayList;

public class One {
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
}
