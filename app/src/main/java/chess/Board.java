package chess;

import pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final char[][] board =  new char[8][8];
    
    public Board() {
        for  (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = '.';
            }
        }
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            board[1][i] = Pawn.BLACK_REPRESENTATION;
            board[6][i] = Pawn.WHITE_REPRESENTATION;
        }
    }

    public String getWhitePawnsResult() {
        return new String(board[6]);
    }

    public String getBlackPawnsResult() {
        return new String(board[1]);
    }
}
