class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return slidingWindow(nums, goal) - slidingWindow(nums, goal - 1);
    }

    private int slidingWindow(int[] arr, int goal){
        if(goal < 0) return 0;

        int l = 0, r = 0, n = arr.length, sum = 0, cnt = 0;

        while(r < n){
            sum += arr[r];
            while(sum > goal){
                sum -= arr[l];
                l++;
            }
            cnt += (r - l + 1);
            r++;
        }
        return cnt;
    }
}