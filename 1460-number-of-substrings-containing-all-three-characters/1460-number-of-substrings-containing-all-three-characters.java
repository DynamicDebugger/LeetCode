class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, n = s.length(), k = 3;
        int count = 0;
    
        while (r < n) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(map.size() == k){
                count += n - r;
                char c = s.charAt(l);
                int val = map.get(c) - 1;
                if(val == 0) map.remove(c);
                else map.put(c, val);
                l++;
            }
            r++; 
        }
    
        return count;        
    }
}