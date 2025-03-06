package chess;

import pieces.Piece;

import static utils.StringUtils.appendNewLine;


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
            board[1][i] = Piece.BLACK_PAWN_REPRESENTATION;
            board[6][i] = Piece.WHITE_PAWN_REPRESENTATION;
        }
        board[0][0] = Piece.createBlackRook().getRepresentation();
        board[7][0] = Piece.createWhiteRook().getRepresentation();
        board[0][1] = Piece.createBlackKnight().getRepresentation();
        board[7][1] = Piece.createWhiteKnight().getRepresentation();
        board[0][2] = Piece.createBlackBishop().getRepresentation();
        board[7][2] = Piece.createWhiteBishop().getRepresentation();
        board[0][3] = Piece.createBlackQueen().getRepresentation();
        board[7][3] = Piece.createWhiteQueen().getRepresentation();
        board[0][4] = Piece.createBlackKing().getRepresentation();
        board[7][4] = Piece.createWhiteKing().getRepresentation();
        board[0][5] = Piece.createBlackBishop().getRepresentation();
        board[7][5] = Piece.createWhiteBishop().getRepresentation();
        board[0][6] = Piece.createBlackKnight().getRepresentation();
        board[7][6] = Piece.createWhiteKnight().getRepresentation();
        board[0][7] = Piece.createBlackRook().getRepresentation();
        board[7][7] = Piece.createWhiteRook().getRepresentation();
    }

    public String getWhitePawnsResult() {
        return new String(board[6]);
    }

    public String getBlackPawnsResult() {
        return new String(board[1]);
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(board[i][j]);
            }
            sb.append(appendNewLine(""));
        }
        return sb.toString();
    }

    public int pieceCount() {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != '.') {
                    cnt ++;
                }
            }
        }
        return cnt;
    }
}
