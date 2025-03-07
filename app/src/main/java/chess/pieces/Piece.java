package chess.pieces;

import static chess.pieces.Piece.Color.*;
import static chess.pieces.Piece.Type.*;

public class Piece {

    private final Type type;
    private final Color color;

    private Piece(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    public static Piece createWhitePawn() {return new Piece(PAWN, WHITE);}
    public static Piece createBlackPawn() {
        return new Piece(PAWN, BLACK);
    }
    public static Piece createWhiteKing() {
        return new Piece(KING, WHITE);
    }
    public static Piece createBlackKing() {
        return new Piece(KING, BLACK);
    }
    public static Piece createWhiteQueen() {
        return new Piece(QUEEN, WHITE);
    }
    public static Piece createBlackQueen() {
        return new Piece(QUEEN, BLACK);
    }
    public static Piece createWhiteRook() {
        return new Piece(ROOK, WHITE);
    }
    public static Piece createBlackRook() {
        return new Piece(ROOK, BLACK);
    }
    public static Piece createWhiteBishop() {return new Piece(BISHOP, WHITE);}
    public static Piece createBlackBishop() {
        return new Piece(BISHOP, BLACK);
    }
    public static Piece createWhiteKnight() {return new Piece(KNIGHT, WHITE);}
    public static Piece createBlackKnight() {
        return new Piece(KNIGHT, BLACK);
    }

    public Color getColor() {
        return color;
    }

    public char getRepresentation() {
        return this.color == WHITE ? this.type.getWhiteRepresentation() : this.type.getBlackRepresentation();
    }
    public boolean isBlack() {
        return this.color.equals(BLACK);
    }
    public boolean isWhite() {
        return this.color.equals(WHITE);
    }

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('p'), ROOK('r'), KNIGHT('n'), BISHOP('b'), QUEEN('q'), KING('k'), NO_PIECE(' ');

        private final char representation;

        Type(char representation) {
            this.representation = representation;
        }

        public char getWhiteRepresentation() {
            return representation;
        }
        public char getBlackRepresentation() {
            return Character.toUpperCase(representation);
        }
    }
}

