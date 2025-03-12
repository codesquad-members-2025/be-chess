package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {

    private ArrayList<ArrayList<Piece>> board;

    private List<Piece> chessPiecesList;

    private List<Piece> whiteChessPiecesList;
    private List<Piece> blackChessPiecesList;

    private List<Piece> whitePawnsList;
    private List<Piece> blackPawnsList;
//    private static final int TOTAL_PAWNS_PER_PLAYER = 8;

    private String whitePiecesResult;
    private String blackPiecesResult;

    private String whitePawnsResult;
    private String blackPawnsResult;

    public void initialize(){
        whitePawnsList = new ArrayList<>();
        blackPawnsList = new ArrayList<>();
        whiteChessPiecesList = new ArrayList<>();
        blackChessPiecesList = new ArrayList<>();

        blackChessPiecesList.add(Piece.createPiece(Piece.Color.BLACK, Piece.Type.ROOK));
        blackChessPiecesList.add(Piece.createPiece(Piece.Color.BLACK, Piece.Type.KNIGHT));
        blackChessPiecesList.add(Piece.createPiece(Piece.Color.BLACK, Piece.Type.BISHOP));
        blackChessPiecesList.add(Piece.createPiece(Piece.Color.BLACK, Piece.Type.QUEEN));
        blackChessPiecesList.add(Piece.createPiece(Piece.Color.BLACK, Piece.Type.KING));
        blackChessPiecesList.add(Piece.createPiece(Piece.Color.BLACK, Piece.Type.BISHOP));
        blackChessPiecesList.add(Piece.createPiece(Piece.Color.BLACK, Piece.Type.KNIGHT));
        blackChessPiecesList.add(Piece.createPiece(Piece.Color.BLACK, Piece.Type.ROOK));

        for(int i = 0; i < 8; i++){
            blackPawnsList.add(Piece.createPiece(Piece.Color.BLACK, Piece.Type.PAWN));
            whitePawnsList.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.PAWN));
        }

        whiteChessPiecesList.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.ROOK));
        whiteChessPiecesList.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.KNIGHT));
        whiteChessPiecesList.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.BISHOP));
        whiteChessPiecesList.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.QUEEN));
        whiteChessPiecesList.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.KING));
        whiteChessPiecesList.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.BISHOP));
        whiteChessPiecesList.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.KNIGHT));
        whiteChessPiecesList.add(Piece.createPiece(Piece.Color.WHITE, Piece.Type.ROOK));

        initializeWhitePawnsResult();
        initializeBlackPawnsResult();
        initializeWhitePiecesResult();
        initializeBlackPiecesResult();
    }


    private void initializeWhitePawnsResult() {
        StringBuilder whitePawnSb = new StringBuilder();

        for (int i = 0; i < whitePawnsList.size(); i++){
            whitePawnSb.append(whitePawnsList.get(i).getType().getWhiteRepresentation());
        }

        whitePawnsResult = whitePawnSb.toString();
    }

    private void initializeWhitePiecesResult() {
        StringBuilder whitePiecesSb = new StringBuilder();

        for (int i = 0; i < whiteChessPiecesList.size(); i++){
            whitePiecesSb.append(whiteChessPiecesList.get(i).getType().getWhiteRepresentation());
        }

        whitePiecesResult = whitePiecesSb.toString();
    }

    private void initializeBlackPawnsResult() {
        StringBuilder blackPawnSb = new StringBuilder();

        for (int i = 0; i < blackPawnsList.size(); i++){
            blackPawnSb.append(blackPawnsList.get(i).getType().getBlackRepresentation());
        }

        blackPawnsResult = blackPawnSb.toString();
    }

    private void initializeBlackPiecesResult() {
        StringBuilder blackPiecesSb = new StringBuilder();

        for (int i = 0; i < blackChessPiecesList.size(); i++){
            blackPiecesSb.append(blackChessPiecesList.get(i).getType().getBlackRepresentation());
        }

        blackPiecesResult = blackPiecesSb.toString();
    }

    public int pieceCount(){
        return whiteChessPiecesList.size() + blackChessPiecesList.size() + whitePawnsList.size() + blackPawnsList.size();
    }

    public String showBoard(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 8; i++){
            if(i == 0){
                sb.append(appendNewLine(blackPiecesResult));
                continue;
            }
            if(i == 1) {
                sb.append(appendNewLine(blackPawnsResult));
                continue;
            }
            if(i == 6) {
                sb.append(appendNewLine(whitePawnsResult));
                continue;
            }
            if (i == 7){
                sb.append(appendNewLine(whitePiecesResult));
                continue;
            }
            sb.append(appendNewLine("........"));
        }
        return sb.toString();
    }

    public Board() {
        chessPiecesList = new ArrayList<>();
    }



}
