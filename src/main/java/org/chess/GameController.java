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
