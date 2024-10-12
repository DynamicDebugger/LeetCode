class Solution {
    public int minBitFlips(int start, int goal) {
        int flip = start ^ goal;
        int c = 0;
        while(flip > 0){
            c++;
            flip = flip & (flip -1);
        }
        return c;
    }
}