class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int r = grid.length;
        int c = grid[0].length;

        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                if(grid[i][j] == 1){
                    ans = Math.max(ans, isIsland(i, j, r, c, grid));
                }
            }
        }
        return ans;        
    }
    private int isIsland(int curR, int curC, int r, int c, int[][] grid){
        if(curR < 0 || curC < 0 || curR >= r || curC >= c || grid[curR][curC] == 0){
            return 0;
        }
        grid[curR][curC] = 0;
        //t b l r
        int count = 1;
        count += isIsland(curR + 1, curC , r, c, grid);
        count += isIsland(curR - 1, curC , r, c, grid);
        count += isIsland(curR, curC - 1 , r, c, grid);
        count += isIsland(curR, curC + 1 , r, c, grid);
        return count;
    }
}