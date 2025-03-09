package org.pieces;

import org.chess.Board;
import org.chess.Coordinate;
import java.util.HashSet;
import java.util.Set;

public class Rook extends Piece{
    public Rook(Color color){
        super(color,Type.ROOK);
    }

    @Override
    public boolean verifyMovePosition(Board board, Coordinate sourcePosition, Coordinate targetPosition){
        // coordinateSet은 이동가능한 Coordinate의 모음
        Set<Coordinate> coordinateSet = new HashSet<>();
        for(Direction direction : Direction.linearDirection()){
            int fileDegree = direction.getFileDegree();
            int rankDegree = direction.getRankDegree();
            for(int i = 1; i<8;i++){
                Coordinate movedCoordinate = sourcePosition.shiftCoordinate(fileDegree*i,rankDegree*i);
                // 보드를 벗어나거나 같은 색의 기물이 있으면 멈춤
                if(!movedCoordinate.isCoordinateOnBoard() || board.findPiece(movedCoordinate).getColor() == getColor()) break;
                coordinateSet.add(movedCoordinate);
                // 만약 이동하려는 지점이 다른색의 기물이면 추가는 하지만 멈춤
                if(board.findPiece(movedCoordinate).getColor() != getColor()) break;
            }
        }
        return coordinateSet.contains(targetPosition);
    }
}
