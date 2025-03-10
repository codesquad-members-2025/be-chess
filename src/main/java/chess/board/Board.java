package chess.board;

import chess.enums.Color;
import chess.piece.Piece;
import chess.piece.PieceFactory;
import chess.record.Position;


public class Board {

    private static final int BOARD_SIZE = 8;
    private static final Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];

    public Board() {
        initialize();
    }

    private void initialize() {
        // 빈칸으로 초기화
        initializeEmpty();

        // 폰 배치
        for (int col = 0; col < BOARD_SIZE; col++) {
            board[1][col] = PieceFactory.createPawn(Color.BLACK);
            board[6][col] = PieceFactory.createPawn(Color.WHITE);
            board[1][col].setCurrentPosition(new chess.record.Position(col, 1));
            board[6][col].setCurrentPosition(new chess.record.Position(col, 6));
        }

        // 기타 기물 배치
        setPieceRow(0, Color.BLACK);
        setPieceRow(7, Color.WHITE);
    }

    private void setPieceRow(int row, Color color) {
        board[row][0] = PieceFactory.createRook(color);
        board[row][1] = PieceFactory.createKnight(color);
        board[row][2] = PieceFactory.createBishop(color);
        board[row][3] = PieceFactory.createQueen(color);
        board[row][4] = PieceFactory.createKing(color);
        board[row][5] = PieceFactory.createBishop(color);
        board[row][6] = PieceFactory.createKnight(color);
        board[row][7] = PieceFactory.createRook(color);

        // 위치 설정 (각 기물이 자기 좌표 기억)
        for (int col = 0; col < BOARD_SIZE; col++) {
            board[row][col].setCurrentPosition(new chess.record.Position(col, row));
        }
    }

    public int pieceCount() {
        int count = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j].getColor() != Color.NOCOLOR) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getSpecificPiece(Class<? extends Piece> type, Color color) {
        int count = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                Piece piece = board[i][j];
                if (piece != null && type.isInstance(piece) && piece.getColor() == color) {
                    count++;
                }
            }
        }
        return count;
    }

    public static Piece findPiece(String location){
        Position position = getPosition(location);
        return board[position.yPos()][position.xPos()];
    }

    public static Position getPosition(String location) {
        int xPos= location.charAt(0)-'a';
        int y=Character.getNumericValue(location.charAt(1));
        int yPos=BOARD_SIZE-y;
        return new Position(xPos,yPos);
    }



    public void initializeEmpty(){
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                board[row][col] = Piece.createBlank();
            }
        }
    }


    public Piece[][] getBoard() {
        return board;
    }

}
