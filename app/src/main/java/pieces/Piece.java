package pieces;

public class Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";

    public static final char WHITE_PAWN_REPRESENTATION = '♙';
    public static final char BLACK_PAWN_REPRESENTATION = '♟';
    public static final char WHITE_ROOK_REPRESENTATION = '♖';
    public static final char BLACK_ROOK_REPRESENTATION = '♜';
    public static final char WHITE_KNIGHT_REPRESENTATION = '♘';
    public static final char BLACK_KNIGHT_REPRESENTATION = '♞';
    public static final char WHITE_BISHOP_REPRESENTATION = '♗';
    public static final char BLACK_BISHOP_REPRESENTATION = '♝';
    public static final char WHITE_QUEEN_REPRESENTATION = '♕';
    public static final char BLACK_QUEEN_REPRESENTATION = '♛';
    public static final char WHITE_KING_REPRESENTATION = '♔';
    public static final char BLACK_KING_REPRESENTATION = '♚';

    private String name;
    private final String color;
    private final char representation;


    public Piece(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return representation;
    }

    public static Piece createWhitePawn() {
        Piece whitePawn = new Piece(WHITE_COLOR, WHITE_PAWN_REPRESENTATION);
        whitePawn.name = "pawn";
        return whitePawn;
    }

    public static Piece createBlackPawn() {
        Piece whitePawn = new Piece(BLACK_COLOR, BLACK_PAWN_REPRESENTATION);
        whitePawn.name = "pawn";
        return whitePawn;
    }

    public static Piece createWhiteRook() {
        Piece whitePawn = new Piece(WHITE_COLOR, WHITE_ROOK_REPRESENTATION);
        whitePawn.name = "rook";
        return whitePawn;
    }

    public static Piece createBlackRook() {
        Piece whitePawn = new Piece(BLACK_COLOR, BLACK_ROOK_REPRESENTATION);
        whitePawn.name = "rook";
        return whitePawn;
    }

    public static Piece createWhiteKnight() {
        Piece whitePawn = new Piece(WHITE_COLOR, WHITE_KNIGHT_REPRESENTATION);
        whitePawn.name = "knight";
        return whitePawn;
    }

    public static Piece createBlackKnight() {
        Piece whitePawn = new Piece(BLACK_COLOR, BLACK_KNIGHT_REPRESENTATION);
        whitePawn.name = "knight";
        return whitePawn;
    }

    public static Piece createWhiteBishop() {
        Piece whitePawn = new Piece(WHITE_COLOR, WHITE_BISHOP_REPRESENTATION);
        whitePawn.name = "bishop";
        return whitePawn;
    }

    public static Piece createBlackBishop() {
        Piece whitePawn = new Piece(BLACK_COLOR, BLACK_BISHOP_REPRESENTATION);
        whitePawn.name = "bishop";
        return whitePawn;
    }

    public static Piece createWhiteQueen() {
        Piece whitePawn = new Piece(WHITE_COLOR, WHITE_QUEEN_REPRESENTATION);
        whitePawn.name = "queen";
        return whitePawn;
    }

    public static Piece createBlackQueen() {
        Piece whitePawn = new Piece(BLACK_COLOR, BLACK_QUEEN_REPRESENTATION);
        whitePawn.name = "queen";
        return whitePawn;
    }
}
