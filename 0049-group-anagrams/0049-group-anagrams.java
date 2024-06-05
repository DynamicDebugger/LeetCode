class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();

        for(int i = 0 ; i < strs.length ; i++){
            List<String> group = new ArrayList<>();
            String s = strs[i];
            if(s == null) continue;
            group.add(s);
            for(int j = i + 1 ; j < strs.length ; j++){
                String t = strs[j];
                if(s != null && t != null && isAnagram(s,t)){
                    group.add(t);
                    strs[j] = null;
                }
                strs[i] = null;
            }
            anagrams.add(group);

        }
        return anagrams;
    }
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())    return false;

        int[] count = new int[26];
        for(int i = 0 ; i < s.length() ;i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int n: count){
            if(n != 0) return false;
        }
        return true;
    }
}