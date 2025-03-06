package org.chess;

import org.pieces.Piece;

import java.util.*;

import static org.utils.StringUtils.appendNewLine;

public class Board {
    private final List<Rank> rankList = new ArrayList<>();

    public Board() {
    }

    public void initialize() {
        // 중요!
        // rankList는 rank에 따라 관리
        // 즉 rankList.get(0)을 하면 rank1번이 나오도록 관리함
        // 따라서 출력할 때 rank8부터 출력하도록 변경하면 됨
        List<Piece> rank1 = new ArrayList<>();
        rank1.add(Piece.createWhiteRook());
        rank1.add(Piece.createWhiteKnight());
        rank1.add(Piece.createWhiteBishop());
        rank1.add(Piece.createWhiteQueen());
        rank1.add(Piece.createWhiteKing());
        rank1.add(Piece.createWhiteBishop());
        rank1.add(Piece.createWhiteKnight());
        rank1.add(Piece.createWhiteRook());

        List<Piece> rank2 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Piece piece = Piece.createWhitePawn();
            rank2.add(piece);
        }

        List<Piece> rank7 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Piece piece = Piece.createBlackPawn();
            rank7.add(piece);
        }

        List<Piece> rank8 = new ArrayList<>();
        rank8.add(Piece.createBlackRook());
        rank8.add(Piece.createBlackKnight());
        rank8.add(Piece.createBlackBishop());
        rank8.add(Piece.createBlackQueen());
        rank8.add(Piece.createBlackKing());
        rank8.add(Piece.createBlackBishop());
        rank8.add(Piece.createBlackKnight());
        rank8.add(Piece.createBlackRook());

        rankList.add(new Rank(rank1));
        rankList.add(new Rank(rank2));
        for (int i = 0; i < 4; i++) {
            rankList.add(new Rank());
        }
        rankList.add(new Rank(rank7));
        rankList.add(new Rank(rank8));
    }

    public void initializeEmpty(){
        for(int i = 0 ; i<8;i++){
            rankList.add(new Rank());
        }
    }

    public int pieceCount() {
        int count = 0;
        for (Rank rank : rankList) {
            count += rank.getTotalPieceCount();
        }
        return count;
    }

    public String showBoard() {
        // 중요!
        // rankList는 rank에 따라 관리
        // 즉 rankList.get(0)을 하면 rank1번이 나오도록 관리함
        // 따라서 출력할 때 rank8부터 출력하도록 변경하면 됨
        StringBuilder sb = new StringBuilder();
        for (int i = rankList.size() - 1; i >= 0; i--) {
            sb.append(appendNewLine(rankList.get(i).print()));
        }
        return sb.toString();
    }

    public int getPieceCount(Piece.Color color, Piece.Type type) {
        int count = 0;
        for (Rank rank : rankList) {
            count += rank.getPieceCount(color, type);
        }
        return count;
    }

    private int getFileIndex(String coordinate){
        return coordinate.charAt(0)-'a';
    }

    private int getRankIndex(String coordinate){
        return Character.getNumericValue(coordinate.charAt(1))-1;
    }

    public Piece findPiece(String coordinate){
        int fileIndex = getFileIndex(coordinate);
        int rankIndex = getRankIndex(coordinate);
        return rankList.get(rankIndex).getPieceByFileIndex(fileIndex);
    }

    public void move(String coordinate,Piece piece){
        int fileIndex = getFileIndex(coordinate);
        int rankIndex = getRankIndex(coordinate);
        rankList.get(rankIndex).putPieceByFileIndex(fileIndex,piece);
    }
}
