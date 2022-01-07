package no.reberg.model;

import java.util.List;

public class BingoBoard {
    private String[][] board;

    public BingoBoard (List<String> board) {
        this.board = new String[board.size()][board.size()];

        for (int i = 0; i < board.size(); i++) {

            // Formaterer litt, håndterer start med mellomrom på hvert element
            String washed = board.get(i).replace("  ", " ");

            if (washed.startsWith(" ")) {
                washed = washed.substring(1, washed.length());
            }

            String[] temp = washed.split(" ");

            for (int j = 0; j < temp.length; j++) {
                this.board[i][j] = temp[j];
            }
        }
    }

    public void checkNumber(String newNumber) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].equals(newNumber)) {
                    board[i][j] = "0";
                    return;
                }
            }
        }
    }

    public boolean hasWon() {
        for (int i = 0; i < board.length; i++) {
            int vertical = 0;
            int horizontal = 0;

            for (int j = 0; j < board[0].length; j++) {
                if (board[j][i].equals("0")) {
                    vertical++;
                }
                if (board[i][j].equals("0")) {
                    horizontal++;
                }
            }

            if (vertical == board.length || horizontal == board[0].length) {
                return true;
            }

        }
        return false;
    }

    public int sum() {
        int temp = 0;

        for (String[] row : board) {
            for (String cell : row) {
                temp += Integer.parseInt(cell);
            }
        }

        return temp;
    }
}
