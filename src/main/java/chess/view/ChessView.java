package chess.view;

import chess.board.Board;
import chess.enums.Color;
import chess.piece.Piece;
import chess.util.StringUtils;

public class ChessView {

    private final Board board;
    private static final int BOARD_SIZE = 8;

    public ChessView(Board board) {
        this.board = board;
    }

    public void printBoard() {
        Piece[][] pieces = board.getBoard();
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = pieces[row][col];
                sb.append(piece.getColor()== Color.NOCOLOR ? "." : piece.getSymbol());
            }
            sb.append(StringUtils.appendNewLine(""));
        }
        System.out.println(sb);
    }
}
