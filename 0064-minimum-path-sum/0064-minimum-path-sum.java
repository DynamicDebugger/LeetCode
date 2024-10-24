class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[] prev = new int[n];

        for(int row = 0 ; row < m ; row++){
            int[] cur = new int[n];
            for(int col = 0 ; col < n ; col++){
                int up = Integer.MAX_VALUE,left = Integer.MAX_VALUE;
                if(row == 0 && col == 0) cur[col] = grid[row][col];
                else{
                    if(row > 0) up = prev[col];
                    if(col > 0) left = cur[col -1];
                    cur[col] = grid[row][col] + Math.min(up, left);
                }
            }
            prev = cur;
        }
        return prev[n-1];
    }
}