package org.pieces;

import java.util.*;

import org.chess.Board;
import org.chess.Coordinate;

public abstract class Piece implements Comparable<Piece>{
    public enum Color {
        WHITE, BLACK, NOCOLOR
    }

    public enum Type {
        PAWN('p', 1.0),
        ROOK('r', 5.0),
        KNIGHT('n', 2.5),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k', 0.0),
        NO_PIECE('.', 0.0);

        private final char representation;
        private final double defaultPoint;

        Type(char representation, double defaultPoint) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        public char getWhiteRepresentation() {
            return representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(representation);
        }

        public double getDefaultPoint() {
            return defaultPoint;
        }
    }

    public enum Direction {
        NORTH(0, 1),
        NORTHEAST(1, 1),
        EAST(1, 0),
        SOUTHEAST(1, -1),
        SOUTH(0, -1),
        SOUTHWEST(-1, -1),
        WEST(-1, 0),
        NORTHWEST(-1, 1),

        NNE(1, 2),
        NNW(-1, 2),
        SSE(1, -2),
        SSW(-1, -2),
        EEN(2, 1),
        EES(2, -1),
        WWN(-2, 1),
        WWS(-2, -1);

        private final int file;
        private final int rank;

        Direction(int file, int rank) {
            this.file = file;
            this.rank = rank;
        }

        public int getFileDegree() {
            return file;
        }

        public int getRankDegree() {
            return rank;
        }

        public static List<Direction> linearDirection() {
            return Arrays.asList(NORTH, EAST, SOUTH, WEST);
        }

        public static List<Direction> diagonalDirection() {
            return Arrays.asList(NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
        }

        public static List<Direction> everyDirection() {
            return Arrays.asList(NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST);
        }

        public static List<Direction> knightDirection() {
            return Arrays.asList(NNE, NNW, SSE, SSW, EEN, EES, WWN, WWS);
        }

        public static List<Direction> whitePawnMoveDirection() {
            return Arrays.asList(NORTH);
        }
        public static List<Direction> whitePawnAttackDirection() {
            return Arrays.asList(NORTHEAST, NORTHWEST);
        }

        public static List<Direction> blackPawnMoveDirection() {
            return Arrays.asList(SOUTH);
        }
        public static List<Direction> blackPawnAttackDirection() {
            return Arrays.asList(SOUTHEAST, SOUTHWEST);
        }
    }

    private final Color color;
    private final Type type;

    protected Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public double getPoint(){
        return type.getDefaultPoint();
    }

    @Override
    public int compareTo(Piece other){
        return Double.compare(this.getPoint(),other.getPoint());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Piece piece = (Piece) obj;
        return Objects.equals(color, piece.color) && Objects.equals(type, piece.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type); // color와 type이 같으면 같은 hashCode 반환
    }

    public char getRepresentation() {
        return color.equals(Color.WHITE) ? type.getWhiteRepresentation() : type.getBlackRepresentation();
    }

    public abstract boolean verifyMovePosition(Board board, Coordinate sourcePosition, Coordinate targetPosition);

    public static Piece createWhitePawn() {
        return new Pawn(Color.WHITE);
    }

    public static Piece createBlackPawn() {
        return new Pawn(Color.BLACK);
    }

    public static Piece createWhiteRook() {
        return new Rook(Color.WHITE);
    }

    public static Piece createBlackRook() {
        return new Rook(Color.BLACK);
    }

    public static Piece createWhiteKnight() {
        return new Knight(Color.WHITE);
    }

    public static Piece createBlackKnight() {
        return new Knight(Color.BLACK);
    }

    public static Piece createWhiteBishop() {
        return new Bishop(Color.WHITE);
    }

    public static Piece createBlackBishop() {
        return new Bishop(Color.BLACK);
    }

    public static Piece createWhiteQueen() {
        return new Queen(Color.WHITE);
    }

    public static Piece createBlackQueen() {
        return new Queen(Color.BLACK);
    }

    public static Piece createWhiteKing() {
        return new King(Color.WHITE);
    }

    public static Piece createBlackKing() {
        return new King(Color.BLACK);
    }

    public static Piece createBlank() {
        return new Blank(Color.NOCOLOR);
    }

    public boolean isBlack() {
        return color.equals(Color.BLACK);
    }

    public boolean isWhite() {
        return color.equals(Color.WHITE);
    }
}
