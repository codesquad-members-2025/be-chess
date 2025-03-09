package chess.piece;

import chess.enums.Color;
import chess.record.Position;

public abstract class Piece {


    protected final Color color;
    protected Position currentPosition;

    protected Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public static Piece createBlank(){
        return new Piece(Color.NOCOLOR) {
            @Override
            public char getSymbol() {
                return '.';
            }

            @Override
            public double getPoint() {
                return 0;
            }

            @Override
            public boolean canMove(Position position) {
                return false;
            }
        };
    }

    public abstract char getSymbol();

    public abstract double getPoint();

    public abstract boolean canMove(Position position);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Piece piece = (Piece) obj;
        return color == piece.color;
    }
}
