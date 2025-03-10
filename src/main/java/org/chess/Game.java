package org.chess;

import org.pieces.Piece;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void move(String sourcePosition, String targetPosition) {
        Coordinate sourceCoordinate;
        Coordinate targetCoordinate;
        try{
            sourceCoordinate = new Coordinate(sourcePosition);
            targetCoordinate = new Coordinate(targetPosition);
        } catch(IllegalArgumentException e){
            System.out.println("잘못된 입력입니다. "+e.getMessage());
            return;
        }

        if(!sourceCoordinate.isCoordinateOnBoard() || !targetCoordinate.isCoordinateOnBoard()) {
            System.out.println("잘못된 좌표 입니다.");
            return;
        }

        Piece sourcePiece = board.findPiece(sourceCoordinate);
        // 그 기물이 이동할 수 없음!
        if (!sourcePiece.verifyMovePosition(board,sourceCoordinate,targetCoordinate)) {
            System.out.println(targetPosition+"으로 이동할 수 없습니다.");
            return;
        }
        // 이동 가능하면 이동!
        // target에 기물 추가
        board.putPiece(targetCoordinate, sourcePiece);
        // 원래 자리에 blank 추가
        board.putPiece(sourceCoordinate, Piece.createBlank());
    }

    public int pieceCount() {
        int count = 0;
        for (Rank rank : rankList()) {
            count += rank.getTotalPieceCount();
        }
        return count;
    }

    public int getPieceCount(Piece.Color color, Piece.Type type) {
        int count = 0;
        for (Rank rank : rankList()) {
            count += rank.getPieceCount(color, type);
        }
        return count;
    }

    public double calculatePoint(Piece.Color color) {
        int[] pawnLocation = {0, 0, 0, 0, 0, 0, 0, 0};
        double point = 0.0;
        for (Rank rank : rankList()) {
            for (int i = 0; i < 8; i++) {
                Piece piece = rank.getPieceByFileIndex(i);
                if (piece.getColor() == color) point += piece.getPoint();
                // 폰이 같은 열에 있으면 감점되기 때문에 폰의 위치만 따로 관리
                if (piece.getColor() == color && piece.getType() == Piece.Type.PAWN) pawnLocation[i] += 1;
            }
        }
        for (int pawnCount : pawnLocation) {
            if (pawnCount > 1) point -= (double) pawnCount / 2;
        }
        return point;
    }

    private List<Piece> makePieceList(Piece.Color color) {
        List<Piece> sameColorPieces = new ArrayList<>();
        for (Rank rank : rankList()) {
            for (int i = 0; i < 8; i++) {
                Piece piece = rank.getPieceByFileIndex(i);
                if (piece.getColor() == color) sameColorPieces.add(piece);
            }
        }
        return sameColorPieces;
    }

    public List<Piece> makeAndSortPieceList(Piece.Color color, boolean isAscending) {
        List<Piece> sortedPieceList = makePieceList(color);
        Collections.sort(sortedPieceList);
        if (!isAscending) Collections.reverse(sortedPieceList);
        return sortedPieceList;
    }

    private List<Rank> rankList(){
        return board.getRankList();
    }

}
