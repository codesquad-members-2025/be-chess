package pieces;

import chess.Position;
import chess.Board;
import chess.Direction;

import java.util.List;


public abstract class Piece implements Comparable<Piece> {
    protected final Color color;
    protected final Type type;

    public enum Color {
        WHITE, BLACK, NOCOLOR;
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

        public double getDefaultPoint() {
            return defaultPoint;
        }

        public char getWhiteRepresentation() {
            return representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(representation);
        }
    }


    protected Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
    }

    public char getRepresentation() {
        return color == Color.WHITE ? type.getWhiteRepresentation() : type.getBlackRepresentation();
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

    public double getDefaultPoint() {
        return this.type.getDefaultPoint();
    }

    @Override
    //Unit의 assertThat(A).isEqualTo(B)는 내부적으로 equals()를 자동 호출
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Piece piece = (Piece) obj;
        return color == piece.color && type == piece.type;
    }

    @Override
    public int compareTo(Piece other) {
        return Double.compare(other.getDefaultPoint(), this.getDefaultPoint());
    }

    //추상 메서드: 하위 클래스(King, Queen 등)에서 반드시 구현해야 함.
    public abstract boolean canMove(Position source, Position target, Board board);

    protected boolean isSameColorPiece(Position target, Board board) {
        Piece targetPiece = board.getRank(target.getRow()).getPiece(target.getCol());
        return targetPiece.getColor() == this.color;

    }

    protected boolean isPathClear(Position position, Board board) {
        return board.getPiece(position.getRow(), position.getCol()).getType().equals(Type.NO_PIECE);
    }

    protected boolean canMoveRecursive(Position current, Position target, Direction direction, Board board) {
        // 한 칸 이동한 새로운 위치 계산
        Position nextPosition = new Position(
                current.getRow() + direction.getYDegree(),
                current.getCol() + direction.getXDegree()
        );


        if (!board.isValidPosition(nextPosition)) {
            return false;
        }

        // 목표 위치에 도달했으면 같은 색 기물인지 확인 후 이동 가능 여부 반환 -> true
        if (nextPosition.equals(target)) {
            return !isSameColorPiece(target, board);
        }

        // 중간에 기물이 있으면 이동 불가
        if (!isPathClear(nextPosition, board)) {
            return false;
        }

        return canMoveRecursive(nextPosition, target, direction, board);
    }
}
