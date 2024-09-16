class Solution {
    public int totalNQueens(int n) {
        int[] count = new int[1];
        char[][] board = new char[n][n];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                board[i][j] = '.';

        boolean[] leftRow = new boolean[n];
        boolean[] upperDiagonal = new boolean[(2 * n) - 1];
        boolean[] lowerDiagonal = new boolean[(2 * n) - 1];
        solve(0, board, leftRow, upperDiagonal,lowerDiagonal, count, n);
        return count[0];
    }
    private void solve(int col, char[][] board, boolean[] leftRow, boolean[] upperDiagonal, boolean[] lowerDiagonal, int[] count,int n){

        if(col == board.length){
            count[0]++;
            return;
        }

        for(int row = 0 ; row < n ; row++){
            if(!leftRow[row] && !upperDiagonal[row + col] && !lowerDiagonal[(n - 1) + col - row]){
                board[row][col] = 'Q';
                leftRow[row] = true;
                upperDiagonal[row + col] = true;
                lowerDiagonal[(n - 1) + col - row] = true;
                solve(col + 1, board, leftRow, upperDiagonal,lowerDiagonal, count, n);
                board[row][col] = '.';
                leftRow[row] = false;
                upperDiagonal[row + col] = false;
                lowerDiagonal[(n - 1) + col - row] = false;
            }
        }
    }
}