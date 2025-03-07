import chess.Board;

import java.util.Scanner;

public class ChessGame {

    public static void main(String[] args) {
        Board board = new Board();

        while(true){
            Scanner sc = new Scanner(System.in);
            String command = sc.nextLine();

            if(command.equals("start")){
                board.initialize();
                String boardStatus = board.print();
                System.out.println(boardStatus);
            }

            else if(command.equals("end")) break;

            else System.out.println("start와 end 명령어만 입력해야 합니다.");

        }


    }

}
