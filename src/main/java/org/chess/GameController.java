package org.chess;

import org.pieces.Piece;

import java.util.List;

public class GameController {
    private final Board board;

    public GameController(Board board) {
        this.board = board;
    }

    public void move(String sourcePosition, String targetPosition) {
        Coordinate sourceCoordinate = new Coordinate(sourcePosition);
        Coordinate targetCoordinate = new Coordinate(targetPosition);

        Piece source = findPiece(sourceCoordinate);
        // 그 기물의 이동범위가 아님!
        if (!source.verifyMovePosition(sourceCoordinate,targetCoordinate)) {
            System.out.println("이동 범위가 아닙니다.");
            return;
        }
        // 도착 지점이 같은 색의 기물이라면 이동 불가!
        if(findPiece(targetCoordinate).getColor()==source.getColor()) {
            System.out.println("도착지점이 같은 색의 기물입니다.");
            return;
        }
        // 이동 가능하면 이동!
        // target에 기물 추가
        putPiece(targetCoordinate, source);
        // 원래 자리에 blank 추가
        putPiece(sourceCoordinate, Piece.createBlank());
    }

    public Piece findPiece(Coordinate coordinate) {
        int fileIndex = coordinate.getFileIndex();
        int rankIndex = coordinate.getRankIndex();
        return rankList().get(rankIndex).getPieceByFileIndex(fileIndex);
    }

    public void putPiece(Coordinate coordinate, Piece piece) {
        int fileIndex = coordinate.getFileIndex();
        int rankIndex = coordinate.getRankIndex();
        rankList().get(rankIndex).putPieceByFileIndex(fileIndex, piece);
    }

    private Coordinate parseCoordinate(String location) {
        try {
            return new Coordinate(location);
        } catch (IllegalArgumentException e) {
            System.out.println("좌표 오류 : ");
            return null;
        }
    }

    private List<Rank> rankList() {
        return board.getRankList();
    }
}
