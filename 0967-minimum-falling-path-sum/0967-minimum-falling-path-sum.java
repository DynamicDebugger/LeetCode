class Solution {
    public int minFallingPathSum(int[][] path) {
        int m = path.length, n = path[0].length;
        int[] prev = new int[n];

        for(int row = 0 ; row < m ; row++){
            
            int[] cur = new int[n];
            for(int col = 0 ; col < n ; col++){

                if(row == 0) cur[col] = path[0][col];
                else{
                    //down, downLeft, downRight
                    int down = prev[col], downLeft = Integer.MAX_VALUE, downRight = Integer.MAX_VALUE;
                    if(col > 0)downLeft = prev[col - 1];
                    if(col + 1 < n)downRight = prev[col + 1];
                    cur[col] = path[row][col] + Math.min(down, Math.min(downLeft, downRight));         
                }
            }
            prev = cur;
        }      
                
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            min = Math.min(min, prev[i]);
        }

        return min;
    }
    private int pathSum(int row, int col, int[][] path, int[][] dp){
        if(row < 0 || col < 0 || col >= path[0].length) return Integer.MAX_VALUE;
        if(row == 0) return path[row][col];

        if(dp[row][col] != -1) return dp[row][col];

        int min = Integer.MAX_VALUE;
        //down, downLeft, downRight
        int down = pathSum(row - 1, col, path, dp);
        int downLeft = pathSum(row - 1, col - 1, path, dp);
        int downRight = pathSum(row - 1, col + 1, path, dp);

        min = path[row][col] + Math.min(down, Math.min(downLeft, downRight));
        return dp[row][col] = min;
    }
}