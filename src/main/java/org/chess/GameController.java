package org.chess;

import org.pieces.Piece;

import java.util.List;

public class GameController {
    private final Board board;

    public GameController(Board board) {
        this.board = board;
    }

    public void move(String sourcePosition, String targetPosition) {
        Piece source = findPiece(sourcePosition);
        // target에 기물 추가
        putPiece(targetPosition, source);
        // 원래 자리에 blank 추가
        putPiece(sourcePosition, Piece.createBlank());
    }

    public Piece findPiece(String location) {
        Coordinate coordinate = parseCoordinate(location);
        int fileIndex = coordinate.getFileIndex();
        int rankIndex = coordinate.getRankIndex();
        return rankList().get(rankIndex).getPieceByFileIndex(fileIndex);
    }

    public void putPiece(String location, Piece piece) {
        Coordinate coordinate = parseCoordinate(location);
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
