package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {
    private static final int BOARD_SIZE = 8;

    private List<Piece> pieces;
    private List<Piece> whitePieces;
    private List<Piece> blackPieces;
    private ArrayList<Rank> board;
    private int piecesIndex;

    public Board() {
        this.pieces = new ArrayList<>();
        this.board = new ArrayList<>();
        this.piecesIndex = 0;
        this.whitePieces = Piece.createWhite();
        this.blackPieces = Piece.createBlack();
    }

    public void add(Piece piece) {
        pieces.add(piece);
    }

    public int pieceCount() {
        return pieces.size();
    }

    public void initialize() {
        setEmptyBoard();
        addPawns();
        addBlackPieces();
        addWhitePieces();
        placePawn();
        placeBlackPieces();
        placeWhitePieces();
    }

    private void setEmptyBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board.add(new Rank());
        }
    }
    
    public void addPawns() {
        for (int i = 0; i < board.length; ++i) {
            pieces.add(whitePieces.getFirst());
            pieces.add(blackPieces.getFirst());
        }
    }

    public void addWhitePieces() {
        pieces.add(whitePieces.get(1));
        pieces.add(whitePieces.get(2));
        pieces.add(whitePieces.get(3));
        pieces.add(whitePieces.get(4));
        pieces.add(whitePieces.get(5));
        pieces.add(whitePieces.get(3));
        pieces.add(whitePieces.get(2));
        pieces.add(whitePieces.get(1));
    }

    public void addBlackPieces() {
        pieces.add(blackPieces.get(1));
        pieces.add(blackPieces.get(2));
        pieces.add(blackPieces.get(3));
        pieces.add(blackPieces.get(4));
        pieces.add(blackPieces.get(5));
        pieces.add(blackPieces.get(3));
        pieces.add(blackPieces.get(2));
        pieces.add(blackPieces.get(1));
    }

    public void placePawn() {
        for (int i = 0; i < board.length; ++i) {
            Piece blackPiece = pieces.get(piecesIndex);
            Piece whitePiece = pieces.get(piecesIndex + 1);
            board[1][i] = Character.toUpperCase(blackPiece.getType());
            board[6][i] = whitePiece.getType();
            piecesIndex += 2;
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
