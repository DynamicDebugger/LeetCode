class Solution {
    public List<String> commonChars(String[] words) {
        
        Map<Character,Integer> freqMap = new HashMap<>();

        for(int i = 0 ; i < words[0].length() ; i++){
            char c = words[0].charAt(i);
            if(!freqMap.containsKey(c)){
                freqMap.put(c,1);
            }else{
                freqMap.put(c,freqMap.get(c)+1);
            }
        }

        for(int i = 1 ; i < words.length ; i++){
            Map<Character,Integer> map = new HashMap<>();
            for(int j = 0 ; j < words[i].length() ; j++){
                char c = words[i].charAt(j);
                if(!map.containsKey(c)){
                    map.put(c,1);
                }else{
                    map.put(c,map.get(c)+1);
                }
            }
            for(Map.Entry<Character,Integer> em: freqMap.entrySet()){
                char key = em.getKey();int val = em.getValue();
                if(map.containsKey(key)){
                    freqMap.put(key,(map.get(key) < val) ?map.get(key):val);
                }else{
                    freqMap.put(key,0);
                }
            }
           
        }

        List<String> list = new ArrayList<>();
        for(Map.Entry<Character,Integer> em: freqMap.entrySet()){
            char key = em.getKey();int val = em.getValue();

            for(int j = 0 ; j < val ; j++){
                list.add(String.valueOf(key));
            }
        }

        return list;

    }
}