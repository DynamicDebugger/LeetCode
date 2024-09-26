class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int r = grid.length;
        int c = grid[0].length;

        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                if(grid[i][j] == '1'){
                    ans++;
                    isIsland(i, j, r, c, grid);
                }
            }
        }
        return ans;
    }

    private void isIsland(int curR, int curC, int r, int c, char[][] grid){
        if(curR < 0 || curC < 0 || curR >= r || curC >= c || grid[curR][curC] == '0'){
            return;
        }
        grid[curR][curC] = '0';
        //t b l r
        isIsland(curR + 1, curC , r, c, grid);
        isIsland(curR - 1, curC , r, c, grid);
        isIsland(curR, curC - 1 , r, c, grid);
        isIsland(curR, curC + 1 , r, c, grid);
    }
}