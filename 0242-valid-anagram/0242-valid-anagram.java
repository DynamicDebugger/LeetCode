class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())    return false;
        Map<Character,Integer> map1 = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(!map1.containsKey(c)){
                map1.put(c,1);
                continue;
            }
            map1.put(c,map1.get(c)+1);
        }

        for(int i = 0 ; i < t.length() ; i++){
            char c = t.charAt(i);
            if(map1.containsKey(c)){
                map1.put(c,map1.get(c)-1);
            }else{
                map1.put(c,1);
            }
            
        }

        for(Map.Entry<Character,Integer> map : map1.entrySet()){
            char key = map.getKey();int val = map.getValue();
            if(val != 0){
                return false;
            }
        }

        return true;
    }
}