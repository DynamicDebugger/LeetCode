class Solution {
    public int maximumProduct(int[] nums) {
        sort(nums,nums.length);
        System.out.println(Arrays.toString(nums));

        int n = nums.length;
        int p = 1;
        int l = nums[0] * nums[1] * nums[n-1];
        int r = nums[n-1] * nums[n-2] * nums[n-3];
        
        // if(l > r){
        //     p = l * nums[n-1];
        //     System.out.println(l);
        // }else{
        //     p = r * nums[n-3];
        //     System.out.println(r);
        // }
	    // System.out.println(p);

        return Math.max(l,r);
    }
    public void sort(int[] arr, int n) {
		
		for(int i = 0 ; i <= n - 2 ; i++) {
			
			for(int j = i + 1 ; j > 0 ; j--) {
				
				if(arr[j] < arr[j -1]) {
				int temp = arr[j - 1];
				arr[j - 1] = arr[j];
				arr[j] = temp;
				}else {
					break;
				}

			}

		}
	}
}