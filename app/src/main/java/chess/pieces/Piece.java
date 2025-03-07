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

    public static Piece createWhite(Type type) {
        return new Piece(type, WHITE);
    }
    public static Piece createBlack(Type type) {
        return new Piece(type, BLACK);
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

