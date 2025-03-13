package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {

    private static final int rankCount = 8;

    private final List<Rank> board;

    private final List<Piece> whiteChessPiecesList;
    private final List<Piece> blackChessPiecesList;

    private final List<Piece> whitePawnsList;
    private final List<Piece> blackPawnsList;

    public Board() {
        board = new ArrayList<>();
        whitePawnsList = new ArrayList<>();
        blackPawnsList = new ArrayList<>();
        whiteChessPiecesList = new ArrayList<>();
        blackChessPiecesList = new ArrayList<>();
    }

    public void initialize(){
        setPieces();
        initializeEmptyBoard();
        setPiecesOnBoard();
    }

    private void setPieces(){
        blackChessPiecesList.add(Piece.createBlackRook());
        blackChessPiecesList.add(Piece.createBlackKnight());
        blackChessPiecesList.add(Piece.createBlackBishop());
        blackChessPiecesList.add(Piece.createBlackQueen());
        blackChessPiecesList.add(Piece.createBlackKing());
        blackChessPiecesList.add(Piece.createBlackBishop());
        blackChessPiecesList.add(Piece.createBlackKnight());
        blackChessPiecesList.add(Piece.createBlackRook());

        for(int i = 0; i < 8; i++){
            blackPawnsList.add(Piece.createBlackPawn());
            whitePawnsList.add(Piece.createWhitePawn());
        }

        whiteChessPiecesList.add(Piece.createWhiteRook());
        whiteChessPiecesList.add(Piece.createWhiteKnight());
        whiteChessPiecesList.add(Piece.createWhiteBishop());
        whiteChessPiecesList.add(Piece.createWhiteQueen());
        whiteChessPiecesList.add(Piece.createWhiteKing());
        whiteChessPiecesList.add(Piece.createWhiteBishop());
        whiteChessPiecesList.add(Piece.createWhiteKnight());
        whiteChessPiecesList.add(Piece.createWhiteRook());

    }

    private void initializeEmptyBoard(){
        for(int i = 0; i < rankCount; i++){
            List<Piece> pieces = new ArrayList<>();
            for(int j = 0; j < 8; j++){
                pieces.add(Piece.createBlank());
            }
            Rank rank = new Rank(pieces);
            board.add(rank);
        }
    }

    private void setPiecesOnBoard(){
        int BLACK_PIECES_INDEX = 7;
        int BLACK_PAWNS_INDEX = 6;
        int WHITE_PAWNS_INDEX = 1;
        int WHITE_PIECES_INDEX = 0;

        board.set(BLACK_PIECES_INDEX, new Rank(blackChessPiecesList));
        board.set(BLACK_PAWNS_INDEX, new Rank(blackPawnsList));
        board.set(WHITE_PAWNS_INDEX, new Rank(whitePawnsList));
        board.set(WHITE_PIECES_INDEX, new Rank(whiteChessPiecesList));
    }

    public int pieceCount(){
        return whiteChessPiecesList.size() + blackChessPiecesList.size() + whitePawnsList.size() + blackPawnsList.size();
    }

    public int getPiecesCount(Piece.Color pieceColor, Piece.Type pieceType){
        int piecesCount = 0;
        for (Rank rank : board) {
            for(Piece piece : rank.getPieces()){
                if(piece.getColor().equals(pieceColor) && piece.getType().equals(pieceType)){
                    piecesCount++;
                }
            }
        }
        return piecesCount;
    }

    public Piece findPiece(String PositionInfo){
        Position piecePosition = new Position(PositionInfo);
        List<Piece> pieces = board.get(piecePosition.getY()).getPieces();
        return pieces.get(piecePosition.getX());
    }


    public String showBoard(){
        StringBuilder sb = new StringBuilder();
        for (int rankIndex = board.size() - 1; rankIndex >= 0; rankIndex --) {
            sb.append(appendNewLine(board.get(rankIndex).getRankStatus()));
        }
        return sb.toString();
    }





}
