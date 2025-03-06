package chess.board;

import chess.piece.Pawn;
import chess.piece.Piece;

public class Board {

    private static final int BOARD_SIZE = 8;
    private final Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];

    public Board() {
        initialize();
    }

    public void initialize() {

        for (int col = 0; col < BOARD_SIZE; col++) {
            board[1][col] = new Pawn(Piece.Color.BLACK);
        }


        for (int col = 0; col < BOARD_SIZE; col++) {
            board[6][col] = new Pawn(Piece.Color.WHITE);
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<BOARD_SIZE; i++){
            for (int j=0; j<BOARD_SIZE; j++){
                Piece piece = board[i][j];
                if (piece==null){
                    sb.append(". ");
                }else{
                    sb.append(piece.getSymbol());
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public String getWhitePawnsResult(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<BOARD_SIZE; i++){
            sb.append(board[6][i].getSymbol());
        }
        return sb.toString();
    }

    public String getBlackPawnsResult(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<BOARD_SIZE; i++){
            sb.append(board[1][i].getSymbol());
        }
        return sb.toString();
    }
}
