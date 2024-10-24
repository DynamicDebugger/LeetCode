class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int minSum = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int[] r: dp) Arrays.fill(r, 100);
        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, pathSum(grid, n - 1, col, dp));
        }
        
        return minSum;
    }
    

    private int pathSum(int[][] path, int row, int col, int[][] dp){
        if(row == 0) return path[row][col];

        if(dp[row][col] != 100) return dp[row][col];

        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < path.length ; i++){
            if(i != col) min = Math.min(min, pathSum(path, row - 1, i, dp));
        }

        return dp[row][col] = path[row][col] + min;
    }

}
