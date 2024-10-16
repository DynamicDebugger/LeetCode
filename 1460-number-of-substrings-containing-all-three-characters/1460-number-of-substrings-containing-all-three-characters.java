class Solution {
    public int numberOfSubstrings(String s) {
        int[] a = {-1, -1, -1};
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            a[s.charAt(i) - 'a'] = i;
            count += (1 + Math.min(a[0], Math.min(a[1], a[2])));
        }
        return count;
    }
}