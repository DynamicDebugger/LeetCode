class Solution {
    public int findPeakElement(int[] nums) {
        
        //compare mid > mid+` then it is in down wards so we need to search in llefts ide to see any elements is at the top of it
        
        int s = 0;
        int e = nums.length - 1;
        
        while(s < e){
            
            int mid = s + (e -s)/2;

            if(nums[mid] > nums[mid+1]){
                e = mid;
            }else {
                s = mid + 1;
            }
        }
        
        return s;
    }
}