import java.util.Scanner;

public class Main {
    static char[][] board = new char[3][3];
    static char currentPlayerMark = 'X';

    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        while (true) {
            System.out.println("Player " + currentPlayerMark + ", enter row (1-3):");
            int row = getUserInput();
            System.out.println("Player " + currentPlayerMark + ", enter column (1-3):");
            int col = getUserInput();
            if (placeMark(row, col)) {
                printBoard();
                if (checkForWin()) {
                    System.out.println("Player " + currentPlayerMark + " wins!");
                    break;
                } else if (checkForTie()) {
                    System.out.println("It's a tie!");
                    break;
                }
                swapPlayers();
            } else {
                System.out.println("That spot is already taken.");
            }
        }
    }

    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt() - 1;
    }

    public static boolean placeMark(int row, int col) {
        if (board[row][col] == '-') {
            board[row][col] = currentPlayerMark;
            return true;
        } else {
            return false;
        }
    }

    public static void swapPlayers() {
        if (currentPlayerMark == 'X') {
            currentPlayerMark = 'O';
        } else {
            currentPlayerMark = 'X';
        }
    }

    public static boolean checkForWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayerMark && board[i][1] == currentPlayerMark && board[i][2] == currentPlayerMark) {
                return true;
            }
            if (board[0][i] == currentPlayerMark && board[1][i] == currentPlayerMark && board[2][i] == currentPlayerMark) {
                return true;
            }
        }
        if (board[0][0] == currentPlayerMark && board[1][1] == currentPlayerMark && board[2][2] == currentPlayerMark) {
            return true;
        }
        if (board[2][0] == currentPlayerMark && board[1][1] == currentPlayerMark && board[0][2] == currentPlayerMark) {
            return true;
        }
        return false;
    }

    public static boolean checkForTie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
