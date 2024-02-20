class Solution {
    
    public int[] twoSum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int currentSum = arr[left] + arr[right];

            if (currentSum == target) {
                return new int[]{left + 1, right + 1};  // Return 1-based indices
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[2];  // In case no solution is found
    }
    
    
    /*** optmial for unsortated array
    public int[] twoSum(int[] arr, int target) {

        Map<Integer,Integer> index = new HashMap<>();
        
        for(int i = 0 ; i < arr.length ; i++){
            int s = target - arr[i];
            
            if(index.containsKey(s)){
                return new int[]{index.get(s),i+1};
            }
            
            index.put(arr[i],i+1);
        }
        
        return new int[2]
    }
    ***/
    //Non-optimal solution o(n.logn)
    /**
    public int[] twoSum(int[] arr, int target) {
        int index[] = new int[2];
        for(int i=0; i < arr.length ; i++){
            
            index[0] = i+1;
            int s = target - arr[i];
            
            int index2 =binarySearch(arr,s);
            if(index2 != -1){
                index[1] = index2 + 1;
                break;
            }
        }
        return index;
    }
    
    //To search the second equivalent indices
    int binarySearch(int[] arr, int target){
        
        int s = 0;
        int e = arr.length - 1;
        int res =-1;
        while(s <= e){
            
            int mid = s + (e - s)/2;
            
            if(target < arr[mid]){
                e = mid - 1;
            }else if(target > arr[mid]){
                s = mid + 1;
            }else{
                res = mid;
                s = mid + 1;
            }
        }
        
        return res;
    }
    
    **/
}