package pieces;

public class Piece {
    private static final String COLOR_WHITE = "white";
    private static final String COLOR_BLACK = "black";
    private static final char PAWN_WHITE = 'p';
    private static final char PAWN_BLACK = 'P';
    private static final char KNIGHT_WHITE = 'n';
    private static final char KNIGHT_BLACK = 'N';
    private static final char ROOK_WHITE = 'r';
    private static final char ROOK_BLACK = 'R';
    private static final char BISHOP_WHITE = 'b';
    private static final char BISHOP_BLACK = 'B';
    private static final char QUEEN_WHITE = 'q';
    private static final char QUEEN_BLACK = 'Q';
    private static final char KING_WHITE = 'k';
    private static final char KING_BLACK = 'K';

    private final String color;
    private final char type;

    private Piece(String color, char type) {
        this.color = color;
        this.type = type;
    }

    public static Piece createWhitePawn() {
        return new Piece(COLOR_WHITE, PAWN_WHITE);
    }

    public static Piece createBlackPawn() {
        return new Piece(COLOR_BLACK, PAWN_BLACK);
    }

    public static Piece createWhiteKnight() {
        return new Piece(COLOR_WHITE, KNIGHT_WHITE);
    }

    public static Piece createBlackKnight() {
        return new Piece(COLOR_BLACK, KNIGHT_BLACK);
    }

    public static Piece createWhiteRook() {
        return new Piece(COLOR_WHITE, ROOK_WHITE);
    }

    public static Piece createBlackRook() {
        return new Piece(COLOR_BLACK, ROOK_BLACK);
    }

    public static Piece createWhiteBishop() {
        return new Piece(COLOR_WHITE, BISHOP_WHITE);
    }

    public static Piece createBlackBishop() {
        return new Piece(COLOR_BLACK, BISHOP_BLACK);
    }

    public static Piece createWhiteQueen() {
        return new Piece(COLOR_WHITE, QUEEN_WHITE);
    }

    public static Piece createBlackQueen() {
        return new Piece(COLOR_BLACK, QUEEN_BLACK);
    }

    public static Piece createWhiteKing() {
        return new Piece(COLOR_WHITE, KING_WHITE);
    }

    public static Piece createBlackKing() {
        return new Piece(COLOR_BLACK, KING_BLACK);
    }
    
    public String getColor() {
        return color;
    }

    public char getRepresentation() {
        return type;
    }
}

// 객체의 생성은 팩토리 메소드만 할 수 있다.
