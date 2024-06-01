class Solution {
    public int scoreOfString(String s) {
        
        int n = s.length();
        int i = 1,ans = 0;
        while(i < n){
            ans += Math.abs(s.charAt(i-1) - s.charAt(i));
            i++;
        }
        return ans;
    }
}