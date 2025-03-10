package pieces;

import java.util.Objects;

public class Piece {

    private final Color color;
    private final Type type;
    private final Position position;
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
    }

    private Piece(Color color, Type type, Position position) {
        this.color = color;
        this.type = type;
        this.position = position;

        if (color == Color.BLACK) {
            this.representation = type.getBlackRepresentation();
        } else {
            this.representation = type.getWhiteRepresentation();
        }
    }

    private static Piece createWhite(Type type, Position position) {
        return new Piece(Color.WHITE, type, position);
    }
    private static Piece createBlack(Type type, Position position) {
        return new Piece(Color.BLACK, type, position);
    }
    public static Piece createWhitePawn(Position position){ return createWhite(Type.PAWN, position); }
    public static Piece createBlackPawn(Position position){ return createBlack(Type.PAWN, position);}
    public static Piece createWhiteRook(Position position){ return createWhite(Type.ROOK, position); }
    public static Piece createBlackRook(Position position){ return createBlack(Type.ROOK, position); }
    public static Piece createWhiteKnight(Position position){ return createWhite(Type.KNIGHT, position); }
    public static Piece createBlackKnight(Position position){ return createBlack(Type.KNIGHT, position); }
    public static Piece createWhiteBishop(Position position){ return createWhite(Type.BISHOP, position); }
    public static Piece createBlackBishop(Position position){ return createBlack(Type.BISHOP, position); }
    public static Piece createWhiteQueen(Position position){ return createWhite(Type.QUEEN, position); }
    public static Piece createBlackQueen(Position position){ return createBlack(Type.QUEEN, position); }
    public static Piece createWhiteKing(Position position){ return createWhite(Type.KING, position); }
    public static Piece createBlackKing(Position position){ return createBlack(Type.KING, position); }
    public static Piece createBlank(Position position) {
        return new Piece(Color.NOCOLOR,Type.NO_PIECE, position);
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
    public String toString() {
        return String.valueOf(representation);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Piece piece = (Piece) obj;
        return color == piece.color && type == piece.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, position);
    }
}
