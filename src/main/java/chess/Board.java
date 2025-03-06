package chess;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
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

    public int pieceCount() {
        return pieceList.size();
    }

    public Piece findPawn(int index) {
        return pieceList.get(index);
    }

    public void initialize() {
        initializeEmptyBoard();
        addPawnToList();
        addPieceToList();
        addPawnToBoard();
        addBlackPiecesToBoard();
        addWhitePiecesToBoard();

    }

    public String getPawnResult(Color color){
        StringBuilder sb = new StringBuilder();
        for (Piece piece : pieceList) {
            if (sb.length() == 8) break;
            if (piece.getColor().equals(color) && piece.getName().equals(Type.PAWN))
                sb.append(piece.getName().getRepresentation(color));
        }
        return sb.toString();
    }

    public void print() {
        System.out.println(showBoard());
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                sb.append(chessBoard[i][j]);
            }
            sb.append(StringUtils.appendNewLine(""));
        }
        return sb.toString();
    }

    private void addWhitePiecesToBoard() {
        chessBoard[7][0] = Type.ROOK.getRepresentation(Color.WHITE);
        chessBoard[7][1] = Type.KNIGHT.getRepresentation(Color.WHITE);
        chessBoard[7][2] = Type.BISHOP.getRepresentation(Color.WHITE);
        chessBoard[7][3] = Type.QUEEN.getRepresentation(Color.WHITE);
        chessBoard[7][4] = Type.KING.getRepresentation(Color.WHITE);
        chessBoard[7][5] = Type.BISHOP.getRepresentation(Color.WHITE);
        chessBoard[7][6] = Type.KNIGHT.getRepresentation(Color.WHITE);
        chessBoard[7][7] = Type.ROOK.getRepresentation(Color.WHITE);
    }

    private void addBlackPiecesToBoard() {
        chessBoard[0][0] = Type.ROOK.getRepresentation(Color.BLACK);
        chessBoard[0][1] = Type.KNIGHT.getRepresentation(Color.BLACK);
        chessBoard[0][2] = Type.BISHOP.getRepresentation(Color.BLACK);
        chessBoard[0][3] = Type.QUEEN.getRepresentation(Color.BLACK);
        chessBoard[0][4] = Type.KING.getRepresentation(Color.BLACK);
        chessBoard[0][5] = Type.BISHOP.getRepresentation(Color.BLACK);
        chessBoard[0][6] = Type.KNIGHT.getRepresentation(Color.BLACK);
        chessBoard[0][7] = Type.ROOK.getRepresentation(Color.BLACK);
    }

    private void addPieceToList() {
        pieceList.add(Piece.createWhite(Type.KNIGHT));
        pieceList.add(Piece.createWhite(Type.KNIGHT));
        pieceList.add(Piece.createBlack(Type.KNIGHT));
        pieceList.add(Piece.createBlack(Type.KNIGHT));

        pieceList.add(Piece.createWhite(Type.BISHOP));
        pieceList.add(Piece.createWhite(Type.BISHOP));
        pieceList.add(Piece.createBlack(Type.BISHOP));
        pieceList.add(Piece.createBlack(Type.BISHOP));

        pieceList.add(Piece.createWhite(Type.ROOK));
        pieceList.add(Piece.createWhite(Type.ROOK));
        pieceList.add(Piece.createBlack(Type.ROOK));
        pieceList.add(Piece.createBlack(Type.ROOK));

        pieceList.add(Piece.createWhite(Type.QUEEN));
        pieceList.add(Piece.createBlack(Type.QUEEN));
        pieceList.add(Piece.createWhite(Type.KING));
        pieceList.add(Piece.createBlack(Type.KING));

    }

    private void addPawnToBoard() {
        for (int i = 0; i < chessBoard.length; i++) {
            chessBoard[1][i] = Type.PAWN.getRepresentation(Color.BLACK);;
            chessBoard[6][i] = Type.PAWN.getRepresentation(Color.WHITE);
        }
    }

    private void addPawnToList() {
        for (int i = 0; i < chessBoard.length; i++) {
            pieceList.add(Piece.createWhite(Type.PAWN));
            pieceList.add(Piece.createBlack(Type.PAWN));
        }
    }

    private void initializeEmptyBoard() {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                chessBoard[i][j] = Type.NO_PIECE.getRepresentation(Color.NOCOLOR);
            }
        }
    }
}
