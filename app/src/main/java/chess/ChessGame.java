package chess;

import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println ("Please enter \"start\" to start Ches Game and \"end\" to finish.");
            String input = sc.nextLine();
            if (input.equals("start")) {
                Board board = new Board();
                board.initialize();
                System.out.println(board.print());
            } else if (input.equals("end")) {
                break;
            } else {
                System.out.println ("Please enter a valid command.");
            }

        }
    }
}
