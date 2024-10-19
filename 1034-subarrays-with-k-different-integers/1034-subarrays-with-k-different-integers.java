class Solution {
    public int subarraysWithKDistinct(int[] a, int k) {
        return window(a, k) - window(a, k - 1);
    }

    private int window(int[] a, int k){

        if(k < 0) return 0;

        int l =0, r = 0, n = a.length;

        Map<Integer, Integer> map = new HashMap<>();

        int cnt = 0;

        while(r < n){
            int num = a[r];
            map.put(num, map.getOrDefault(num, 0) + 1);

            while(map.size() > k){
                int key = a[l];
                int val = map.get(key) - 1;
                map.put(key, val);
                if(val == 0) map.remove(key);
                l++;
            }
            cnt += (r - l + 1);
            r++;
        }
        return cnt;
    }
}