class Solution {
    public int search(int[] arr, int target) {
		
        int index = -1;
        int pivot = findPivot(arr);
			
        int element = binarySearch(arr,0,pivot,target);
		
		if(element == -1) {
			element = binarySearch(arr,pivot+1,arr.length - 1,target);
		}
        return element;
    }
    	//Approach-1: Find the pivot in the array(pivot ~ largest element) then apply binary search in both halves
	
	//Step-1 => Find the pivot i.e., by start > mid
	
	 int findPivot(int[] arr) {
		
		int start = 0;
		int end = arr.length - 1;
		
		while(start < end) {
			
			int mid = start + (end - start)/2;
			
			//4 Cases
			if(mid < end && arr[mid] > arr[mid+1]) {
				return mid;
			}
			
			if(mid > start && arr[mid] < arr[mid-1]) {
				return mid-1;
			}
			
			if(arr[mid] <= arr[start]) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		
		return -1;
	}
	//Step-2: Apply binary search within given range
	int binarySearch(int[] arr, int start, int end, int target) {
		
		while(start <= end) {
			
			int mid = start + (end -start)/2;
			
			if(target < arr[mid]) {
				end = mid - 1;
			}else if(target > arr[mid]) {
				start = mid + 1;
			}else {
				return mid;
			}
		}
		
		return -1;
	}
}