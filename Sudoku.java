import java.util.Random;
public class Sudoku {
    static int[][] board = new int[9][9];
    static Random rand = new Random();
    public static void main(String[] args)
    {
        int boardAmount = 0;
        while (boardAmount < 10) {
            generateBoard();
            randomizeBoard();
            printBoard();
            System.out.print("\n\n");
            boardAmount++;
        }
       
    }
    public static void generateBoard() {
        int[] row = {1,4,7,2,5,8,3,6,9};
        for (int i = 0; i < 9; i++) {
            int start = row[i];
            for (int j = 0; j < 9; j++) {
                board[i][j]= (start+j-1)%9 +1;
            }
        }
    }
    public static void randomizeBoard() {
        swapRandomDigits();
        shuffleRows();
        shuffleCols();
    }
    public static void swapRandomDigits() {
        int a = rand.nextInt(9) + 1;
        int b = rand.nextInt(9) + 1;
        while (b == a) {
            b = rand.nextInt(9) + 1; }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == a) board[i][j] = b;
                else if (board[i][j] == b) board[i][j] = a;
            }
        }
    }
    public static void shuffleRows() {
        for (int band = 0; band < 3; band++) {
            int start = band * 3;

            for (int i = 0; i < 3; i++) {
                int r1 = start + rand.nextInt(3);
                int r2 = start + rand.nextInt(3);
                swapRows(r1, r2);
            }
        }
    }

    public static void swapRows(int r1, int r2) {
        int[] temp = board[r1];
        board[r1] = board[r2];
        board[r2] = temp;
    }
    public static void shuffleCols() {
        for (int stack = 0; stack < 3; stack++) {
            int start = stack * 3;

            for (int i = 0; i < 3; i++) {
                int c1 = start + rand.nextInt(3);
                int c2 = start + rand.nextInt(3);
                swapCols(c1, c2);
            }
        }
    }

    public static void swapCols(int c1, int c2) {
        for (int i = 0; i < 9; i++) {
            int temp = board[i][c1];
            board[i][c1] = board[i][c2];
            board[i][c2] = temp;
        }
    }
    public static void printBoard() {
        String topBorder = ("+-------+-------+-------+");
        for (int i = 0 ; i < 9; i++) {
            if (i % 3 == 0) {
                System.out.println(topBorder);
            }
            System.out.print("| ");
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] +  " ");
                if (j % 3 == 2 && j != 8) {
                    System.out.print("| ");
                }
           }
           System.out.println("|");
       }
       System.out.print(topBorder);
    }
}