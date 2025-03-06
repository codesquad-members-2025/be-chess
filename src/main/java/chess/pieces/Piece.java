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

    public static Piece createBlank() {
        return new Piece(Type.NO_PIECE, Color.NOCOLOR);
    }

    public static Piece createWhite(Type type) {
        return new Piece(type, Color.WHITE);
    }
    public static Piece createBlack(Type type) {
        return new Piece(type, Color.BLACK);
    }
    public static Piece createPieceByRepresentation(char representation) {
        for (Type value : Type.values()) {
            if (value.getRepresentation(Color.WHITE) == representation){
                return Piece.createWhite(value);
            }
            if (value.getRepresentation(Color.BLACK) == representation){
                return Piece.createBlack(value);
            }
        }
        return Piece.createBlank();
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
