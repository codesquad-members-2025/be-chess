package chess.gui;

import chess.board.Board;
import chess.enums.Color;
import chess.game.Game;
import chess.piece.Piece;

import javax.swing.*;
import java.awt.*;

public class ChessGameGUI extends JFrame {
    private static final int BOARD_SIZE = 8;
    private JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE];
    private Board board;
    private Game game;
    private Color currentTurn = Color.WHITE;
    private JLabel statusLabel;
    private String selectedSource = null;

    public ChessGameGUI() {
        board = new Board();
        game = new Game(board);

        setTitle("체스 게임");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 체스판 생성
        JPanel boardPanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        initializeBoard(boardPanel);
        add(boardPanel, BorderLayout.CENTER);

        // 상태 표시 라벨
        statusLabel = new JLabel("현재 턴: 흰색(White)");
        add(statusLabel, BorderLayout.NORTH);

        // 게임 종료 버튼
        JButton endButton = new JButton("게임 종료");
        endButton.addActionListener(e -> System.exit(0));
        add(endButton, BorderLayout.SOUTH);
    }

    private void initializeBoard(JPanel boardPanel) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setPreferredSize(new Dimension(70, 70));
                buttons[row][col].setFont(new Font("Arial", Font.BOLD, 20));

                // 배경색 설정 (체스판 패턴)
                if ((row + col) % 2 == 0) {
                    buttons[row][col].setBackground(java.awt.Color.LIGHT_GRAY);
                } else {
                    buttons[row][col].setBackground(java.awt.Color.DARK_GRAY);
                }

                // 클릭 이벤트 추가
                int finalRow = row;
                int finalCol = col;
                buttons[row][col].addActionListener(e -> handleMove(finalRow, finalCol));

                boardPanel.add(buttons[row][col]);
            }
        }
        updateBoard();
    }

    private void handleMove(int row, int col) {
        String position = convertToChessNotation(row, col);
        if (selectedSource == null) {
            // 첫 클릭: 이동할 기물 선택
            if (game.isValidMove(position, currentTurn)) {
                selectedSource = position;
                statusLabel.setText("이동할 위치를 선택하세요.");
            } else {
                statusLabel.setText("⚠️ 본인의 기물만 선택할 수 있습니다.");
            }
        } else {
            // 두 번째 클릭: 이동 실행
            try {
                game.move(selectedSource, position);
                updateBoard();
                switchTurn();
                statusLabel.setText("현재 턴: " + (currentTurn == Color.WHITE ? "흰색(White)" : "검은색(Black)"));
            } catch (IllegalArgumentException ex) {
                statusLabel.setText("⚠️ " + ex.getMessage());
            }
            selectedSource = null; // 선택 초기화
        }
    }

    private void switchTurn() {
        currentTurn = (currentTurn == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private void updateBoard() {
        Piece[][] boardState = board.getBoard();
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                Piece piece = boardState[row][col];
                buttons[row][col].setText(piece.getColor() == Color.NOCOLOR ? "" : String.valueOf(piece.getSymbol()));
            }
        }
    }

    private String convertToChessNotation(int row, int col) {
        char file = (char) ('a' + col);
        int rank = BOARD_SIZE - row;
        return file + String.valueOf(rank);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessGameGUI gui = new ChessGameGUI();
            gui.setVisible(true);
        });
    }
}
