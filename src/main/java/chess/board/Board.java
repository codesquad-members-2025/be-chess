package chess.board;

import chess.piece.Piece;
import chess.piece.Piece.Type;
import chess.util.StringUtils;

import static chess.piece.Piece.*;

public class Board {

    private static final int BOARD_SIZE = 8;
    private final Piece[][] board = new Piece[BOARD_SIZE][BOARD_SIZE];

    public Board() {
        initialize();
    }

    private void initialize() {
        //빈칸으로 초기화
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                board[row][col] = Piece.createBlank();
            }
        }

        for (int col = 0; col < BOARD_SIZE; col++) {
            board[1][col] = createBlack(Type.PAWN);  // 검은색 폰배치
            board[6][col] = createWhite(Type.PAWN);  // 하얀색 폰배치
        }

        // 검은색 체스 말 배치
        setPieceRow(0, Color.BLACK);

        // 하얀색 체스 말 배치
        setPieceRow(7, Color.WHITE);
    }

    private void setPieceRow(int row, Piece.Color color) {
        Piece[] pieces = new Piece[]{
                create(color, Type.ROOK),
                create(color, Type.KNIGHT),
                create(color, Type.BISHOP),
                create(color, Type.QUEEN),
                create(color, Type.KING),
                create(color, Type.BISHOP),
                create(color, Type.KNIGHT),
                create(color, Type.ROOK)
        };
        System.arraycopy(pieces, 0, board[row], 0, BOARD_SIZE);
    }

    private Piece create(Piece.Color color, Piece.Type type) {
        return color == Color.WHITE ? createWhite(type) : createBlack(type);
    }

    public int pieceCount() {
        int count = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j].getType() != Type.NO_PIECE) {
                    count++;
                }
            }
        }
        return count;
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                Piece piece = board[i][j];
                if (piece.getType() == Type.NO_PIECE) {
                    sb.append(".");
                } else {
                    sb.append(piece.getSymbol());
                }
            }
            sb.append(StringUtils.appendNewLine(""));
        }
        return sb.toString();
    }

    public int getSpecificPiece(Type type,Color color){
        int count = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j].getType() == type && board[i][j].getColor() == color) {
                    count++;
                }
            }
        }
        return count;
    }

    public Piece findPiece(String location){
        Position position = getPosition(location);

        return board[position.yPos()][position.xPos()];
    }

    private static Position getPosition(String location) {
        int xPos= location.charAt(0)-'a';
        int y=Character.getNumericValue(location.charAt(1));
        int yPos=BOARD_SIZE-y;
        Position position = new Position(xPos, yPos);
        return position;
    }

    private record Position(int xPos, int yPos) {
    }

    public void move(String location,Piece piece){
        Position position = getPosition(location);
        board[position.yPos()][position.xPos()] = piece;
    }

    public void initializeEmpty(){
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                board[row][col] = Piece.createBlank();
            }
        }
    }

    public double calculatePoint(Color color){
        double point = 0;
        for (int col=0; col < BOARD_SIZE; col++) {
            for(int row = 0; row < BOARD_SIZE; row++) {
                int count=0;
                if(board[row][col].getColor() == color && board[row][col].getType()==Type.PAWN){
                    count++;
                }
                if (count>=2) point+=count*0.5;
                else{
                    point+=count;
                }
            }
        }
        for(int row = 0; row < BOARD_SIZE; row++) {
            for(int col = 0; col < BOARD_SIZE; col++) {
                if(board[row][col].getColor() == color && board[row][col].getType()!=Type.PAWN){
                    point+=board[row][col].getPoint();
                }
            }
        }
        return point;
    }

}
