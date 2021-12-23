package no.reberg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    public static ArrayList<Integer> listOfInts(String fileName) {
        File file = new File(fileName);

        ArrayList<Integer> arrayList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            String temp;


            while (scanner.hasNext()) {
                temp = scanner.next();
                arrayList.add(Integer.parseInt(temp));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return arrayList;
    }
}
