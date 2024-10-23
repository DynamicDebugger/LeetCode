class Solution {
    public int uniquePathsWithObstacles(int[][] path) {
        int m = path.length;
        int n = path[0].length;
        
        int[][] dp = new int[m][n];
        for(int[] r: dp) Arrays.fill(r, -1);
        return totPath(m - 1, n - 1, path, dp);
    }
    private int totPath(int row, int col, int[][] path, int[][] dp){
        
        if(row < 0 || col < 0 || path[row][col] == 1) return 0;
        if(row == 0  && col == 0) return 1;
        
        if(dp[row][col] != -1) return dp[row][col];
        
        int up = totPath(row - 1, col, path, dp);
        int left = totPath(row, col - 1, path,dp);
        
        return dp[row][col] = up + left;
    }    
}