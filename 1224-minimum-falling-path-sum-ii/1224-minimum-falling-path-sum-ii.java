class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int minSum = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int[] r: dp) Arrays.fill(r, 100);
        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, findMinPath(grid, n - 1, col, dp));
        }
        
        return minSum;
    }
    
    private int findMinPath(int[][] grid, int row, int col, int[][] dp) {
        if (row == 0) {
            return grid[row][col];
        }
        
        if(dp[row][col] != 100) return dp[row][col];
        int minPrevRowSum = Integer.MAX_VALUE;
        
        for (int prevCol = 0; prevCol < grid.length; prevCol++) {
            if (prevCol != col) {
                minPrevRowSum = Math.min(minPrevRowSum, findMinPath(grid, row - 1, prevCol, dp));
            }
        }
        
        return dp[row][col] = grid[row][col] + minPrevRowSum;
    }
}
