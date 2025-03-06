package org.chess.domain.pieces;

public class Piece {

    public enum Color {
        WHITE("white"), BLACK("black"), NOCOLOR("null");

        private final String color;

        Color(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }

    public enum Type {
        PAWN('p'),
        ROOK('r'),
        KNIGHT('n'),
        BISHOP('b'),
        QUEEN('q'),
        KING('k'),
        NO_PIECE('.');

        private final char representation;

        Type(char representation) {
            this.representation = representation;
        }

        public char getType() {
            return representation;
        }

        public char getBlackType() {
            return Character.toUpperCase(representation);
        }

        public char getWhiteType() {
            return Character.toLowerCase(representation);
        }
    }

    private final Color color;
    private final Type representation;

    private Piece(Color color, Type representation) {
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhite(Piece.Type type) {
        return new Piece(Color.WHITE, type);
    }

    public static Piece createBlack(Piece.Type type) {
        return new Piece(Color.BLACK, type);
    }

    public static Piece createBlankPiece() {
        return new Piece(Color.NOCOLOR, Type.NO_PIECE);
    }

    public boolean isWhite() {
        return color.equals(Color.WHITE);
    }

    public boolean isBlack() {
        return color.equals(Color.BLACK);
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return representation;
    }

}
