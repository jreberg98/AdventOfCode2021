package no.reberg;

import java.util.ArrayList;

public class Day05 {
    public static int first() {
        // Data input
        ArrayList<String> data = Input.listOfStrings("data/5.csv");
        ArrayList<int[]> pairs = new ArrayList<>();
        for (String string : data) {
            pairs.add(split(string));
        }

        // "Map" to be updated
        int[][] map = new int[1000][1000];

        // Updating the map with data from the pairs
        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i)[0] == pairs.get(i)[2]) {
                int[] current = pairs.get(i);

                if (current[1] < current[3]) {
                    for (int j = current[1]; j <= current[3]; j++) {
                        map[j][current[0]]++;
                    }
                } else {
                    for (int j = current[3]; j <= current[1]; j++) {
                        map[j][current[0]]++;
                    }
                }


            } else if (pairs.get(i)[1] == pairs.get(i)[3]){
                int[] current = pairs.get(i);

                if (current[0] < current[2]) {
                    for (int j = current[0]; j <= current[2]; j++) {
                        map[current[1]][j]++;
                    }
                } else {
                    for (int j = current[2]; j <= current[0]; j++) {
                        map[current[1]][j]++;
                    }
                }
            }
        }


        // Calculating total
        int counter = 0;
        for (int[] row : map) {
            for (int i : row) {
                if (i > 1) {
                    counter++;
                }
            }
        }

        return counter;
    }

    public static int second() {
        // Eget forsøk kommentert ut
        // Løsning funnet fra https://github.com/akaritakai/AdventOfCode2021/blob/main/src/main/java/net/akaritakai/aoc2021/Puzzle05.java 12/01-22
        // Data input
        ArrayList<String> data = Input.listOfStrings("data/5.csv");
        ArrayList<int[]> pairs = new ArrayList<>();
        for (String string : data) {
            pairs.add(split(string));
        }

        // "Map" to be updated

        final int[][] diagonalLines = new int[1000][1000];
        final int[][] nonDiagonalLines = new int[1000][1000];
/*
        // Updating the map with data from the pairs
        for (int i = 0; i < pairs.size(); i++) {
/*
            for (int[] row : map) {
                for (int j : row) {
                    System.out.print(j == 0 ? "." : j);
                }
                System.out.println("");
            }

            System.out.println("\n\n\n");

            // Straight line
            if (pairs.get(i)[0] == pairs.get(i)[2]) {
                System.out.println(1);
                int[] current = pairs.get(i);

                if (current[1] < current[3]) {
                    System.out.println(current[0] + " " + current[1]);
                    for (int j = current[1]; j <= current[3]; j++) {
                        map[j][current[0]]++;
                    }
                } else {
                    System.out.println(current[0] + " " + current[1]);
                    for (int j = current[3]; j <= current[1]; j++) {
                        map[j][current[0]]++;
                    }
                }
            } else if (pairs.get(i)[1] == pairs.get(i)[3]  && pairs.get(i)[0] != pairs.get(i)[2]){
                System.out.println(2);
                int[] current = pairs.get(i);

                if (current[0] < current[2]) {
                    System.out.println(current[0] + " " + current[1]);
                    for (int j = current[0]; j <= current[2]; j++) {
                        map[current[1]][j]++;
                    }
                } else {
                    System.out.println(current[0] + " " + current[1]);
                    for (int j = current[2]; j <= current[0]; j++) {
                        map[current[1]][j]++;
                    }
                }
            } else if (pairs.get(i)[0] + pairs.get(i)[1] == pairs.get(i)[2] + pairs.get(i)[3]) {
                System.out.println(3);
                // Crossing middle
                int[] current = pairs.get(i);

                if (current[0] > current[2]) {
                    System.out.println(current[0] + " " + current[1]);
                    while (current[0] != current[2]) {
                        map[current[0]][current[1]]++;

                        current[0]--;
                        current[1]++;
                    }
                    map[current[0]][current[1]]++;
                } else {
                    System.out.println(current[0] + " " + current[1]);
                    while (current[0] != current[2]) {
                        map[current[1]][current[0]]++;

                        current[0]++;
                        current[1]--;
                    }
                    map[current[1]][current[0]]++;
                }

            } else if (pairs.get(i)[0] - pairs.get(i)[2] == pairs.get(i)[1] - pairs.get(i)[3]) {
                System.out.println(4);
                int[] current = pairs.get(i);

                if (current[0] > current[2]) {
                    System.out.println(current[0] + " " + current[1]);
                    while (current[0] != current[2]) {

                        map[current[1]][current[0]]++;

                        current[0]--;
                        current[1]--;

                    }
                    map[current[1]][current[0]]++;
                } else {
                    System.out.println(current[0] + " " + current[1]);
                    while (current[0] != current[2]) {
                        map[current[0]][current[1]]++;

                        current[0]++;
                        current[1]++;
                    }
                    map[current[0]][current[1]]++;
                }

            }
        }


        // Calculating total
        int counter = 0;
        for (int[] row : map) {
            for (int i : row) {
                System.out.print(i == 0 ? "." : i);
                if (i > 1) {
                    counter++;
                }
            }
            System.out.println();
        }

        return counter;
        */

        for (int[] array : pairs) {
            int x1 = array[0];
            int y1 = array[1];
            int x2 = array[2];
            int y2 = array[3];
            int dx = Integer.signum(x2 - x1);
            int dy = Integer.signum(y2 -y1);

            int x = x1;
            int y = y1;

            while (x != x2 + dx || y != y2 + dy) {
                if (x1 != x2 && y1 != y2) {
                    diagonalLines[x][y]++;
                } else {
                    nonDiagonalLines[x][y]++;
                }
                x += dx;
                y += dy;
            }
        }

        int count = 0;
        for (int x = 0; x < 1000; x++) {
            for (int y = 0; y < 1000; y++) {
                if (diagonalLines[x][y] + nonDiagonalLines[x][y] > 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int[] split (String string){
        String[] array = string.split(",| -> ");

        int[] temp = new int[array.length];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = Integer.parseInt(array[i]);
        }

        return temp;
    }
}
