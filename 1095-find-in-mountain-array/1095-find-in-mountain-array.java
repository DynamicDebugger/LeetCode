/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int peek = peekOfMountain(mountainArr);
        
        int elementIndex = (binarySearch(mountainArr, 0, peek, target, true)  == -1) ? binarySearch(mountainArr, peek, mountainArr.length() - 1, target, false) : binarySearch(mountainArr, 0, peek, target, true);
        
        
        return elementIndex;
    }

    //peekOfMountain ~ method to return peek element index
    public int peekOfMountain (MountainArray mountainArr){
     
        int start = 0;
        int end = mountainArr.length() - 1;
        
        while(start < end){
            
            int mid = start + (end - start) / 2;
            
            if(mountainArr.get(mid) > mountainArr.get(mid+1)){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
        
    }
    //binarySearch
    public int binarySearch(MountainArray mountainArr,int start,int end,int target,boolean isAsc) {
        
    	 while (start <= end) {
             int mid = start + (end - start) / 2;

             
             if(target == mountainArr.get(mid)){
                 return mid;
             }
             
             if(isAsc){
                 
                 if (target < mountainArr.get(mid)) {
                     end = mid - 1;
                 }else{
                     start = mid + 1;
                 }
                 
             }else{
                 
                 if (target > mountainArr.get(mid)) {
                     end = mid - 1;
                 }else{
                     start = mid + 1;
                 }
                 
             }
         }
     	
     	return -1;
    }
}