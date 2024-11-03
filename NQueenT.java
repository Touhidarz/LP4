import java.util.*;

public class NQueenT {
    

    public static boolean isSafe(char[][] board, int row, int col){
        // row
        for(int i=0; i<board.length; i++){
            if(board[row][i] == 'Q'){
                return false;
            }
        }

        //column
        for(int i=0; i<board.length; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //upper left
        int r=row;
        for(int c=col; c>=0 && r>=0; c--, r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

       //upper right
        r=row;
        for(int c=col; c<board.length && r>=0; r--, c++ ){
            if(board[r][c] == 'Q'){
                return false;
            }
        }       


        //Lower left
        r=row;
        for(int c=col; c>=0 && r<board.length; r++, c-- ){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        //lower right
        r=row;
        for(int c=col; c<board.length && r<board.length; r++, c++ ){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        return true;
    }

    

    

    public static void nQueen(char[][] board, int row){
        if(row == board.length){
            print(board);
            count ++;
            return;
        }

        for(int j=0; j< board.length; j++){
            if( isSafe(board, row, j) == true ){
                board[row][j] = 'Q';
                nQueen(board, row + 1);
                board[row][j] = 'x';
            }
        }
    }

    public static int count = 0;
    public static void print(char[][] board){
        System.out.println("-----------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of Queens : ");
        int n = sc.nextInt();

        char[][] board = new char[n][n];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                board[i][j] = 'x';
            }
        }

        nQueen(board, 0);
        System.out.println("TOtal Solution : "+count);

        sc.close();
    }
}