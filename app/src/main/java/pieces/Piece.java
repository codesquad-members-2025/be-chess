package pieces;

public class Piece {
    public enum Color {
        WHITE, BLACK, NO_COLOR
    }

    public enum Type {
        PAWN('p'),
        ROOK('r'),
        KNIGHT('n'),
        BISHOP('b'),
        QUEEN('q'),
        KING('k'),
        NO_PIECE('.')
        ;

        private char representation;

        Type(char representation) {
            this.representation = representation;
        }

        public char getRepresentation() {
            return representation;
        }

    }
    private String name;
    private final Color color;
    private final Type type;

    public Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public char getType() {
        return type.getRepresentation();
    }

    public static Piece createWhitePawn() {
        Piece whitePawn = new Piece(Color.WHITE, Type.PAWN);
        whitePawn.name = "pawn";
        return whitePawn;
    }

    public static Piece createBlackPawn() {
        Piece whitePawn = new Piece(Color.BLACK, Type.PAWN);
        whitePawn.name = "pawn";
        return whitePawn;
    }

    public static Piece createWhiteRook() {
        Piece whitePawn = new Piece(Color.WHITE, Type.ROOK);
        whitePawn.name = "rook";
        return whitePawn;
    }

    public static Piece createBlackRook() {
        Piece whitePawn = new Piece(Color.BLACK, Type.ROOK);
        whitePawn.name = "rook";
        return whitePawn;
    }

    public static Piece createWhiteKnight() {
        Piece whitePawn = new Piece(Color.WHITE, Type.KNIGHT);
        whitePawn.name = "knight";
        return whitePawn;
    }

    public static Piece createBlackKnight() {
        Piece whitePawn = new Piece(Color.BLACK, Type.KNIGHT);
        whitePawn.name = "knight";
        return whitePawn;
    }

    public static Piece createWhiteBishop() {
        Piece whitePawn = new Piece(Color.WHITE, Type.BISHOP);
        whitePawn.name = "bishop";
        return whitePawn;
    }

    public static Piece createBlackBishop() {
        Piece whitePawn = new Piece(Color.BLACK, Type.BISHOP);
        whitePawn.name = "bishop";
        return whitePawn;
    }

    public static Piece createWhiteQueen() {
        Piece whitePawn = new Piece(Color.WHITE, Type.QUEEN);
        whitePawn.name = "queen";
        return whitePawn;
    }

    public static Piece createBlackQueen() {
        Piece whitePawn = new Piece(Color.BLACK, Type.QUEEN);
        whitePawn.name = "queen";
        return whitePawn;
    }

    public static Piece createWhiteKing() {
        Piece whitePawn = new Piece(Color.WHITE, Type.KING);
        whitePawn.name = "king";
        return whitePawn;
    }

    public static Piece createBlackKing() {
        Piece whitePawn = new Piece(Color.BLACK, Type.KING);
        whitePawn.name = "king";
        return whitePawn;
    }

    public static Piece createBlank() {
        Piece blank = new Piece(Color.NO_COLOR, Type.NO_PIECE);
        blank.name = "blank";
        return blank;
    }

    public boolean isWhite() {
       return color.equals(Color.WHITE);
    }

    public boolean isBlack() {
        return color.equals(Color.BLACK);
    }
}
