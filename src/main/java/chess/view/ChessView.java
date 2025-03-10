package chess.view;

import chess.board.Board;
import chess.enums.Color;
import chess.piece.Piece;
import chess.util.StringUtils;

public class ChessView {

    public static void printBoard(Piece[][] board) {
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
}
