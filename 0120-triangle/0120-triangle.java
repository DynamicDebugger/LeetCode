class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();
        int[] prev = new int[n];

        for(int j = n - 1 ; j >= 0 ; j--){
            prev[j] = triangle.get(n - 1).get(j);
        }

        for(int i = n - 2 ; i >= 0 ; i--){
            int[] cur = new int[n];
            for(int j = i ; j >= 0 ; j--){
                cur[j] = triangle.get(i).get(j) + Math.min(prev[j], prev[j + 1]);
            }
            prev = cur;
        }
        return prev[0];
    }
}
/*
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
*/