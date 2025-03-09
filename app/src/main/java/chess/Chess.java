package chess;

import java.util.Scanner;

public class Chess {

    private static final String END = "end";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Board board = new Board();

        System.out.println("게임을 시작합니다. 종료를 원하신다면 end 를 입력해주세요.");
        board.initialize();
        System.out.println(board.showBoard());


        while (true) {
            String input = sc.nextLine().trim();
            if (input.equals(END)) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
        sc.close();
    }
}
