package no.reberg;

import java.util.ArrayList;

public class Day03 {

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

    public static int second() {
        ArrayList<String> data = Input.listOfStrings("data/3.csv");
        ArrayList<String> oxygenData = new ArrayList<>(data);
        ArrayList<String> co2Data = new ArrayList<>(data);

        for (int i = 0; i < data.get(0).length(); i++) {

            if (oxygenData.size() > 1) {
                int oxySwing = 0;

                // Sjekker hva som er vanligst
                for (String string : oxygenData) {
                    if (string.charAt(i) == '0') {
                        oxySwing--;
                    } else {
                        oxySwing++;
                    }
                }

                // Fjerner elementer
                for (String string : data) {
                    if (oxySwing < 0) {
                        if (string.charAt(i) == '0') {
                            oxygenData.remove(string);
                        }
                    } else {
                        if (string.charAt(i) == '1') {
                            oxygenData.remove(string);
                        }
                    }
                }
            }

            if (co2Data.size() > 1) {
                int co2Swing = 0;

                for (String string : co2Data) {
                    if (string.charAt(i) == '0') {
                        co2Swing--;
                    } else {
                        co2Swing++;
                    }
                }

                for (String string : data) {
                    if (co2Swing < 0) {
                        if (string.charAt(i) == '1') {
                            co2Data.remove(string);
                        }
                    } else {
                        if (string.charAt(i) == '0') {
                            co2Data.remove(string);
                        }
                    }
                }
            }
        }

        int oxygen = binaryToDecimal(oxygenData.get(0));
        int co2 = binaryToDecimal(co2Data.get(0));

        return oxygen * co2;
    }

    private static int binaryToDecimal(String binary) {
        int temp = 0;
        int counter = 1;

        String[] array = binary.split("");

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i].equals("1")) {
                temp += counter;
            }
            counter *= 2;
        }

        return temp;
    }
}
