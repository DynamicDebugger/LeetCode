class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return window(nums, k) - window(nums, k - 1);
    }

    private int window(int[] nums, int k){
        if(k < 0) return 0;
        int l = 0 , r = 0, n = nums.length, c = 0, odd = 0;

        while(r < n){
            if(nums[r] % 2 == 1) odd++;
            while(odd > k){
                if(nums[l] % 2 == 1) odd--;
                l++;
            }
            c += (r - l + 1);
            r++;
        }
        return c;
    }
}