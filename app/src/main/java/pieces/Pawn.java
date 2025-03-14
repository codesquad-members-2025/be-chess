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

        if (validGoTwoStep(target, board)) {
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
                    break;
                case SOUTHEAST, SOUTHWEST, NORTHEAST, NORTHWEST:
                    if (next.equals(target)) {
                        return isMatchDiagonal(next, board);
                    }
                    break;
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

    private boolean validGoTwoStep(Position target, Board board) {
        Position cur = getPosition();
        int dy = cur.getY() - target.getY();
        int row = isWhite() ? 6 : 1;

        if (Math.abs(dy) == 2 && cur.getY() == row && isValid(target)) {
            int midY = isWhite() ? cur.getY() - 1 : cur.getY() + 1;
            Position midPosition = new Position("" + (char) ('a' + cur.getX()) + (8 - midY));

            if (!board.findPiece(midPosition).getType().equals(Type.NO_PIECE)) {
                return false;
            }
            return board.findPiece(target).getType().equals(Type.NO_PIECE);
        }
        return false;
    }


    @Override
    public List<Direction> getDirections() {
        return isWhite() ? Direction.whitePawnDirection() : Direction.blackPawnDirection();
    }
}
