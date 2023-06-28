import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[3][3];
        initializeBoard(board);

        boolean isPlayer1Turn = true;
        boolean isGameFinished = false;

        System.out.println("Tic-Tac-Toe Game");
        System.out.println("----------------");

        while (!isGameFinished) {
            char currentPlayerSymbol = isPlayer1Turn ? 'X' : 'O';

            printBoard(board);

            System.out.println("Player " + (isPlayer1Turn ? "1" : "2") + ", enter your move (row [0-2] and column [0-2]):");
            int row = scanner.nextInt();
            int column = scanner.nextInt();

            if (isValidMove(board, row, column)) {
                makeMove(board, row, column, currentPlayerSymbol);

                if (hasWon(board, currentPlayerSymbol)) {
                    printBoard(board);
                    System.out.println("Player " + (isPlayer1Turn ? "1" : "2") + " wins!");
                    isGameFinished = true;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("It's a draw!");
                    isGameFinished = true;
                } else {
                    isPlayer1Turn = !isPlayer1Turn;
                }
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
    }

    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
        System.out.println();
    }

    private static boolean isValidMove(char[][] board, int row, int column) {
        return row >= 0 && row < 3 && column >= 0 && column < 3 && board[row][column] == ' ';
    }

    private static void makeMove(char[][] board, int row, int column, char symbol) {
        board[row][column] = symbol;
    }

    private static boolean hasWon(char[][] board, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        return false;
