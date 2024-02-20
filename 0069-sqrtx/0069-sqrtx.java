class Solution {
    public int mySqrt(int x) {
        // return 0 because sqrt(0) ~ 0
        if(x == 0)  return 0;
        
        long start = 1,end = x;
        
        while(start <= end){
            
            long mid = start + (end - start)/2;
            
            long sq = mid * mid;
            
            if(sq == x){
                return (int)mid;
            }else if(x < sq){
                end = mid -1;
            }else{
                start = mid +1;
            }
        }
        
        return (int)end;// beacuse if not perfect sq  then end w9ll be the nearset possible sqrt
    }
}