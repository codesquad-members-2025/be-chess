package chess;

import pieces.Piece;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {
    private static final int BOARD_SIZE = 8;

    private List<Piece> whitePieces;
    private List<Piece> blackPieces;
    private ArrayList<Rank> board;
    private int piecesIndex;

    public Board() {
        this.board = new ArrayList<>();
        this.piecesIndex = 0;
        this.whitePieces = Piece.createWhite();
        this.blackPieces = Piece.createBlack();
    }

    public int pieceCount() {
        return whitePieces.size() + blackPieces.size();
    }

    public void initialize() {
        setEmptyBoard();
        placePawn();
        placePieces();
    }

    private void setEmptyBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board.add(new Rank());
        }
    }

    public void placePawn() {
        for (int i = 0; i < BOARD_SIZE; ++i) {
            Piece blackPiece = blackPieces.get(piecesIndex);
            Piece whitePiece = whitePieces.get(piecesIndex);
            board.get(6).addPiece(i, blackPiece);
            board.get(1).addPiece(i, whitePiece);
            ++piecesIndex;
        }
    }

    public void placePieces() {
        for (int i = 0; i < BOARD_SIZE; ++i) {
            board.getFirst().addPiece(i, whitePieces.get(piecesIndex));
            board.getLast().addPiece(i, blackPieces.get(piecesIndex));
            ++piecesIndex;
        }
    }

    public String showBoard() {
        StringBuilder chessBoard = new StringBuilder();
        for (var rowIndex = BOARD_SIZE - 1; rowIndex >= 0; --rowIndex) {
            List<Piece> rank = board.get(rowIndex).getRank();
            StringBuilder row = new StringBuilder();
            for (var columnIndex = 0; columnIndex < BOARD_SIZE; ++columnIndex) {
                Piece piece = rank.get(columnIndex);
                row.append((piece.isBlack()) ? Character.toUpperCase(piece.getType()) : piece.getType());
            }
            chessBoard.append(appendNewLine(row.toString()));
        }
        return chessBoard.toString();
    }

    public int countPiece(Piece.Color color, Piece.Type type) {
        int count = 0;
        for (Rank rank : board) {
            for (Piece piece : rank.getRank()) {
                if(matches(piece, color, type)) ++count;
            }
        }
        return count;
    }

    private boolean matches(Piece piece, Piece.Color color, Piece.Type type) {
        return piece.getColor() == color && piece.getType() == type.getRepresentation();
    }
}
