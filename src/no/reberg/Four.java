package no.reberg;

import no.reberg.model.BingoBoard;

import java.util.ArrayList;
import java.util.List;

public class Four {
    public static int first() {
        // Loading data
        ArrayList<String> data = Input.listOfStrings("data/4.csv");
        ArrayList<String> drawn = new ArrayList<String>(
                List.of(data.get(0).split(","))
            );
        ArrayList<BingoBoard> boards = new ArrayList<>();

        for (int i = 2; i < data.size() - 2; i += 6) {
            boards.add(new BingoBoard(data.subList(i, i + 5)));
        }

        // Starting to check numbers
        String current = "0";
        boolean finished = false;
        while (!finished) {
            current = drawn.get(0);
            drawn.remove(0);

            for (BingoBoard board : boards) {
                board.checkNumber(current);
                if (board.hasWon()) {
                    finished = true;
                    break;
                }
            }
        }

        // Finding the winner
        BingoBoard winner;
        for (BingoBoard board : boards) {
            if (board.hasWon()) {
                winner = board;
                System.out.println("fant vinner");
                return board.sum() * Integer.parseInt(current);
            }
        }



        return -1;
    }
}
