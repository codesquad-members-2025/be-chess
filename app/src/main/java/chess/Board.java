package chess;

import pieces.Piece;
import pieces.Piece.Type;
import pieces.Piece.Color;

import java.util.Arrays;

import static utils.StringUtils.appendNewLine;


public class Board {
    private final Piece[][] board =  new Piece[8][8];
    
    public Board() {
        for  (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = Piece.createBlank();
            }
        }
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            board[1][i] = Piece.createBlack(Type.PAWN);
            board[6][i] = Piece.createWhite(Type.PAWN);
        }
        board[0][0] = Piece.createBlack(Type.ROOK);
        board[7][0] = Piece.createWhite(Type.ROOK);
        board[0][1] = Piece.createBlack(Type.KNIGHT);
        board[7][1] = Piece.createWhite(Type.KNIGHT);
        board[0][2] = Piece.createBlack(Type.BISHOP);
        board[7][2] = Piece.createWhite(Type.BISHOP);
        board[0][3] = Piece.createBlack(Type.QUEEN);
        board[7][3] = Piece.createWhite(Type.QUEEN);
        board[0][4] = Piece.createBlack(Type.KING);
        board[7][4] = Piece.createWhite(Type.KING);
        board[0][5] = Piece.createBlack(Type.BISHOP);
        board[7][5] = Piece.createWhite(Type.BISHOP);
        board[0][6] = Piece.createBlack(Type.KNIGHT);
        board[7][6] = Piece.createWhite(Type.KNIGHT);
        board[0][7] = Piece.createBlack(Type.ROOK);
        board[7][7] = Piece.createWhite(Type.ROOK);
        }


    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(board[i][j].getRepresentation());
            }
            sb.append(appendNewLine(""));
        }
        return sb.toString();
    }

    public int pieceCount() {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].getType() == Type.NO_PIECE) {
                    cnt ++;
                }
            }
        }
        return cnt;
    }
}
