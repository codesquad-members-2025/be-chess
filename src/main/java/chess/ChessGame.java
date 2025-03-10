package chess;

import chess.board.Board;
import chess.enums.Color;
import chess.game.Game;
import chess.view.ChessView;

import java.util.Scanner;

import static chess.enums.Color.WHITE;

public class ChessGame {

    private static final Scanner scanner = new Scanner(System.in);
    private static Color currentTurn = WHITE;

    public static void main(String[] args) {

        Board board = new Board();
        Game game = new Game(board);

        while (true) {
            System.out.println("\n현재 턴: " + (currentTurn == WHITE ? "흰색(White)" : "검은색(Black)"));
            System.out.println("명령어를 입력하세요 (start / move source target / end)");
            System.out.println("예시: move b2 b3");

            String userRequest = requestUserCommand();

            if (userRequest.equals("start")) {
                ChessView.printBoard(board.getBoard());
            } else if (userRequest.equals("end")) {
                scanner.close();
                System.exit(0);
            } else if (userRequest.startsWith("move")) {
                handleMoveCommand(userRequest, game, board);
            }
        }
    }

    private static void handleMoveCommand(String command, Game game, Board board) {
        String[] split = command.split(" ");

        if (split.length != 3) {
            throw new IllegalArgumentException("⚠️ 잘못된 명령어입니다. 예시: move b2 b3");
        }

        String sourceLocation = split[1];
        String targetLocation = split[2];


        if (!game.isValidMove(sourceLocation, currentTurn)) {
            throw new IllegalArgumentException("⚠️ 잘못된 이동입니다. 본인의 기물만 이동할 수 있습니다.");
        }

        game.move(sourceLocation, targetLocation);
        ChessView.printBoard(board.getBoard());

        // 턴 변경 (흰색 -> 검은색, 검은색 -> 흰색)
        currentTurn = (currentTurn == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private static String requestUserCommand() {
        return scanner.nextLine();
    }
}
