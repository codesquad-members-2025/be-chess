package pieces;


public class Piece {
    private final Color color;
    private final Type type;

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


    private Piece(Color color, Type type)  {
        this.color = color;
        this.type = type;
    }
    public static Piece createWhite(Type type) {
        return new Piece(Color.WHITE, type);
    }
    public static Piece createBlack(Type type) {
        return new Piece(Color.BLACK, type);
    }
    public static Piece createBlank() {
        return new Piece(Color.NOCOLOR, Type.NO_PIECE);
    }


    public char getRepresentation() {
        return color == Color.WHITE? type.getWhiteRepresentation() : type.getBlackRepresentation();
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public boolean isWhite() {
        return color.equals(Color.WHITE);
    }

    public boolean isBlack() {
        return color.equals(Color.BLACK);
    }

    @Override
    //Unit의 assertThat(A).isEqualTo(B)는 내부적으로 equals()를 자동 호출
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Piece piece = (Piece) obj;
        return color == piece.color && type == piece.type;
    }

}

