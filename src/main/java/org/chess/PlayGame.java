package org.chess;

import org.pieces.Piece;

import java.util.Scanner;

public class PlayGame {
    public static Board board = new Board();
    public static ChessView chessView = new ChessView(board);
    public static Game game = new Game(board);
    public static Piece.Color turn = Piece.Color.WHITE;
    private static final String WHITE_TURN = "흰색";
    private static final String BLACK_TURN = "검은색";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String input = sc.nextLine();
            if(input.equals("start")){
                board.initialize();
                System.out.println(printTurn(turn)+"의 턴입니다.");
                System.out.println(chessView.showBoard());
            } else if (input.equals("end")) {
                break;
            } else if (input.startsWith("move")) {
                String[] moveCommand = input.split(" ");
                boolean isMoved = game.move(turn,moveCommand[1], moveCommand[2]);
                if(!isMoved) {
                    System.out.println("다시 입력해 주세요");
                    continue;
                }
                turn = switchTurn(turn);
                System.out.println(printTurn(turn)+"의 턴입니다.");
                System.out.println(chessView.showBoard());
            }
        }
    }

    private static Piece.Color switchTurn(Piece.Color turn) {
        return turn.equals(Piece.Color.WHITE) ? Piece.Color.BLACK : Piece.Color.WHITE;
    }

    private static String printTurn(Piece.Color turn) {
        return turn.equals(Piece.Color.WHITE) ? WHITE_TURN : BLACK_TURN;
    }
}
