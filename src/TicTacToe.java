import java.util.Scanner;
public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board[][] = new String[ROWS][COLS];
    static Scanner in = new Scanner(System.in);


    public static void main(String[] args) {
        boolean done = false;
        boolean playing = true;
        int row = -1;
        int col = -1;
        String player = "X";
        int moveCounter = 0;
        final int MOVES_FOR_WIN = 5;
        final int MOVES_FOR_TIE = 7;
        do {
            player = "X";
            playing = true;
            moveCounter = 0;
            clearBoard();

            do {

                do {
                    display();
                    System.out.println("Enter the move for " + player);
                    row = SafeInput.getRangedInt(in, "Enter the row", 1, 3);
                    col = SafeInput.getRangedInt(in, "Enter the column", 1, 3);
                    row--;
                    col--;
                } while (!isValidMove(row, col));
                board[row][col] = player;
                moveCounter++;

                if (moveCounter >= MOVES_FOR_WIN && isWin(player)) {
                        display();
                        IO.println("Player " + player + " wins!");
                        playing = false;

                }

                if (moveCounter >= MOVES_FOR_WIN && isTie()) {
                        display();
                        IO.println("The game is a tie!");
                        playing = false;

                }
                if (player.equals("X"))
                    player = "O";
                else
                    player = "X";

            } while (playing);

            done = !SafeInput.getYNConfirm(in, "Do you want to play again?");
        }while (!done);
    }

    private static void clearBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = " ";
            }
        }
    }

    private static void display() {
        System.out.printf("%3d\t%3d\t%3d\n", 1, 2, 3);
        for (int row = 0; row < ROWS; row++) {
            System.out.print(row+1 + " ");

            for (int col = 0; col < COLS; col++) {
                System.out.print(board[row][col]);
                if (col < COLS - 1) {
                    System.out.printf("%-3s"," |");
                }
            }
        IO.println();
        if (row < ROWS - 1) {
            System.out.println("  ----------");
        }
        }
    }

   private static boolean isValidMove(int row, int col){
       if (board[row][col].equals(" ")){
           return true;
       }
       else{
           IO.println("Illegal move. Please choose an available slot!");
           return false;
       }
    }

    private static boolean isWin(String player){
        return isColWin(player) || isRowWin(player) || isDiagonalWin(player);
    }


    private static boolean isColWin(String player) {
        for (int col = 0; col < COLS; col++) {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRowWin(String player) {
        for (int row = 0; row < ROWS; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            return true;
        }

        return false;
    }

    private static boolean isTie() {
        boolean xFlag = false;
        boolean oFlag = false;
        for (int row = 0; row < ROWS; row++) {
            if (board[row][0].equals("X") || board[row][1].equals("X") || board[row][2].equals("X")) {
                xFlag = true;
            }
            if (board[row][0].equals("O") || board[row][1].equals("O") || board[row][2].equals("O")) {
                oFlag = true;
            }
            if (!(xFlag && oFlag)) {
                return false;
            }
        }


        for (int col = 0; col < COLS; col++) {
            xFlag = oFlag = false;
            if (board[0][col].equals("X") || board[1][col].equals("X") || board[2][col].equals("X")) {
                xFlag = true;
            }
            if (board[0][col].equals("O") || board[1][col].equals("O") || board[2][col].equals("O")) {
                oFlag = true;
            }
            if (!(xFlag && oFlag)) {
                return false;
            }
        }
        xFlag = oFlag = false;
        if (board[0][0].equals("X") || board[1][1].equals("X") || board[2][2].equals("X")) {
            xFlag = true;
        }
        if (board[0][0].equals("O") || board[1][1].equals("O") || board[2][2].equals("O")) {
            oFlag = true;
        }
        if (!(xFlag && oFlag)) {
            return false;
        }

        xFlag = oFlag = false;
        if (board[0][2].equals("X") || board[1][1].equals("X") || board[2][0].equals("X")) {
            xFlag = true;
        }
        if (board[0][2].equals("O") || board[1][1].equals("O") || board[2][0].equals("O")) {
            oFlag = true;
        }
        if (!(xFlag && oFlag)) {
            return false;
        }
        return true;
    }
}