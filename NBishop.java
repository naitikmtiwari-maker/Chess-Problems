import java.util.*;

public class NBishop {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[][] board = new char[n][n];

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(board[i] , '.');
        }
        List<List<String>> ans = new ArrayList<>();

        solve(board , ans , 0);

        for(List<String> solution : ans){

            for(String row : solution){
               System.out.println(row);
            }
            System.out.println("   ");
        }
        System.out.println("Total solutions :" + ans.size());
    }

    private static void solve(char[][] board , List<List<String>> ans , int row){
        if(row == board.length){

            List<String> temp = new ArrayList<>();

            for(int i = 0 ; i < board.length ; i++){
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }
         
        for(int col = 0 ; col < board.length ; col++){
             
            if(isSafe(board , row , col)){

                board[row][col] = 'B';

                solve(board , ans , row +1);

                board[row][col] = '.';
            }
            
        }

    }
     private static boolean isSafe(char[][] board , int row , int col){

        for(int i = row - 1 , j = col -1 ; i >= 0 && j >= 0 ; i-- , j--){
            if(board[i][j] == 'B') return false;
        }

        for(int i = row - 1 , j = col + 1 ; i >= 0 && j < board.length ; i-- , j++){
            if(board[i][j] == 'B') return false;
        }
        return true;
     }
}
