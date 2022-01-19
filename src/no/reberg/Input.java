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
                String line = scanner.nextLine();
                String[] splitted = line.split(" ");

                temp = new ArrayList<>(Arrays.asList(splitted));

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

    public static ArrayList<Integer> intsSeparatedByComma(String fileName) {
        ArrayList<Integer> temp = new ArrayList<>();

        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);

            String string = scanner.next();

            String[] strings = string.split(",");

            for (String s : strings) {
                temp.add(Integer.parseInt(s));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return temp;
    }

    public static ArrayList<ArrayList<Integer>> dobbelListOfDigits(String fileName) {
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();

        File file = new File(fileName);

        try {
            Scanner scanner = new Scanner(file);


            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                ArrayList<Integer> current = new ArrayList<>();
                String[] strings = string.split("");
                for (String s : strings) {
                    current.add(Integer.parseInt(s));
                }
                temp.add(current);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return temp;
    }
}
