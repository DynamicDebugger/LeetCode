class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1 ; i < nums.length ; ){
            if(nums[i - 1] != nums[i]){
                return nums[i - 1];
            }
            i+=3;
        }
        return nums[nums.length - 1];
    }
}