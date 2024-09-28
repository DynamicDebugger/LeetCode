class Pair{
    int row;
    int col;
    int time;
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col; 
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;//row
        int n = grid[0].length;//col

        int[][] vis = new int[m][n];
        Queue<Pair> qu = new LinkedList<>();
        int cntFresh = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 2){
                    qu.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }else{
                    vis[i][j] = 0;
                }

                if(grid[i][j] == 1) cntFresh++;//count tot fresh orange
            }
        }


        int maxTime = 0;
        int cnt = 0;
        int[] dRow = {1, 0, -1, 0};
        int[] dCol = {0, 1, 0, -1};
        while(!qu.isEmpty()){
            Pair node = qu.poll();
            int r = node.row;
            int c = node.col;
            int t = node.time;
            maxTime = Math.max(t, maxTime);

            for(int i = 0 ; i < 4 ; i++){
                int nRow = r + dRow[i];
                int nCol = c + dCol[i];

                if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                    qu.add(new Pair(nRow, nCol, t + 1));
                    vis[nRow][nCol] = 1;
                    cnt++;
                }
            }
        }

        if(cnt != cntFresh) return -1;
        return maxTime;

    }
}