package pieces;

import chess.Board;
import java.util.*;

public abstract class Piece {

    private final Color color;
    private final Type type;
    private Position position;
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

    public static Piece create(Type type, Color color, Position position) {
        switch (type) {
            case ROOK -> { return Rook.createRook(color, position); }
            case KNIGHT -> { return Knight.createKnight(color, position); }
            case BISHOP -> { return Bishop.createBishop(color, position); }
            case QUEEN -> { return Queen.createQueen(color, position); }
            case KING -> { return King.createKing(color, position); }
            case PAWN -> { return Pawn.createPawn(color, position); }
            default -> { return Blank.createBlank(position); }
        }
    }

    public abstract boolean canMove(Position target, Board board);
    public abstract List<Direction> getDirections();

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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
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
