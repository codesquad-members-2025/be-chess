package org.chess.domain.pieces;

public class Piece {

    public static final String PAWN_NAME = "pawn";
    public static final String QUEEN_NAME = "queen";
    public static final String KING_NAME = "king";
    public static final String ROOK_NAME = "rook";
    public static final String BISHOP_NAME = "bishop";
    public static final String KNIGHT_NAME = "knight";
    public static final String BLANK_NAME = "blank";

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

    private final String name;
    private final Color color;
    private final Type representation;

    private Piece(String name, Color color, Type representation) {
        this.name = name;
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn() {
        return new Piece(PAWN_NAME, Color.WHITE, Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(PAWN_NAME, Color.BLACK, Type.PAWN);
    }

    public static Piece createWhiteQueen() {
        return new Piece(QUEEN_NAME, Color.WHITE, Type.QUEEN);
    }

    public static Piece createBlackQueen() {
        return new Piece(QUEEN_NAME, Color.BLACK, Type.QUEEN);
    }

    public static Piece createWhiteKing() {
        return new Piece(KING_NAME, Color.WHITE, Type.KING);
    }

    public static Piece createBlackKing() {
        return new Piece(KING_NAME, Color.BLACK, Type.KING);
    }

    public static Piece createWhiteRook() {
        return new Piece(ROOK_NAME, Color.WHITE, Type.ROOK);
    }

    public static Piece createBlackRook() {
        return new Piece(ROOK_NAME, Color.BLACK, Type.ROOK);
    }

    public static Piece createWhiteBishop() {
        return new Piece(BISHOP_NAME, Color.WHITE, Type.BISHOP);
    }

    public static Piece createBlackBishop() {
        return new Piece(BISHOP_NAME, Color.BLACK, Type.BISHOP);
    }

    public static Piece createWhiteKnight() {
        return new Piece(KNIGHT_NAME, Color.WHITE, Type.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return new Piece(KNIGHT_NAME, Color.BLACK, Type.KNIGHT);
    }

    public static Piece createBlankPiece() {
        return new Piece(BLANK_NAME, Color.NOCOLOR, Type.NO_PIECE);
    }

    public boolean isWhite() {
        return color.equals(Color.WHITE);
    }

    public boolean isBlack() {
        return color.equals(Color.BLACK);
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return representation;
    }

}
