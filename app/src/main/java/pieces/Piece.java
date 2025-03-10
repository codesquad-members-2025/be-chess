package pieces;

public class Piece {
    public enum Color {
        WHITE, BLACK, NOCOLOR
    }

    public enum Type {
        WHITE_PAWN('♙'),
        BLACK_PAWN('♟'),
        WHITE_ROOK('♖'),
        BLACK_ROOK('♜'),
        WHITE_KNIGHT('♘'),
        BLACK_KNIGHT('♞'),
        WHITE_BISHOP('♗'),
        BLACK_BISHOP('♝'),
        WHITE_QUEEN('♕'),
        BLACK_QUEEN('♛'),
        WHITE_KING('♔'),
        BLACK_KING('♚'),
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
    private final Type representation;


    public Piece(Color color, Type representation) {
        this.color = color;
        this.representation = representation;
    }

    public Color getColor() {
        return color;
    }

    public Type getRepresentation() {
        return representation;
    }

    public static Piece createWhitePawn() {
        Piece whitePawn = new Piece(Color.WHITE, Type.WHITE_PAWN);
        whitePawn.name = "pawn";
        return whitePawn;
    }

    public static Piece createBlackPawn() {
        Piece whitePawn = new Piece(Color.BLACK, Type.BLACK_PAWN);
        whitePawn.name = "pawn";
        return whitePawn;
    }

    public static Piece createWhiteRook() {
        Piece whitePawn = new Piece(Color.WHITE, Type.WHITE_ROOK);
        whitePawn.name = "rook";
        return whitePawn;
    }

    public static Piece createBlackRook() {
        Piece whitePawn = new Piece(Color.BLACK, Type.BLACK_ROOK);
        whitePawn.name = "rook";
        return whitePawn;
    }

    public static Piece createWhiteKnight() {
        Piece whitePawn = new Piece(Color.WHITE, Type.WHITE_KNIGHT);
        whitePawn.name = "knight";
        return whitePawn;
    }

    public static Piece createBlackKnight() {
        Piece whitePawn = new Piece(Color.BLACK, Type.BLACK_KNIGHT);
        whitePawn.name = "knight";
        return whitePawn;
    }

    public static Piece createWhiteBishop() {
        Piece whitePawn = new Piece(Color.WHITE, Type.WHITE_BISHOP);
        whitePawn.name = "bishop";
        return whitePawn;
    }

    public static Piece createBlackBishop() {
        Piece whitePawn = new Piece(Color.BLACK, Type.BLACK_BISHOP);
        whitePawn.name = "bishop";
        return whitePawn;
    }

    public static Piece createWhiteQueen() {
        Piece whitePawn = new Piece(Color.WHITE, Type.WHITE_QUEEN);
        whitePawn.name = "queen";
        return whitePawn;
    }

    public static Piece createBlackQueen() {
        Piece whitePawn = new Piece(Color.BLACK, Type.BLACK_QUEEN);
        whitePawn.name = "queen";
        return whitePawn;
    }

    public static Piece createWhiteKing() {
        Piece whitePawn = new Piece(Color.WHITE, Type.WHITE_KING);
        whitePawn.name = "king";
        return whitePawn;
    }

    public static Piece createBlackKing() {
        Piece whitePawn = new Piece(Color.BLACK, Type.BLACK_KING);
        whitePawn.name = "king";
        return whitePawn;
    }

    public boolean isWhite() {
       return color.equals(Color.WHITE);
    }

    public boolean isBlack() {
        return color.equals(Color.BLACK);
    }
}
