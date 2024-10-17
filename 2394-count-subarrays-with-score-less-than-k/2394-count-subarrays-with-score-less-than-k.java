class Solution {
    public long countSubarrays(int[] nums, long k) {
        int l = 0, r = 0, n = nums.length;
        long sum = 0;
        long count = 0;

        while (r < n) {
            sum += nums[r];

            // Shrink the window until the product of sum and length is less than k
            while (sum * (r - l + 1) >= k) {
                sum -= nums[l];
                l++;
            }

            // All subarrays from l to r have valid scores
            count += (r - l + 1);

            r++;
        }

        return count;
    }
}
