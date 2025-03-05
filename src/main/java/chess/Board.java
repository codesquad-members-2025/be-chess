package chess;

import chess.pieces.Piece;
import chess.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Piece> pieceList;
    private char[][] chessBoard;

    public Board() {
        pieceList = new ArrayList<>();
        chessBoard = new char[8][8];
    }

    public void add(Piece piece) {
        pieceList.add(piece);
    }

    public int size() {
        return pieceList.size();
    }

    public Piece findPawn(int index) {
        return pieceList.get(index);
    }

    public void initialize() {
        initializeEmptyBoard();
        addPawnToList();
        addPawnToBoard();
    }

    public String getPawnResult(String color){
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pieceList) {
            if (piece.getColor().equals(color)) sb.append(piece.getRepresentation());
        }
        return sb.toString();
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                sb.append(chessBoard[i][j]);
            }
            sb.append(StringUtils.appendNewLine(""));
        }
        System.out.println(sb);
    }

    private void addPawnToBoard() {
        for (int i = 0; i < chessBoard.length; i++) {
            chessBoard[1][i] = Piece.BLACK_REPRESENTATION;
            chessBoard[6][i] = Piece.WHITE_REPRESENTATION;
        }
    }

    private void addPawnToList() {
        for (int i = 0; i < chessBoard.length; i++) {
            pieceList.add(new Piece());
            pieceList.add(new Piece(Piece.BLACK_COLOR, Piece.BLACK_REPRESENTATION));
        }
    }

    private void initializeEmptyBoard() {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                chessBoard[i][j] = '.';
            }
        }
    }
}
