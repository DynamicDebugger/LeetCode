class Solution {
    public int[] buildArray(int[] nums) {
        int size=nums.length;
        int[] ans =new int[size];
        for(int i=0;i<size;i++){
            ans[i]=nums[nums[i]];
        }
        return ans;    
    }
    
}