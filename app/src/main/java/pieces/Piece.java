package pieces;

import java.util.Objects;

public class Piece {

    private final Color color;
    private final Type type;
    private final char representation;

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('p', 1.0),
        ROOK('r', 5.0),
        KNIGHT('n', 2.5),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k',0.0),
        NO_PIECE('.', 0.0);

        private char representation;
        private double defaultPoint;

        Type(char representation, double defaultPoint) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        public char getWhiteRepresentation(){
            return representation;
        }
        public char getBlackRepresentation(){
            return Character.toUpperCase(representation);
        }
        public double getdefaultPoint(){ return defaultPoint; }
    }

    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;

        char repre = type.representation;
        if (color == Color.BLACK) { repre = type.getBlackRepresentation(); }
        this.representation = repre;
    }

    private static Piece createWhite(Type type) {
        return new Piece(Color.WHITE, type);
    }
    private static Piece createBlack(Type type) {
        return new Piece(Color.BLACK, type);
    }
    public static Piece createWhitePawn(){ return createWhite(Type.PAWN); }
    public static Piece createBlackPawn(){ return createBlack(Type.PAWN);}
    public static Piece createWhiteRook(){ return createWhite(Type.ROOK); }
    public static Piece createBlackRook(){ return createBlack(Type.ROOK); }
    public static Piece createWhiteKnight(){ return createWhite(Type.KNIGHT); }
    public static Piece createBlackKnight(){ return createBlack(Type.KNIGHT); }
    public static Piece createWhiteBishop(){ return createWhite(Type.BISHOP); }
    public static Piece createBlackBishop(){ return createBlack(Type.BISHOP); }
    public static Piece createWhiteQueen(){ return createWhite(Type.QUEEN); }
    public static Piece createBlackQueen(){ return createBlack(Type.QUEEN); }
    public static Piece createWhiteKing(){ return createWhite(Type.KING); }
    public static Piece createBlackKing(){ return createBlack(Type.KING); }
    public static Piece createBlank(){
        return new Piece(Color.NOCOLOR,Type.NO_PIECE);
    }

    public boolean isWhite(){
        return color == Color.WHITE;
    }
    public boolean isBlack(){
        return color == Color.BLACK;
    }

    public Type getType(){
        return type;
    }
    public Color getColor() { return color;}



    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Piece piece = (Piece) obj;
        return color == piece.color && type == piece.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }
}
