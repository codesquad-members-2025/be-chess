import chess.Board;

import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);

        System.out.println("체스 게임");
        System.out.println("게임을 시작하시겠습니까?(start or end)");

        String input = scanner.nextLine();
        while (input.equals("start")) {
            board.initialize();
            board.print();

            System.out.println("계속 진행하시겠습니까?");
            input = scanner.nextLine();
        }

    }
}
