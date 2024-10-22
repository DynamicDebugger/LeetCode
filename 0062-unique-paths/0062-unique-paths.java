class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row: dp) Arrays.fill(row, -1);
        return totUniqPath(m -1, n -1, dp);        
    }
    private int totUniqPath(int row, int col,int[][] dp){
        
        if(row < 0 || col < 0) return 0;
        if(row == 0  && col == 0)
            return 1;
        if(dp[row][col] != -1) return dp[row][col];
        int count = 0;
        
        count += totUniqPath(row, col - 1, dp);//right

        count += totUniqPath(row - 1, col, dp);//down

        return dp[row][col] = count;
    }	
}