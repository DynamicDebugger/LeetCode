class Solution {
    public int[] singleNumber(int[] nums) {
        
        int xor = 0;int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            xor ^= nums[i];
        }

        int setBit = (xor & (xor - 1)) ^ xor;
        int b1 = 0, b2 = 0;
        for(int i = 0 ; i < n ; i++){
            int num = nums[i];
            if((num & setBit) == 0){
                b1 ^= num;
            }else{
                b2 ^= num;
            }
        }

        int[] ans = { b1, b2};
        return ans;
    }
}