package org.chess;

import java.util.Scanner;

public class PlayGame {
    public static Board board = new Board();
    public static BoardStatus boardStatus = new BoardStatus(board);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String input = sc.nextLine();
            if(input.equals("start")){
                board.initialize();
                System.out.println(boardStatus.showBoard());
            } else if (input.equals("end")) {
                break;
            } else if (input.startsWith("move")) {
                String[] moveCommand = input.split(" ");
                board.move(moveCommand[1], moveCommand[2]);
                System.out.println(boardStatus.showBoard());
            }
        }
    }
}
