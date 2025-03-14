package chess;

import java.util.Scanner;

public class ChessGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        Game game = new Game(board);
        BoardView boardView = new BoardView(board);
        board.initialize();

        while (true) {
            System.out.println ("Please enter \"start\" to start Chess Game, \"move <source> <target>\" to move a piece, or \"end\" to finish.");
            String input = sc.nextLine();

            if (input.equals("start")) {
                System.out.println(boardView.showBoard());
                continue;
            }
            if (input.equals("end")) {
                break;
            }
            if (input.startsWith("move")) {
                try {
                    movePiece(game, input);
                    System.out.println(boardView.showBoard());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                continue;
            }

            System.out.println("Please enter a valid command.");

        }
    }

    public static void movePiece(Game game, String input) {
        String[] command = input.split(" ");
        if (command.length == 3) {
            game.move(command[1], command[2]);
        } else {
            System.out.println("Invalid move command. Use: move <source> <target>");
        }
    }
}
