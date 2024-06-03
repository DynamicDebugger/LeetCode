class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while(n > 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}

/*
    11=>1011
    
    1011>0
        c->1
        n = 1011
          & 1010
         => 1010
    
    1010 > 0
        c->2
        n = 1010
          & 1001
         => 1000
    
    1000 > 0
        c->3
        n = 1000
          &  111
         => 0000
    
    0 > 0 \_FALSE_/
*/