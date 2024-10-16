class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, n = s.length();

        int max = 0, freq = 0;
        int[] count = new int[26];

        while(r < n){

            char ch = s.charAt(r);
            count[ch - 'A']++;
            freq = Math.max(freq, count[ch - 'A']);

            while((r - l + 1) - freq > k){
                count[s.charAt(l) - 'A']--;
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}