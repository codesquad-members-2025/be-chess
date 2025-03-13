package pieces;

import pieces.Piece.*;

public class PieceFactory {
    public static Piece createWhite(Piece.Type type) {
        return createPiece(Piece.Color.WHITE, type);
    }
    public static Piece createBlack(Piece.Type type) {
        return createPiece(Piece.Color.BLACK, type);
    }

    public static Piece createBlank() {
        return new Blank(); // 빈 칸을 나타내는 클래스
    }

    private static Piece createPiece(Piece.Color color, Piece.Type type) {
        switch (type) {
            case PAWN:
                return new Pawn(color);
            case ROOK:
                return new Rook(color);
            case KNIGHT:
                return new Knight(color);
            case BISHOP:
                return new Bishop(color);
            case QUEEN:
                return new Queen(color);
            case KING:
                return new King(color);
            default:
                throw new IllegalArgumentException("Invalid piece type");
        }
    }


}
