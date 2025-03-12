package chess.view;


import chess.enums.Color;
import chess.piece.Piece;
import chess.util.StringUtils;

import java.util.Scanner;


import static chess.enums.Color.WHITE;

public class ChessView {

    private static final Scanner scanner = new Scanner(System.in);

    public String requestUserInput(Color currentTurn){
        System.out.println("\n현재 턴: " + (currentTurn == WHITE ? "흰색(White)" : "검은색(Black)"));
        System.out.println("명령어를 입력하세요 (start / move source target / end)");
        System.out.println("예시: move b2 b3");

        return  requestUserCommand();
    }

    public void printBoard(Piece[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                sb.append(piece.getColor()== Color.NOCOLOR ? "." : piece.getSymbol());
            }
            sb.append(StringUtils.appendNewLine(""));
        }
        System.out.println(sb);
    }

    public void displayError(String message){
        System.out.println("Error: " + message);
    }

    private static String requestUserCommand() {
        return scanner.nextLine();
    }
}
