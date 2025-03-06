package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import chess.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int MAX_BOARD = 8;
    private final List<Rank> chessBoard;

    public Board() {
        chessBoard = new ArrayList<>();
    }

    public int pieceCount() {
        return chessBoard.stream()
                .mapToInt(Rank::pieceCountPerRank)
                .sum();
    }

    public void addPiece(Rank rank) {
        chessBoard.add(rank);
    }
    public void initialize() {
        addBlackPiecesToBoard();
        addBlackPawnToBoard();
        addBlankToBoard();
        addWhitePawnToBoard();
        addWhitePiecesToBoard();
    }

    public String getPawnResult(Color color){
        StringBuilder result = new StringBuilder();
        for (Rank rank : chessBoard) {
            result.append(rank.getPawnString(color));
        }
        return result.toString();
    }

    public void print() {
        System.out.println(showBoard());
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : chessBoard) {
            for (int j = 0; j < MAX_BOARD; j++) {
                sb.append(rank.getRepresentationByRank(j));
            }
            sb.append(StringUtils.appendNewLine(""));
        }
        return sb.toString();
    }

    private void addWhitePiecesToBoard() {
        List<Piece> whitePieces = new ArrayList<>();
        whitePieces.add(Piece.createWhite(Type.ROOK));
        whitePieces.add(Piece.createWhite(Type.KNIGHT));
        whitePieces.add(Piece.createWhite(Type.BISHOP));
        whitePieces.add(Piece.createWhite(Type.QUEEN));
        whitePieces.add(Piece.createWhite(Type.KING));
        whitePieces.add(Piece.createWhite(Type.BISHOP));
        whitePieces.add(Piece.createWhite(Type.KNIGHT));
        whitePieces.add(Piece.createWhite(Type.ROOK));

        addRankToChessBoard(1, whitePieces);
    }

    private void addBlackPiecesToBoard() {
        List<Piece> blackPieces = new ArrayList<>();
        blackPieces.add(Piece.createBlack(Type.ROOK));
        blackPieces.add(Piece.createBlack(Type.KNIGHT));
        blackPieces.add(Piece.createBlack(Type.BISHOP));
        blackPieces.add(Piece.createBlack(Type.QUEEN));
        blackPieces.add(Piece.createBlack(Type.KING));
        blackPieces.add(Piece.createBlack(Type.BISHOP));
        blackPieces.add(Piece.createBlack(Type.KNIGHT));
        blackPieces.add(Piece.createBlack(Type.ROOK));

        addRankToChessBoard(1, blackPieces);
    }

    private void addBlackPawnToBoard() {
        List<Piece> blackPawns = new ArrayList<>();
        addPieceToList(blackPawns, Piece.createBlack(Type.PAWN));

        addRankToChessBoard(1, blackPawns);
    }

    private void addWhitePawnToBoard() {
        List<Piece> whitePawns = new ArrayList<>();
        addPieceToList(whitePawns, Piece.createWhite(Type.PAWN));

        addRankToChessBoard(1, whitePawns);
    }

    private void addBlankToBoard() {
        List<Piece> blank = new ArrayList<>();
        addPieceToList(blank, Piece.createBlank());

        addRankToChessBoard(4, blank);
    }

    //보드 위에 존재하는 특정 색, 종류의 기물 갯수 리턴
    public int pieceCountOnBoard(Color color, Type type) {
        return chessBoard.stream()
                .mapToInt(rank -> rank.pieceCountPerColorAndType(color, type))
                .sum();
    }

    public Piece findPiece(String position) {
        char x = position.charAt(0);
        int xPos = x - 'a';
        char y = position.charAt(1);
        int yPos = Character.getNumericValue(y);

        Rank rank = chessBoard.get(MAX_BOARD - yPos);
        return rank.getPieceByPosition(xPos);
    }

    public void initializeEmpty() {
        List<Piece> blank = new ArrayList<>();
        addPieceToList(blank, Piece.createBlank());
        addRankToChessBoard(MAX_BOARD, blank);
    }

    private void addRankToChessBoard(int maxBoard, List<Piece> blank) {
        for (int i = 0; i < maxBoard; i++) {
            chessBoard.add(new Rank(blank));
        }
    }

    private void addPieceToList(List<Piece> rank, Piece piece) {
        for (int i = 0; i < MAX_BOARD; i++) {
            rank.add(piece);
        }
    }
}
