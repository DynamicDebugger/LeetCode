class Solution {
    public int findNumbers(int[] nums) {
        int countEvenDigits = 0;
        
        for(int num : nums){
            
            if(countAndCheckEvenDigits(num))
                countEvenDigits++;
        }
        
        return countEvenDigits;
    }
    static boolean countAndCheckEvenDigits(int n){
        
        int count = 0 ;
        
        //Count the digits in a number
        while(n > 0){
            count++;
            n /= 10;
        }
        
        if( count % 2 == 0 )
            return true;
        else 
            return false;
    }
}