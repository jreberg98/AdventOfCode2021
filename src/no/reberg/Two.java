package no.reberg;

import java.util.ArrayList;

public class Two {

    public static int first() {
        ArrayList<ArrayList<String>> data = Input.listOfStrings("data/2-1.csv");

        int depth = 0;
        int forward = 0;

        for (ArrayList<String> array : data) {
            switch (array.get(0)) {
                case "forward":
                    forward += Integer.parseInt(array.get(1));
                    break;
                case "up":
                    depth -= Integer.parseInt(array.get(1));
                    break;
                case "down":
                    depth += Integer.parseInt(array.get(1));
                    break;
                default:
                    System.out.println("Switch feilet: " + array);
            }
        }

        return depth * forward;
    }
}