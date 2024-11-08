class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev = cost[1], prevprev = cost[0];
        for(int i = 2 ; i < n ; i++){
            int cur = cost[i] + Math.min(prev, prevprev);
            prevprev = prev;
            prev = cur;
        }
        return Math.min(prev,prevprev);
    }
}