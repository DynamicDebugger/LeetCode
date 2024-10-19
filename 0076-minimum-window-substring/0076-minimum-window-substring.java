class Solution {
    public String minWindow(String s, String t) {
        int sInd = -1, minLen = Integer.MAX_VALUE;
        Map<Character,Integer> map = new HashMap<>();

        int l = 0, r = 0, n = s.length(), m = t.length(), cnt = 0;
        if(n < m) return "";
        for(int i = 0 ; i < m ; i ++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        while(r < n){
            char c = s.charAt(r);
            if(map.containsKey(c)){
                if(map.get(c) > 0) cnt++;
                map.put(c, map.getOrDefault(c, 0) - 1);
            }
            
            while(cnt == m){
                if((r - l + 1) < minLen){
                    minLen = r - l + 1;
                    sInd = l;
                }
                char ch = s.charAt(l);
                if(map.containsKey(ch)){
                    map.put(ch, map.get(ch) + 1);
                    if(map.get(ch) > 0) cnt--;
                }
                l++;
            }
            r++;
        }

        return (sInd == -1) ? "":s.substring(sInd, sInd  + minLen);
    }
}