package chess;

import chess.board.Board;

import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {
        while(true){
            System.out.println("명령어를 입력하세요 시작명령어:start  종료 명령어:end");
            String userRequest = requestUserCommand();
            if(userRequest.equals("start")){
                Board board = new Board();
                System.out.println(board.showBoard());
            }
            else if(userRequest.equals("end")){
                System.exit(0);
            }
        }
    }

    private static String requestUserCommand(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
