package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {
    private List<Piece> chessPiecesList;

    private List<Piece> whitePawnsList;
    private List<Piece> blackPawnsList;
//    private static final int TOTAL_PAWNS_PER_PLAYER = 8;

    private String whitePawnsResult;
    private String blackPawnsResult;

    public void add(Piece pawn){
        chessPiecesList.add(pawn);
    }

    public int size(){
        return chessPiecesList.size();
    }

    public Piece findPawn(int pawnNumber){
        return chessPiecesList.get(pawnNumber);
    }

    public void initialize(){
        whitePawnsList = new ArrayList<>();
        blackPawnsList = new ArrayList<>();

        for(int i = 0; i < 8; i++){
            whitePawnsList.add(Piece.createPiece(Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION));
            blackPawnsList.add(Piece.createPiece(Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION));
        }

        initializeWhitePawnsResult();
        initializeBlackPawnsResult();
    }


    private void initializeWhitePawnsResult() {
        StringBuilder whitePawnSb = new StringBuilder();

        for (int i = 0; i < whitePawnsList.size(); i++){
            whitePawnSb.append(whitePawnsList.get(i).getRepresentation());
        }

        whitePawnsResult = whitePawnSb.toString();
    }


    private void initializeBlackPawnsResult() {
        StringBuilder blackPawnSb = new StringBuilder();

        for (int i = 0; i < blackPawnsList.size(); i++){
            blackPawnSb.append(blackPawnsList.get(i).getRepresentation());
        }

        blackPawnsResult = blackPawnSb.toString();
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 8; i++){
            if(i == 1) {
                sb.append(appendNewLine(blackPawnsResult));
                continue;
            }
            if(i == 6) {
                sb.append(appendNewLine(whitePawnsResult));
                continue;
            }
            sb.append(appendNewLine("........"));
        }
        return sb.toString();
    }


    public Board() {
        chessPiecesList = new ArrayList<>();
    }

    public String getWhitePawnsResult() {
        return whitePawnsResult;
    }

    public String getBlackPawnsResult() {
        return blackPawnsResult;
    }
}
