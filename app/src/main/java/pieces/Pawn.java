package pieces;

import chess.Board;
import java.util.List;

public class Pawn extends Piece {
    private Pawn(Color color, Position position) {
        super(color, Type.PAWN, position);
    }

    public static Pawn createPawn(Color color, Position position) {
        return new Pawn(color, position);
    }

    @Override
    public boolean canMove(Position target, Board board) {
        //Todo: 끝까지가면 다른 기물로 변환

        if (validGoTwoStep(target)) {
            return true;
        }

        Position cur = getPosition();
        for (Direction direction : getDirections()) {
            Position next = cur.move(direction);
            switch (direction) {
                case NORTH, SOUTH:
                    if (next.equals(target)) {
                        return isMatchForward(next, board);
                    }
                case SOUTHEAST, SOUTHWEST, NORTHEAST, NORTHWEST:
                    if (next.equals(target)) {
                        return isMatchDiagonal(next, board);
                    }
            }
        }
        return false;
    }

    private boolean isMatchDiagonal(Position target, Board board){
        Piece targetPiece = board.findPiece(target);
        return !targetPiece.getType().equals(Type.NO_PIECE) && !targetPiece.getColor().equals(getColor());
    }

    private boolean isMatchForward(Position target, Board board){
        Piece targetPiece = board.findPiece(target);
        return targetPiece.getType().equals(Type.NO_PIECE);
    }

    private boolean isValid(Position position) {
        return position.getX() >= 0 && position.getX() < 8 &&
                position.getY() >= 0 && position.getY() < 8;
    }

    private boolean validGoTwoStep(Position target) {
        Position cur = getPosition();
        //Todo: 이거 2인경우 -2를 해도 될 가능성이 있음 이거 그냥 범위만 잘 해주면 될듯?
        int dy = cur.getY() - target.getY();
        int row = isWhite() ? 6 : 1;
        if (Math.abs(dy) == 2 && cur.getY() == row && isValid(target)) {
            return true;
        }
        return false;
    }

    @Override
    public List<Direction> getDirections() {
        return isWhite() ? Direction.whitePawnDirection() : Direction.blackPawnDirection();
    }
}
