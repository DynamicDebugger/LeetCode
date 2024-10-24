class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int[] row: dp)Arrays.fill(row, -1);

        return totPath(m - 1, n - 1, grid, dp);

    }

    private int totPath(int row, int col, int[][] path, int[][] dp){
        
        if(row < 0 || col < 0) return Integer.MAX_VALUE;;
        if(row == 0  && col == 0) return path[row][col];
        
        if(dp[row][col] != -1) return dp[row][col];
        
        int up = totPath(row - 1, col, path, dp);
        int left = totPath(row, col - 1, path,dp);
        
        int min = path[row][col] +  Math.min(up, left);
        return dp[row][col] = min;
    }    
}


        // int[] prev = new int[n];

        // for(int row = 0 ; row < m ; row++){
        //     int[] cur = new int[n];
        //     for(int col = 0 ; col < n ; col++){
        //         int up = Integer.MAX_VALUE,left = Integer.MAX_VALUE;
        //         if(row == 0 && col == 0) cur[col] = grid[row][col];
        //         else{
        //             if(row > 0) up = prev[col];
        //             if(col > 0) left = cur[col -1];
        //             cur[col] = grid[row][col] + Math.min(up, left);
        //         }
        //     }
        //     prev = cur;
        // }
        // return prev[n-1];