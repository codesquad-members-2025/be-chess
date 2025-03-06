package org.chess;

import org.pieces.Piece;

import java.util.*;

import static org.utils.StringUtils.appendNewLine;

public class Board {
    private final List<Rank> rankList = new ArrayList<>();
    private List<Piece> whitePieceList = new ArrayList<>();
    private List<Piece> blackPieceList = new ArrayList<>();

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

    public Piece findPiece(String location){
        Coordinate coordinate = parseCoordinate(location);
        int fileIndex = coordinate.getFileIndex();
        int rankIndex = coordinate.getRankIndex();
        return rankList.get(rankIndex).getPieceByFileIndex(fileIndex);
    }

    public void move(String location,Piece piece){
        Coordinate coordinate = parseCoordinate(location);
        int fileIndex = coordinate.getFileIndex();
        int rankIndex = coordinate.getRankIndex();
        rankList.get(rankIndex).putPieceByFileIndex(fileIndex,piece);
    }

    private Coordinate parseCoordinate(String location){
        try{
            return new Coordinate(location);
        } catch(IllegalArgumentException e){
            System.out.println("좌표 오류 : ");
            return null;
        }
    }

    public double calculatePoint(Piece.Color color){
        int[] pawnLocation = {0,0,0,0,0,0,0,0};
        double point = 0.0;
        for(Rank rank : rankList){
            for(int i=0;i<8;i++){
                Piece piece = rank.getPieceByFileIndex(i);
                if(piece.getColor()==color) point += piece.getPoint();
                // 폰이 같은 열에 있으면 감점되기 때문에 폰의 위치만 따로 관리
                if(piece.getColor()==color && piece.getType()==Piece.Type.PAWN) pawnLocation[i]+=1;
            }
        }
        for(int pawnCount : pawnLocation){
            if(pawnCount>1) point -= (double) pawnCount/2;
        }

        return point;
    }

    public List<Piece> makePieceList(Piece.Color color){
        List<Piece> sameColorPieces = new ArrayList<>();
        for(Rank rank : rankList){
            for(int i = 0 ; i<8;i++){
                Piece piece = rank.getPieceByFileIndex(i);
                if(piece.getColor()==color) sameColorPieces.add(piece);
            }
        }
        return sameColorPieces;
    }

    public List<Piece> makeAndSortWhitePieceList(boolean isAscending){
        List<Piece> whiteList = makePieceList(Piece.Color.WHITE);
        Collections.sort(whiteList);
        if(!isAscending) Collections.reverse(whiteList);
        return whiteList;
    }

    public List<Piece> makeAndSortBlackPieceList(boolean isAscending){
        List<Piece> blackList = makePieceList(Piece.Color.BLACK);
        Collections.sort(blackList);
        if(!isAscending) Collections.reverse(blackList);
        return blackList;
    }

}
