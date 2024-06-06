class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int max = arr[n - 1],min = arr[0];
        if(k > max - n) return max+ (k -(max-n));
        if(k < min) return k;
        
        // Binary search for the k-th missing number
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int missing = arr[m] - (m + 1);

            if (missing < k) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        // The k-th missing number is beyond the last element in the array
        return k + r + 1;
    }
}