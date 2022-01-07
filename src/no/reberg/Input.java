package no.reberg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static ArrayList<ArrayList<String>> listOfListOfStrings(String fileName) {
        File file = new File(fileName);

        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            ArrayList<String> temp;

            while (scanner.hasNext()) {
                temp = new ArrayList<>();
                String line = scanner.nextLine();
                String[] splitted = line.split(" ");

                temp.addAll(Arrays.asList(splitted));

                arrayList.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return arrayList;
    }

    public static ArrayList<String> listOfStrings(String fileName) {
        File file = new File(fileName);
        ArrayList<String> arrayList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            String temp;

            while (scanner.hasNextLine()) {
                temp = scanner.nextLine();
                arrayList.add(temp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return arrayList;
    }
}
