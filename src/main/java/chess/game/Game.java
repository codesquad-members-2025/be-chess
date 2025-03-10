package chess.game;

import chess.board.Board;
import chess.enums.Color;
import chess.piece.Pawn;
import chess.piece.Piece;
import chess.record.Position;
import chess.util.BoardPositionValidator;


public class Game {

    private Piece[][] board;
    private static final int BOARD_SIZE = 8;

    public Game(Board board) {
        this.board=board.getBoard();
    }

    private static Position getPosition(String location) {
        int xPos= location.charAt(0)-'a';
        int y=Character.getNumericValue(location.charAt(1));
        int yPos=BOARD_SIZE-y;
        return new Position(xPos,yPos);
    }

    public void move(String location, Piece piece){
        Position position = getPosition(location);
        if(BoardPositionValidator.isWithinBoard(position)){
            board[position.yPos()][position.xPos()] = piece;
        }
        throw new IllegalArgumentException("체스 보드판의 범위를 벗어난 값을 입력했습니다.");
    }

    public void move(String sourcePotion, String targetPotion){
        Position sourcePosition = getPosition(sourcePotion);
        Position targetPosition = getPosition(targetPotion);
        if(BoardPositionValidator.isWithinBoard(targetPosition)) throw new IllegalArgumentException("체스 보드판의 범위를 벗어난 값을 입력했습니다.");
        board[targetPosition.yPos()][targetPosition.xPos()] = board[sourcePosition.yPos()][sourcePosition.xPos()];
        board[sourcePosition.yPos()][sourcePosition.xPos()] = Piece.createBlank();
    }

    public double calculatePoint(Color color) {
        double point = 0;

        for (int col = 0; col < BOARD_SIZE; col++) {
            int count = 0;
            for (int row = 0; row < BOARD_SIZE; row++) {
                Piece piece = board[row][col];
                if (piece != null && piece.getColor() == color && piece instanceof Pawn) {
                    count++;
                }
            }
            if (count >= 2) point += count * 0.5;
            else point += count;
        }

        // 폰이 아닌 다른 기물들의 점수 합산
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Piece piece = board[row][col];
                if (piece != null && piece.getColor() == color && !(piece instanceof Pawn)) {
                    point += piece.getPoint();
                }
            }
        }

        return point;
    }


}
