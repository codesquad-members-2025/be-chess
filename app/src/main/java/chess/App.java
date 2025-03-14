package chess;

public class App {
    public static void main(String[] args) {
        Board board = new Board();
        ChessView chessView = new ChessView(board);
        Game game = new Game(board,chessView);
        game.start();
    }
}