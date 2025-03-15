package pieces;

import java.util.Objects;

public class Piece {

    private final Color color;
    private final Type type;

    public enum Color{
        WHITE("white"), BLACK("black"), NOCOLOR("noColor");

        private final String color;

        Color(String color){
            this.color = color;
        }

        public String getColor(){
            return color;
        }
    }

    public enum Type{
        PAWN('p', 1.0),
        KNIGHT('n', 2.5),
        ROOK('r', 5.0),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k', 0.0),
        NO_PIECE('.', 0.0);

        private final char representation;
        private final double defaultPoint;

        Type(char representation, double defaultPoint){
            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        public char getWhiteRepresentation(){
            return representation;
        }

        public char getBlackRepresentation(){return Character.toUpperCase(representation);}

        public double getDefaultPoint(){return defaultPoint;}
    }

    private Piece(Color color, Type type){
        this.color = color;
        this.type = type;
    }

    private static Piece createWhite(Type type){
        return new Piece(Color.WHITE, type);
    }

    private static Piece createBlack(Type type){
        return new Piece(Color.BLACK, type);
    }


    public static Piece createPiece(Color color, Type type){
        return new Piece(color, type);
    }

    public static Piece createWhitePawn(){return createWhite(Type.PAWN);}

    public static Piece createBlackPawn(){
        return createBlack(Type.PAWN);
    }

    public static Piece createWhiteKnight(){
        return createWhite(Type.KNIGHT);
    }

    public static Piece createBlackKnight(){
        return createBlack(Type.KNIGHT);
    }

    public static Piece createWhiteRook(){
        return createWhite(Type.ROOK);
    }

    public static Piece createBlackRook(){
        return createBlack(Type.ROOK);
    }

    public static Piece createWhiteBishop(){
        return createWhite(Type.BISHOP);
    }

    public static Piece createBlackBishop(){
        return createBlack(Type.BISHOP);
    }

    public static Piece createWhiteQueen(){
        return createWhite(Type.QUEEN);
    }

    public static Piece createBlackQueen(){
        return createBlack(Type.QUEEN);
    }

    public static Piece createWhiteKing(){
        return createWhite(Type.KING);
    }

    public static Piece createBlackKing(){
        return createBlack(Type.KING);
    }

    public static Piece createBlank(){
        return new Piece(Color.NOCOLOR, Type.NO_PIECE);
    }

    public Color getColor(){return color;}

    public Type getType(){
        return type;
    }

    public boolean isWhite(){
        return color.equals(Color.WHITE);
    }

    public boolean isBlack(){
        return color.equals(Color.BLACK);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return color == piece.color && type == piece.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }

}
