class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int len = 1 << n;

        List<List<Integer>> powerSet = new ArrayList<>();
        for(int i = 0 ; i < len ; i++){
            List<Integer> set = new ArrayList<>();
            int temp = i;

            for(int j = 0 ; j < n ; j++){
                if((temp & 1) == 1) set.add(nums[j]);
                temp >>= 1;
            }

            powerSet.add(set);
        }
        return powerSet;
    }
}