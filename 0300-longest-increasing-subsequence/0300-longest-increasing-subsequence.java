class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for(int[] r: dp)Arrays.fill(r, -1);
        return backtrack(0, n, -1, nums, dp);
    }
    private int backtrack(int ind, int n, int lastInserted, int[] a, int[][] dp){
        
        //base
        if(ind == n) return 0;
        if(dp[ind][lastInserted + 1] != -1) return dp[ind][lastInserted + 1];

        //pick in parameter i should keep track of latest picked element
        int pick = 0;
        if(lastInserted == -1 || a[lastInserted] < a[ind]) 
            pick = 1 + backtrack(ind + 1, n, ind, a, dp);
        //not pick
        int notPick = backtrack(ind + 1, n, lastInserted, a, dp);
        return dp[ind][lastInserted + 1] =  Math.max(pick, notPick);
    }
}