class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n < k) return new int[n - k + 1];
        int ans[] = new int[n - k + 1];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int r = 0, i = 0;

        while(r < n){

            pq.add(new int[]{nums[r], r});

            while(pq.peek()[1] <= r - k){
                pq.poll();
            }
            if (r >= k - 1) ans[r - k  + 1] = pq.peek()[0];
            r++;
        }

        return ans;
    }
}