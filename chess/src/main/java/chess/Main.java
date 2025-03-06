package chess;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Board board = new Board();
        System.out.println("start를 입력하면 게임이 시작됩니다");
        while(true){
            System.out.println("명령어를 입력하세요");
            String input = sc.next();
            if(input.equals("start")){
                board.initializePawns();
                board.initializeBoard();
            }
            else if(input.equals("end")){
                System.out.println("게임이 종료됩니다");
                break;
            }
        }
    }
}