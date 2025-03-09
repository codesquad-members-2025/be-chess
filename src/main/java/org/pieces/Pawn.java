package org.pieces;

import org.chess.Board;
import org.chess.Coordinate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pawn extends Piece{
    public Pawn(Color color){
        super(color,Type.PAWN);
    }

    @Override
    public boolean verifyMovePosition(Board board, Coordinate sourcePosition, Coordinate targetPosition){
        Set<Coordinate> coordinateSet = new HashSet<>();
        // 폰의 색에 따라 움직이는 게 다름
        List<Direction> moveDirectionList = isBlack() ? Direction.blackPawnMoveDirection() : Direction.whitePawnMoveDirection();
        List<Direction> attackDirectionList = isBlack() ? Direction.blackPawnAttackDirection() : Direction.whitePawnAttackDirection();
        for(Direction direction : moveDirectionList){
            int fileDegree = direction.getFileDegree();
            int rankDegree = direction.getRankDegree();
            Coordinate movedCoordinate = sourcePosition.shiftCoordinate(fileDegree,rankDegree);
            // 이동은 Blank 일 때만 가능
            if(movedCoordinate.isCoordinateOnBoard() && board.findPiece(movedCoordinate).getType() == Type.NO_PIECE) coordinateSet.add(movedCoordinate);
        }
        for(Direction direction : attackDirectionList){
            int fileDegree = direction.getFileDegree();
            int rankDegree = direction.getRankDegree();
            Coordinate movedCoordinate = sourcePosition.shiftCoordinate(fileDegree,rankDegree);
            // 공격은 다른 색일 때만 가능
            if(movedCoordinate.isCoordinateOnBoard() && board.findPiece(movedCoordinate).getColor() != getColor()) coordinateSet.add(movedCoordinate);
        }

        return coordinateSet.contains(targetPosition);
    }
}
