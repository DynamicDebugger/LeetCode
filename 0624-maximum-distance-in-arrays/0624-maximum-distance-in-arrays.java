class Solution {
    public int maxDistance(List<List<Integer>> arr) {
        int n = arr.size();

        int min = arr.get(0).get(0);
        int max = arr.get(0).get(arr.get(0).size() - 1);
        int res = 0;

        for(int i = 1 ; i < n ; i++){

            int curMin = arr.get(i).get(0);
            int curMax = arr.get(i).get(arr.get(i).size() - 1);

            int d1 = Math.abs(max -curMin);
            int d2 = Math.abs(curMax - min);

            res = Math.max(res, Math.max(d1, d2));

            min = Math.min(min, curMin);
            max = Math.max(curMax, max);
        }
        return res;
    }
}