package org.pieces;

import org.chess.Board;
import org.chess.Coordinate;
import java.util.HashSet;
import java.util.Set;

public class King extends Piece{
    public King(Color color){
        super(color,Type.KING);
    }

    @Override
    public boolean verifyMovePosition(Board board, Coordinate sourcePosition, Coordinate targetPosition){
        Set<Coordinate> coordinateSet = new HashSet<>();
        for(Direction direction : Direction.everyDirection()){
            int fileDegree = direction.getFileDegree();
            int rankDegree = direction.getRankDegree();
            Coordinate movedCoordinate = sourcePosition.shiftCoordinate(fileDegree,rankDegree);
            // 보드 위에 있으며 이동할 자리가 같은 색이 아닐때 이동 가능
            if(movedCoordinate.isCoordinateOnBoard() && board.findPiece(movedCoordinate).getColor() != getColor()) coordinateSet.add(movedCoordinate);
        }
        return coordinateSet.contains(targetPosition);
    }
}
