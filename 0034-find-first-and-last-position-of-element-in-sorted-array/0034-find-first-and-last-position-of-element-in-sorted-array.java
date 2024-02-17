class Solution {
    public int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
        
        res[0] = firstOcc(nums,target);
        res[1] = lastOcc(nums,target);
        
        return res;

    }
    int firstOcc(int[] arr,int target){
        int start = 0;
		int end = arr.length - 1;
		int res = -1;
		while(start <= end) {
			
			int mid = start + (end - start)/2;
			
			if(arr[mid] == target) {
				res = mid;
				end = mid - 1;
				
			}else if(target < arr[mid]) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		
		return res;
    }
    
    int lastOcc(int[] arr,int target){
        int start = 0;
		int end = arr.length - 1;
		int res = -1;
		while(start <= end) {
			
			int mid = start + (end - start)/2;
			
			if(arr[mid] == target) {
				res = mid;
				start = mid + 1;
				
			}else if(target < arr[mid]) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		
		return res;
    }
}