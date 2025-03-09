package org.chess;

import java.util.Scanner;

public class PlayGame {
    public static Board board = new Board();
    public static ChessView chessView = new ChessView(board);
    public static Game game = new Game(board);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String input = sc.nextLine();
            if(input.equals("start")){
                board.initialize();
                System.out.println(chessView.showBoard());
            } else if (input.equals("end")) {
                break;
            } else if (input.startsWith("move")) {
                String[] moveCommand = input.split(" ");
                game.move(moveCommand[1], moveCommand[2]);
                System.out.println(chessView.showBoard());
            }
        }
    }
}
