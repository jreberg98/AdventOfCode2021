package no.reberg;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n---  1. desember  ---");
        System.out.println(One.first());
        System.out.println(One.second());

        System.out.println("\n---  2. desember  ---");
        System.out.println(Two.first());
        System.out.println(Two.second());

        System.out.println("\n---  3. desember  ---");
        System.out.println(Input.listOfStrings("data/3.csv"));
    }
}
