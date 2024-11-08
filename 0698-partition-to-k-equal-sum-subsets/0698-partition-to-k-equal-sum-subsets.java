class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        
        // If the total sum is not divisible by k, we can't partition
        if (sum % k != 0) return false;
        
        int target = sum / k;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        
        // Start by attempting to form subsets from the largest elements
        return canPartition(nums, visited, k, target, 0, 0);
    }

    private boolean canPartition(int[] nums, boolean[] visited, int k, int target, int currSum, int start) {
        // If only one subset is left, the remaining numbers must form the subset, so we return true
        if (k == 1) return true;
        
        // If we've formed a subset, move on to the next subset
        if (currSum == target) {
            return canPartition(nums, visited, k - 1, target, 0, 0);
        }

        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && currSum + nums[i] <= target) {
                visited[i] = true;
                // Recursively try to form the subset with the current element included
                if (canPartition(nums, visited, k, target, currSum + nums[i], i + 1)) {
                    return true;
                }
                // Backtrack
                visited[i] = false;
            }
        }
        
        return false;
    }
}
