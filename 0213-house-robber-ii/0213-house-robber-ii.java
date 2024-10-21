class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;

        if(n == 1) return nums[0];

        int first = robHouse(0, n - 2, nums);
        int last = robHouse(1, n - 1, nums);

        return Math.max(first, last);
    }

    private int robHouse(int s, int e, int[] nums) {
        
        int prev = nums[s], prevPrev = 0; 
        //dp[i -2] -> prevPrev, dp[i - 1] -> prev
        for(int i = s + 1 ; i <= e ; i++){
            int pick  = nums[i] + prevPrev;
            int notPick = prev;

            prevPrev = prev;
            prev = Math.max(pick, notPick);
        }
        return prev;        
    }    
}