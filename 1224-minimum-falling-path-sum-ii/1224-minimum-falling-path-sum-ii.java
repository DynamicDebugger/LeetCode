class Solution {
    public int minFallingPathSum(int[][] grid) {
        
        int n = grid.length;
        int[] prev = new int[n];
        int minSum = Integer.MAX_VALUE;

        for(int row = 0 ; row < n ; row++){

            int[] cur = new int[n];
            for(int col = 0 ; col < n ; col++){
                
                if(row == 0) cur[col] = grid[row][col];
                else{
                    int min = Integer.MAX_VALUE;
                    for(int i = 0 ; i < n ; i++){
                        if(i != col) min = Math.min(min, prev[i]);
                    } 
                    cur[col]= grid[row][col] + min;                   
                }
            }

            prev = cur;
        }

        for(int i = 0 ; i < n ; i++) minSum = Math.min(minSum, prev[i]);
        return minSum;
    }
}

/*  MEMEOIZATION
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
*/