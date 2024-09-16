class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                board[i][j] = '.';
        
        boolean[] lRow = new boolean[n];
        boolean[] upDiag = new boolean[(2 * n) -1];
        boolean[] loDiag = new boolean[(2 * n) - 1];

        List<List<String>> ans = new ArrayList<>();
        solve(0, board, ans, lRow, upDiag, loDiag, n);
        return ans;
    }

    private void solve(int col, char[][] board, List<List<String>> ans, boolean[] lRow, boolean[] upDiag, boolean[] loDiag, int n){

        if(col == board.length){
            ans.add(construct(board));
            return;
        }

        for(int row = 0 ; row < n ; row++){
            if(!lRow[row] && !upDiag[row + col] && !loDiag[(n - 1) + col - row]){
                board[row][col] = 'Q';
                lRow[row] = true;
                upDiag[row + col] = true;
                loDiag[(n - 1) + col - row] = true;
                solve(col + 1, board, ans, lRow, upDiag, loDiag, n);
                board[row][col] = '.';
                lRow[row] = false;
                upDiag[row + col] = false;
                loDiag[(n - 1) + col - row] = false;                
            }
        }
    }

    private List<String> construct(char[][] board){
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            String s = new String(board[i]);
            ans.add(s);
        }
        return ans;
    }
}