package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {
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

        blackChessPiecesList.add(Piece.createPiece(Piece.BLACK_COLOR, Piece.BLACK_ROOK_REPRESENTATION));
        blackChessPiecesList.add(Piece.createPiece(Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION));
        blackChessPiecesList.add(Piece.createPiece(Piece.BLACK_COLOR, Piece.BLACK_BISHOP_REPRESENTATION));
        blackChessPiecesList.add(Piece.createPiece(Piece.BLACK_COLOR, Piece.BLACK_QUEEN_REPRESENTATION));
        blackChessPiecesList.add(Piece.createPiece(Piece.BLACK_COLOR, Piece.BLACK_KING_REPRESENTATION));
        blackChessPiecesList.add(Piece.createPiece(Piece.BLACK_COLOR, Piece.BLACK_BISHOP_REPRESENTATION));
        blackChessPiecesList.add(Piece.createPiece(Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION));
        blackChessPiecesList.add(Piece.createPiece(Piece.BLACK_COLOR, Piece.BLACK_ROOK_REPRESENTATION));

        for(int i = 0; i < 8; i++){
            blackPawnsList.add(Piece.createPiece(Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION));
            whitePawnsList.add(Piece.createPiece(Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION));
        }

        whiteChessPiecesList.add(Piece.createPiece(Piece.WHITE_COLOR, Piece.WHITE_ROOK_REPRESENTATION));
        whiteChessPiecesList.add(Piece.createPiece(Piece.WHITE_COLOR, Piece.WHITE_KNIGHT_REPRESENTATION));
        whiteChessPiecesList.add(Piece.createPiece(Piece.WHITE_COLOR, Piece.WHITE_BISHOP_REPRESENTATION));
        whiteChessPiecesList.add(Piece.createPiece(Piece.WHITE_COLOR, Piece.WHITE_QUEEN_REPRESENTATION));
        whiteChessPiecesList.add(Piece.createPiece(Piece.WHITE_COLOR, Piece.WHITE_KING_REPRESENTATION));
        whiteChessPiecesList.add(Piece.createPiece(Piece.WHITE_COLOR, Piece.WHITE_BISHOP_REPRESENTATION));
        whiteChessPiecesList.add(Piece.createPiece(Piece.WHITE_COLOR, Piece.WHITE_KNIGHT_REPRESENTATION));
        whiteChessPiecesList.add(Piece.createPiece(Piece.WHITE_COLOR, Piece.WHITE_ROOK_REPRESENTATION));

        initializeWhitePawnsResult();
        initializeBlackPawnsResult();
        initializeWhitePiecesResult();
        initializeBlackPiecesResult();
    }


    private void initializeWhitePawnsResult() {
        StringBuilder whitePawnSb = new StringBuilder();

        for (int i = 0; i < whitePawnsList.size(); i++){
            whitePawnSb.append(whitePawnsList.get(i).getRepresentation());
        }

        whitePawnsResult = whitePawnSb.toString();
    }

    private void initializeWhitePiecesResult() {
        StringBuilder whitePiecesSb = new StringBuilder();

        for (int i = 0; i < whiteChessPiecesList.size(); i++){
            whitePiecesSb.append(whiteChessPiecesList.get(i).getRepresentation());
        }

        whitePiecesResult = whitePiecesSb.toString();
    }

    private void initializeBlackPawnsResult() {
        StringBuilder blackPawnSb = new StringBuilder();

        for (int i = 0; i < blackPawnsList.size(); i++){
            blackPawnSb.append(blackPawnsList.get(i).getRepresentation());
        }

        blackPawnsResult = blackPawnSb.toString();
    }

    private void initializeBlackPiecesResult() {
        StringBuilder blackPiecesSb = new StringBuilder();

        for (int i = 0; i < blackChessPiecesList.size(); i++){
            blackPiecesSb.append(blackChessPiecesList.get(i).getRepresentation());
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
