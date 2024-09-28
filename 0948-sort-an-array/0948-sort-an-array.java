class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quicksort(int[] arr, int low, int hi){

        if(low >= hi){
            return;
        }

        int s = low, e = hi;
        int m = s + (e - s) / 2;
        int pivot = arr[m];

        while(s <= e){
            
            while(arr[s] < pivot){
                s++;
            }
            while(arr[e] > pivot){
                e--;
            }

            if(s <= e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        quicksort(arr, low, e);
        quicksort(arr, s, hi);
    }
}