package chess.pieces;

public class Piece {
    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('♙'),
        ROOK('♖'),
        KNIGHT('♘'),
        BISHOP('♗'),
        QUEEN('♕'),
        KING('♔'),
        NO_PIECE('.');

        private char defaultRepresentation;

        Type(char defaultRepresentation) {
            this.defaultRepresentation = defaultRepresentation;
        }

        public char getRepresentation(Color color) {
            if (color.equals(Color.BLACK)) {
                return getBlackRepresentation();
            }
            return defaultRepresentation;
        }

        private char getBlackRepresentation() {
            if (this == PAWN) {
                return '♟';  // U+265F (검은색 폰)
            }
            //폰을 제외한 문자들은 하얀색 + 6 -> 검은색
            return (char) (defaultRepresentation + 6);
        }
    }

    private Type name;
    private Color color;

    private Piece(Type name, Color color) {
        this.name = name;
        this.color = color;
    }

    private Piece() {
    }

    public static Piece createWhitePawn() {
        return new Piece(Type.PAWN, Color.WHITE);
    }
    public static Piece createBlackPawn() {
        return new Piece(Type.PAWN, Color.BLACK);
    }
    public static Piece createWhiteKnight() {
        return new Piece(Type.KNIGHT, Color.WHITE);
    }
    public static Piece createBlackKnight() {
        return new Piece(Type.KNIGHT, Color.BLACK);
    }
    public static Piece createWhiteRook() {
        return new Piece(Type.ROOK, Color.WHITE);
    }
    public static Piece createBlackRook() {
        return new Piece(Type.ROOK, Color.BLACK);
    }
    public static Piece createWhiteBishop() {
        return new Piece(Type.BISHOP, Color.WHITE);
    }
    public static Piece createBlackBishop() {
        return new Piece(Type.BISHOP, Color.BLACK);
    }
    public static Piece createWhiteQueen() {
        return new Piece(Type.QUEEN, Color.WHITE);
    }
    public static Piece createBlackQueen() {
        return new Piece(Type.QUEEN, Color.BLACK);
    }
    public static Piece createWhiteKing() {
        return new Piece(Type.KING, Color.WHITE);
    }
    public static Piece createBlackKing() {
        return new Piece(Type.KING, Color.BLACK);
    }

    public static Piece createBlank() {
        return new Piece(Type.NO_PIECE, Color.NOCOLOR);
    }

    public Type getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public boolean isWhite() {
        return color.equals(Color.WHITE);
    }
    public boolean isBlack() {
        return color.equals(Color.BLACK);
    }
}
