class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, c = 0, max = 0, n = nums.length;

        while(r < n){
            if(nums[r] == 0){
                c++;
            }
            
            if(c > k){
                if(nums[l] == 0){
                    c--;
                }
                l++;
            }
            if(c <= k)max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}