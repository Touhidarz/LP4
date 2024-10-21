public class Daa_Ass5_NQueens_Problem {
    static int N = 4;  // Board size, can be modified for different sizes

    // Method to print the solution
    static void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to check if placing a queen on board[row][col] is safe
    static boolean isSafe(int board[][], int row, int col) {
        // Check row on the left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left side
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Utility method to solve N Queens problem recursively
    static boolean solveNQUtil(int board[][], int col) {
        // Base case: If all queens are placed, return true
        if (col >= N) {
            return true;
        }

        // Try placing this queen in all rows one by one
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;  // Place the queen

                // Recur to place the rest of the queens
                if (solveNQUtil(board, col + 1)) {
                    return true;
                }

                // If placing queen in board[i][col] doesn't lead to a solution,
                // backtrack: remove the queen from board[i][col]
                board[i][col] = 0;  // BACKTRACK
            }
        }

        // If the queen cannot be placed in any row in this column, return false
        return false;
    }

    // Main method to solve the N Queens problem
    static boolean solveNQ() {
        int board[][] = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        if (!solveNQUtil(board, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    public static void main(String[] args) {
        solveNQ();
    }
}
