package org.chess;

import org.pieces.Piece;

import java.util.List;

public class Game {
    private final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void move(String sourcePosition, String targetPosition) {
        Coordinate sourceCoordinate = new Coordinate(sourcePosition);
        Coordinate targetCoordinate = new Coordinate(targetPosition);

        Piece source = board.findPiece(sourceCoordinate);
        // 그 기물이 이동할 수 없음!
        if (!source.verifyMovePosition(board,sourceCoordinate,targetCoordinate)) {
            System.out.println("이동할 수 없습니다.");
            return;
        }
        // 이동 가능하면 이동!
        // target에 기물 추가
        board.putPiece(targetCoordinate, source);
        // 원래 자리에 blank 추가
        board.putPiece(sourceCoordinate, Piece.createBlank());
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
