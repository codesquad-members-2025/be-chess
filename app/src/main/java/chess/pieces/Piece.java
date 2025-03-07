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

    public static Piece createBlank() {return new Piece(NO_PIECE,NOCOLOR);}

    private static Piece createWhite(Type type) {
        return new Piece(type, WHITE);
    }
    private static Piece createBlack(Type type) {
        return new Piece(type, BLACK);
    }

    public static Piece createWhitePawn() {
        return createWhite(PAWN);
    }
    public static Piece createWhiteRook() {
        return createWhite(ROOK);
    }
    public static Piece createWhiteKnight() {
        return createWhite(KNIGHT);
    }
    public static Piece createWhiteBishop() {
        return createWhite(BISHOP);
    }
    public static Piece createWhiteQueen() {
        return createWhite(QUEEN);
    }
    public static Piece createWhiteKing() {
        return createWhite(KING);
    }
    public static Piece createBlackPawn() {
        return createBlack(PAWN);
    }
    public static Piece createBlackRook() {
        return createBlack(ROOK);
    }
    public static Piece createBlackKnight() {
        return createBlack(KNIGHT);
    }
    public static Piece createBlackBishop() {
        return createBlack(BISHOP);
    }
    public static Piece createBlackQueen() {
        return createBlack(QUEEN);
    }
    public static Piece createBlackKing() {
        return createBlack(KING);
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

    public Type getType() {
        return this.type;
    }


    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('p'), ROOK('r'), KNIGHT('n'), BISHOP('b'), QUEEN('q'), KING('k'), NO_PIECE('.');

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

