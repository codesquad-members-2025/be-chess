package chess;

import pieces.Piece;
import pieces.Piece.Type;
import java.util.ArrayList;

import static utils.StringUtils.appendNewLine;

public class Board {
    private final ArrayList<Rank> board = new ArrayList<>();

    public Board() {
        for (int i = 0; i < 8; i++) {
            board.add(new Rank());
        }
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            setPiece(1, i, Piece.createBlack(Type.PAWN));
            setPiece(6, i, Piece.createWhite(Type.PAWN));
        }
        setPiece(0, 0, Piece.createBlack(Type.ROOK));
        setPiece(7, 0, Piece.createWhite(Type.ROOK));
        setPiece(0, 1, Piece.createBlack(Type.KNIGHT));
        setPiece(7, 1, Piece.createWhite(Type.KNIGHT));
        setPiece(0, 2, Piece.createBlack(Type.BISHOP));
        setPiece(7, 2, Piece.createWhite(Type.BISHOP));
        setPiece(0, 3, Piece.createBlack(Type.QUEEN));
        setPiece(7, 3, Piece.createWhite(Type.QUEEN));
        setPiece(0, 4, Piece.createBlack(Type.KING));
        setPiece(7, 4, Piece.createWhite(Type.KING));
        setPiece(0, 5, Piece.createBlack(Type.BISHOP));
        setPiece(7, 5, Piece.createWhite(Type.BISHOP));
        setPiece(0, 6, Piece.createBlack(Type.KNIGHT));
        setPiece(7, 6, Piece.createWhite(Type.KNIGHT));
        setPiece(0, 7, Piece.createBlack(Type.ROOK));
        setPiece(7, 7, Piece.createWhite(Type.ROOK));
    }

    public void setPiece(int row, int col, Piece piece) {
        board.get(row).setPiece(col, piece);  //  Rank의 setPiece() 호출
    }


    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(board.get(i).print());
            sb.append(appendNewLine(""));
        }
        return sb.toString();
    }

    public int pieceCount(Piece.Color color, Piece.Type type) {
        int cnt = 0;
        for (Rank row : board) {
            for (Piece piece : row.getRow()) {
                if  (piece.getColor() == color&& piece.getType() == type) {
                    cnt ++;
                }
            }

        }
        return cnt;
    }

    public int totalPieceCount() {
        int cnt = 0;
        for (Rank row : board) {
            for (Piece piece : row.getRow()) {
                if (piece.getType() != Piece.Type.NO_PIECE) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public Piece findPiece(String position) {
        Position pos = new Position(position);
        return board.get(pos.getRow()).getPiece(pos.getCol());
    }

}


