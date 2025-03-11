package pieces;

import java.util.Objects;

public abstract class Piece {

    private final Color color;
    private final Type type;
    private final Position position;
    private final char representation;

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    protected Piece(Color color, Type type, Position position) {
        this.color = color;
        this.type = type;
        this.position = position;

        if (color == Color.BLACK) {
            this.representation = type.getBlackRepresentation();
        } else {
            this.representation = type.getWhiteRepresentation();
        }
    }

    public abstract boolean canMove(Position target);

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
