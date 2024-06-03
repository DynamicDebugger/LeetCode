class Solution {
    public int[] countBits(int n) {
        
        int[] arr = new int[n+1];
        
        for(int i = 0 ; i <= n ; i++){
            arr[i] = noOfSetBitsN(i);
        }
        return arr;
    }

    public int noOfSetBitsN(int n){
        int count = 0;
        while(n > 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}