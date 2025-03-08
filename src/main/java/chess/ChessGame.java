package chess;

import chess.board.Board;
import chess.game.Game;
import chess.view.ChessView;

import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {

        Board board = new Board();
        Game game = new Game(board);
        ChessView chessView = new ChessView(board);
        while(true){
            System.out.println("명령어를 입력하세요 시작명령어:start 움직임명령어:move source좌표 tartget좌표 " + "ex)move b2 b3"+
                    "종료 명령어:end");
            String userRequest = requestUserCommand();
            if(userRequest.equals("start")){
                chessView.printBoard();
            }
            else if(userRequest.equals("end")){
                System.exit(0);
            }
            else if(userRequest.startsWith("move")){
                String[] split = userRequest.split(" ");
                String sourceLocation = split[1];
                String targetLocation = split[2];
                game.move(sourceLocation, targetLocation);
                chessView.printBoard();
            }
        }
    }

    private static String requestUserCommand(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
