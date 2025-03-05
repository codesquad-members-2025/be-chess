package org.chess;

import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String input = sc.nextLine();
            if(input.equals("start")){
                Board board = new Board();
                board.initialize();
                System.out.println(board.print());
            } else if (input.equals("end")) {
                break;
            }
        }
    }
}
