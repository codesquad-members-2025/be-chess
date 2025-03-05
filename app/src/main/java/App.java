import chess.Board;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Board board = new Board();

        while(true){
            System.out.print("체스 한 판? [ Yes: 1, No: 2 ] \n >");
            Scanner sc = new Scanner(System.in);

            int num = sc.nextInt();
            if (num == 1) {
                System.out.println("체스게임을 시작합니다.");
                board.initialize();
                board.print();
            } else if (num == 2) {
                System.out.println("체스게임을 종료합니다.");
                break;
            }
        }
    }
}
