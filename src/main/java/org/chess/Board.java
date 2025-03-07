package org.chess;

import org.pieces.Piece;

import java.util.*;

import static org.utils.StringUtils.appendNewLine;

public class Board {
    private List<Rank> rankList = new ArrayList<>();

    public Board() {
    }

    public void initialize() {
        // 중요!
        // rankList는 rank에 따라 관리
        // 즉 rankList.get(0)을 하면 rank1번이 나오도록 관리함
        // 따라서 출력할 때 rank8부터 출력하도록 변경하면 됨
        rankList = new ArrayList<>();
        rankList.add(makeWhitePieceRank());
        rankList.add(makeWhitePawnPieceRank());
        for (int i = 0; i < 4; i++) {
            rankList.add(new Rank());
        }
        rankList.add(makeBlackPawnPieceRank());
        rankList.add(makeBlackPieceRank());
    }

    private Rank makeBlackPieceRank(){
        List<Piece> rank = new ArrayList<>();
        rank.add(Piece.createBlackRook());
        rank.add(Piece.createBlackKnight());
        rank.add(Piece.createBlackBishop());
        rank.add(Piece.createBlackQueen());
        rank.add(Piece.createBlackKing());
        rank.add(Piece.createBlackBishop());
        rank.add(Piece.createBlackKnight());
        rank.add(Piece.createBlackRook());
        return new Rank(rank);
    }

    private Rank makeWhitePieceRank(){
        List<Piece> rank = new ArrayList<>();
        rank.add(Piece.createWhiteRook());
        rank.add(Piece.createWhiteKnight());
        rank.add(Piece.createWhiteBishop());
        rank.add(Piece.createWhiteQueen());
        rank.add(Piece.createWhiteKing());
        rank.add(Piece.createWhiteBishop());
        rank.add(Piece.createWhiteKnight());
        rank.add(Piece.createWhiteRook());
        return new Rank(rank);
    }

    private Rank makeBlackPawnPieceRank(){
        List<Piece> rank = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Piece piece = Piece.createBlackPawn();
            rank.add(piece);
        }

        return new Rank(rank);
    }

    private Rank makeWhitePawnPieceRank(){
        List<Piece> rank = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Piece piece = Piece.createWhitePawn();
            rank.add(piece);
        }

        return new Rank(rank);
    }

    public void initializeEmpty() {
        for (int i = 0; i < 8; i++) {
            rankList.add(new Rank());
        }
    }

    public List<Rank> getRankList(){
        return rankList;
    }

    public Piece findPiece(String location) {
        Coordinate coordinate = parseCoordinate(location);
        int fileIndex = coordinate.getFileIndex();
        int rankIndex = coordinate.getRankIndex();
        return rankList.get(rankIndex).getPieceByFileIndex(fileIndex);
    }

    public void move(String sourcePosition, String targetPosition){
        Piece source = findPiece(sourcePosition);
        // target에 기물 추가
        putPiece(targetPosition,source);
        // 원래 자리에 blank 추가
        putPiece(sourcePosition,Piece.createBlank());
    }

    public void putPiece(String location, Piece piece) {
        Coordinate coordinate = parseCoordinate(location);
        int fileIndex = coordinate.getFileIndex();
        int rankIndex = coordinate.getRankIndex();
        rankList.get(rankIndex).putPieceByFileIndex(fileIndex, piece);
    }

    private Coordinate parseCoordinate(String location) {
        try {
            return new Coordinate(location);
        } catch (IllegalArgumentException e) {
            System.out.println("좌표 오류 : ");
            return null;
        }
    }




}
