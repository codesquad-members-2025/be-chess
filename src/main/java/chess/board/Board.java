package chess.board;

import chess.piece.Piece;
import chess.util.StringUtils;

public class Board {

    private static final int BOARD_SIZE = 8;
    private final Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];

    public Board() {
        initialize();
    }

    private void initialize() {
        //검은색 폰 추가하는 ㅁ로직
        for (int col = 0; col < BOARD_SIZE; col++) {
            board[1][col] = Piece.createBlackPawn();
        }

        //하얀색 폰 추가하는 로직
        for (int col = 0; col < BOARD_SIZE; col++) {
            board[6][col] = Piece.createWhitePawn();
        }

        //  블랙 나머지 말들 배치
        board[0][0] = Piece.createBlackRook();
        board[0][1] = Piece.createBlackKnight();
        board[0][2] = Piece.createBlackBishop();
        board[0][3] = Piece.createBlackQueen();
        board[0][4] = Piece.createBlackKing();
        board[0][5] = Piece.createBlackBishop();
        board[0][6] = Piece.createBlackKnight();
        board[0][7] = Piece.createBlackRook();

        // 화이트 나머지 말들 배치
        board[7][0] = Piece.createWhiteRook();
        board[7][1] = Piece.createWhiteKnight();
        board[7][2] = Piece.createWhiteBishop();
        board[7][3] = Piece.createWhiteQueen();
        board[7][4] = Piece.createWhiteKing();
        board[7][5] = Piece.createWhiteBishop();
        board[7][6] = Piece.createWhiteKnight();
        board[7][7] = Piece.createWhiteRook();
    }

    public int pieceCount(){
        int count = 0;
        for(int i=0; i<BOARD_SIZE; i++){
            for(int j=0; j<BOARD_SIZE; j++){
                if(board[i][j]!= null){
                    count++;
                }
            }
        }
        return count;
    }


    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<BOARD_SIZE; i++){
            for (int j=0; j<BOARD_SIZE; j++){
                Piece piece = board[i][j];
                if (piece==null){
                    sb.append(".");
                }else{
                    sb.append(piece.getSymbol());
                }
            }
            sb=new StringBuilder(StringUtils.appendNewLine(sb.toString()));
        }
        return sb.toString();
    }

}
