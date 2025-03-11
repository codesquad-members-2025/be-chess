package chess;

import pieces.Piece;

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
        placeBlackPieces();
        placeWhitePieces();
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
            board.get(6).addPiece(blackPiece);
            board.get(1).addPiece(whitePiece);
            ++piecesIndex;
        }
    }

    public void placeWhitePieces() {
        for (int i = 0; i < board.length; ++i) {
            board[7][i] = pieces.get(piecesIndex).getType();
            ++piecesIndex;
        }
    }

    public void placeBlackPieces() {
        for (int i = 0; i < board.length; ++i) {
            board[0][i] = Character.toUpperCase(pieces.get(piecesIndex).getType());
            ++piecesIndex;
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; ++i) {
            String line = "";
            for (int j = 0; j < board.length; ++j) {
                line += (board[i][j]);
            }
            line = appendNewLine(line);
            sb.append(line);
        }
        System.out.print(sb);
    }

    public String showBoard() {
        StringBuilder chessBoard = new StringBuilder();
        for (char[] chars : board) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < board.length; ++j) {
                line.append(chars[j]);
            }
            line = new StringBuilder(appendNewLine(line.toString()));
            chessBoard.append(line);
        }
        return chessBoard.toString();
    }

}
