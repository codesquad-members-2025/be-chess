package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.StringUtils.appendNewLine;

public class Board {

    private static final int rankCount = 8;

    private final List<Rank> board;
    private final List<Piece> whiteChessPiecesList;
    private final List<Piece> blackChessPiecesList;

    public Board() {
        board = new ArrayList<>();
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
            blackChessPiecesList.add(Piece.createBlackPawn());
            whiteChessPiecesList.add(Piece.createWhitePawn());
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

    public void initializeEmptyBoard(){
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

        board.set(BLACK_PIECES_INDEX, new Rank(blackChessPiecesList.subList(0, 8)));
        board.set(BLACK_PAWNS_INDEX, new Rank(blackChessPiecesList.subList(8, 16)));
        board.set(WHITE_PAWNS_INDEX, new Rank(whiteChessPiecesList.subList(0, 8)));
        board.set(WHITE_PIECES_INDEX, new Rank(whiteChessPiecesList.subList(8, 16)));
    }

    public int pieceCount(){
        return whiteChessPiecesList.size() + blackChessPiecesList.size();
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

    public void move(String positionInfo, Piece piece){
        Position position = new Position(positionInfo);
        List<Piece> pieces = board.get(position.getY()).getPieces();
        pieces.set(position.getX(), piece);
    }

    public double calculatePoint(Piece.Color color){
        Map<Integer, Integer> pawnCountMap = new HashMap<>();
        double points = 0;

        for(Rank rank : board){
            for(int file = 0; file < rank.getPieces().size(); file++){
                if(rank.getPieces().get(file).getType().equals(Piece.Type.PAWN) && rank.getPieces().get(file).getColor().equals(color)){
                    pawnCountMap.put(file, pawnCountMap.getOrDefault(file, 0) + 1);
                }
            }
        }

        for(Integer pawnCount : pawnCountMap.values()){
            if(pawnCount >= 2) points += pawnCount * 0.5;
            else points += pawnCount * 1.0;
        }

        for (Rank rank : board) {
            for(Piece piece : rank.getPieces()){
                if(piece.getColor().equals(color) && !piece.getType().equals(Piece.Type.PAWN)){
                    points += piece.getType().getDefaultPoint();
                }
            }
        }

        return points;
    }

    public String showBoard(){
        StringBuilder sb = new StringBuilder();
        for (int rankIndex = board.size() - 1; rankIndex >= 0; rankIndex --) {
            sb.append(appendNewLine(board.get(rankIndex).getRankStatus()));
        }
        return sb.toString();
    }





}
