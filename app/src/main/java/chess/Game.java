package chess;

import pieces.*;

import java.util.Scanner;

public class Game {
    private final Board board;
    private final ChessView chessView;
    private int round = 1;
    private final Scanner sc;

    public Game(Board board, ChessView chessView){
        this.board = board;
        this.chessView = chessView;
        this.sc = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.print("Do you want to start the game? [ Yes: 1, No: 2 ] \n >");
            int num = sc.nextInt();
            sc.nextLine();

            if (num == 1) {
                boolean gameRunning = playGame();
                if (!gameRunning) {
                    break;
                }
            } else if (num == 2) {
                System.out.println("Good Bye..");
                break;
            } else {
                System.out.println("Invalid input. Please enter 1 or 2.");
            }
        }
    }

    private boolean playGame() {
        System.out.println("Game Start!");
        board.initialize();
        chessView.showBoard();

        while (true) {
            System.out.print("Enter your move (ex a2 a3) or 'exit' to quit: \n > ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting game...");
                return false;
            }

            String[] positions = input.split(" ");
            if (positions.length == 2) {
                move(positions[0], positions[1]);
            } else {
                System.out.println("use format: a2 a3");
            }
        }
    }

    public void move(String sourcePosition, String targetPosition){
        Position source = new Position(sourcePosition);
        Position target = new Position(targetPosition);
        Piece piece = board.findPiece(source);

        if (piece.getType().equals(Type.NO_PIECE)) {
            System.out.println("no horse");
            return;
        }

        if (!piece.canMove(target, board)){
            System.out.println("can't move");
            return;
        }

        if ((round % 2 == 0 && !piece.isBlack()) || (round % 2 == 1 && !piece.isWhite())) {
            System.out.println("not your turn");
            return;
        }
        piece.setPosition(target);
        board.getPieces().get(target.getY()).setPiece(target.getX(), piece);
        board.getPieces().get(source.getY()).setPiece(source.getX(), Blank.createBlank(new Position(sourcePosition)));
        round++;
        chessView.showBoard();
    }
}
