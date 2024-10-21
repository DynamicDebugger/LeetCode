class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        // int[] dp = new int[n];

        // dp[0] = nums[0];
        int prev = nums[0], prevPrev = 0; 
        for(int i = 1 ; i < n ; i++){
            int pick  = nums[i] + prevPrev;
            int notPick = prev;

            prevPrev = prev;
            prev = Math.max(pick, notPick);
        }
        return prev;
    }
}