package chess.pieces;

public class Piece {

    public static final String BLACK_COLOR = "black";
    public static final String WHITE_COLOR = "white";
    public static final char WHITE_PAWN_REPRESENTATION = 'p';
    public static final char BLACK_PAWN_REPRESENTATION = 'P';
    public static final char WHITE_KING_REPRESENTATION = 'k';
    public static final char BLACK_KING_REPRESENTATION = 'K';
    public static final char WHITE_QUEEN_REPRESENTATION = 'q';
    public static final char BLACK_QUEEN_REPRESENTATION = 'Q';
    public static final char WHITE_ROOK_REPRESENTATION = 'r';
    public static final char BLACK_ROOK_REPRESENTATION = 'R';
    public static final char WHITE_BISHOP_REPRESENTATION = 'b';
    public static final char BLACK_BISHOP_REPRESENTATION = 'B';
    public static final char WHITE_KNIGHT_REPRESENTATION = 'n';
    public static final char BLACK_KNIGHT_REPRESENTATION = 'N';

    public static final String PAWN = "pawn";
    public static final String KING = "king";
    public static final String QUEEN = "queen";
    public static final String ROOK = "rook";
    public static final String BISHOP = "bishop";
    public static final String KNIGHT = "knight";

    private final String name;
    private final String color;
    private final char representation;

    private Piece(String name, String color, char representation) {
        this.name = name;
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn() {
        return new Piece(PAWN, WHITE_COLOR, WHITE_PAWN_REPRESENTATION);
    }
    public static Piece createBlackPawn() {
        return new Piece(PAWN, BLACK_COLOR, BLACK_PAWN_REPRESENTATION);
    }
    public static Piece createWhiteKing() {
        return new Piece(KING, WHITE_COLOR, WHITE_KING_REPRESENTATION);
    }
    public static Piece createBlackKing() {
        return new Piece(KING, BLACK_COLOR, BLACK_KING_REPRESENTATION);
    }
    public static Piece createWhiteQueen() {
        return new Piece(QUEEN, WHITE_COLOR, WHITE_QUEEN_REPRESENTATION);
    }
    public static Piece createBlackQueen() {
        return new Piece(QUEEN, BLACK_COLOR, BLACK_QUEEN_REPRESENTATION);
    }
    public static Piece createWhiteRook() {
        return new Piece(ROOK, WHITE_COLOR, WHITE_ROOK_REPRESENTATION);
    }
    public static Piece createBlackRook() {
        return new Piece(ROOK, BLACK_COLOR, BLACK_ROOK_REPRESENTATION);
    }
    public static Piece createWhiteBishop() {
        return new Piece(BISHOP, WHITE_COLOR, WHITE_BISHOP_REPRESENTATION);
    }
    public static Piece createBlackBishop() {
        return new Piece(BISHOP, BLACK_COLOR, BLACK_BISHOP_REPRESENTATION);
    }
    public static Piece createWhiteKnight() {
        return new Piece(KNIGHT, WHITE_COLOR, WHITE_KNIGHT_REPRESENTATION);
    }
    public static Piece createBlackKnight() {
        return new Piece(KNIGHT, BLACK_COLOR, BLACK_KNIGHT_REPRESENTATION);
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }
    public boolean isBlack() {
        return this.color.equals(BLACK_COLOR);
    }
    public boolean isWhite() {
        return this.color.equals(WHITE_COLOR);
    }
}

