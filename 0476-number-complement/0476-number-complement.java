class Solution {
    public int findComplement(int num) {
        int n = num, noBits = 0,mask = 1;
        while(n > 0){
            noBits++;
            mask <<= 1;
            n >>= 1;
        }
        mask--;
        return num^mask;        
    }
}