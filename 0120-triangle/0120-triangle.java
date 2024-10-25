class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        
        int[][] dp = new int[m][n];
        for(int[] r: dp)Arrays.fill(r, -1);
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            min = Math.min(min, pathSum(m - 1, i, triangle, dp));
        }
        return min;        
    }


    static int pathSum(int i, int j, List<List<Integer>> path, int[][] dp){
        if(i < 0 || j < 0 || j >= path.get(i).size()) return Integer.MAX_VALUE;
        if (i == 0) return path.get(i).get(j);
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int f = pathSum(i - 1, j, path, dp);
        int s = pathSum(i - 1, j - 1, path, dp);
        
        return dp[i][j] = path.get(i).get(j) + Math.min(f, s);
    }
}