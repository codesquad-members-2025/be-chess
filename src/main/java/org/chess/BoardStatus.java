package org.chess;

import org.pieces.Piece;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.utils.StringUtils.appendNewLine;

public class BoardStatus {
    private final Board board;

    public BoardStatus(Board board){
        this.board = board;
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

    public String showBoard() {
        // 중요!
        // rankList는 rank에 따라 관리
        // 즉 rankList.get(0)을 하면 rank1번이 나오도록 관리함
        // 따라서 출력할 때 rank8부터 출력하도록 변경하면 됨
        StringBuilder sb = new StringBuilder();
        for (int i = rankList().size() - 1; i >= 0; i--) {
            sb.append(appendNewLine(rankList().get(i).print()));
        }
        return sb.toString();
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
