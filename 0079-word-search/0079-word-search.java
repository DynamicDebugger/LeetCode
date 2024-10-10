class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(board[i][j] == word.charAt(0))
                    if(dfs(i, j, row, col, 0, board, word)){
                        return true;
                    }
            }
        }
        return false;
    }
    private boolean dfs(int curRow, int curCol, int row, int col, int i, char[][] board, String word){
        if(i == word.length()){
            return true;
        }

        if(curRow < 0 || curCol < 0 || curRow >= row || curCol >= col || word.charAt(i) != board[curRow][curCol]){
            return false;
        }

        char ch = board[curRow][curCol];
        board[curRow][curCol] = '.';
        boolean res = dfs(curRow + 1, curCol, row, col, i + 1, board, word)  
                    ||dfs(curRow - 1, curCol, row, col, i + 1, board, word) 
                    ||dfs(curRow , curCol + 1, row, col, i + 1, board, word) 
                    ||dfs(curRow , curCol - 1, row, col, i + 1, board, word);
        board[curRow][curCol] = ch;
        return res;
    }
}