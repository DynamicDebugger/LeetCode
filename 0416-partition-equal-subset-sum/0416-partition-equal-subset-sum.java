class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length, target = 0;
        for(int i = 0 ; i < n ; i++) target += nums[i];
        Boolean[][] dp = new Boolean[n][target + 1];
        return subsetPartition(n - 1, 0, target, nums, dp);
    }
    private boolean subsetPartition(int ind, int sum, int tar, int[] arr, Boolean[][] dp){
        
        if(tar == sum) return true;
        
        if(ind < 0) return false;
        
        if(dp[ind][sum] != null) return dp[ind][sum];
        //pick
        boolean pick = subsetPartition(ind - 1, sum + arr[ind], tar - arr[ind], arr, dp);
        //not pick
        boolean notPick = subsetPartition(ind - 1, sum, tar, arr, dp);
        
        return dp[ind][sum] = pick | notPick;
    }    
}