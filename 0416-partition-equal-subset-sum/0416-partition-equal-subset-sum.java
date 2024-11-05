class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length, target = 0;
        for(int i = 0 ; i < n ; i++) target += nums[i];
        if(target % 2 == 1) return false;
        target /= 2;
        boolean[] prev = new boolean[target+ 1];
        prev[0]=true;
        // Initialize the first element
        if (nums[0] <= target) {
            prev[nums[0]] = true;
        }

        for(int ind = 1 ; ind  < n ; ind++){
            boolean[] cur = new boolean[target+ 1];
            cur[0] = true;
            for(int sum = 1; sum <= target ; sum++){
                
                boolean pick = false; 
                if(nums[ind] <= sum)pick = prev[sum - nums[ind]];
                //not pick
                boolean notPick = prev[sum];
                
                cur[sum] = pick | notPick;                
            }
            prev = cur;
        }
        return prev[target];
    }
}
/*
    public boolean canPartition(int[] nums) {
        int n = nums.length, target = 0;
        for(int i = 0 ; i < n ; i++) target += nums[i];
        if(target % 2 == 1) return false;
        Boolean[][] dp = new Boolean[n][target + 1];
        return subsetPartition(n - 1, target/2, nums, dp);
    }
    private boolean subsetPartition(int ind, int tar, int[] arr, Boolean[][] dp){
        
        if(tar == 0) return true;
        
        if(ind < 0 || tar < 0) return false;
        
        if(dp[ind][tar] != null) return dp[ind][tar];
        //pick
        boolean pick = subsetPartition(ind - 1, tar - arr[ind], arr, dp);
        //not pick
        boolean notPick = subsetPartition(ind - 1,tar, arr, dp);
        
        return dp[ind][tar] = pick | notPick;
    }   
*/