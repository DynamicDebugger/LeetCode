class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        //Create two HashMap for two arrays
        
        //HashMap 1
        Map<Integer,Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        
        //HashMap 2
        Map<Integer,Integer> map2 = new HashMap<>();
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        
        
        //Now compare both HashMap keys
        //If yes,then append the min value of both map to an array
        Set<Integer> keysSet = (map1.size() < map2.size()) ? map1.keySet() : map2.keySet();
        
        int i = 0;
        int[] arr = new int[(nums1.length < nums2.length)?nums1.length:nums2.length];
        
        for(int key: keysSet){
            
            if(map1.containsKey(key) && map2.containsKey(key)){
            	
            	int minSize = (map1.get(key) < map2.get(key)) ? map1.get(key) : map2.get(key);
            	
            	for(int j = 0 ; j < minSize ; j++) {
            		System.out.println(key);
            		arr[i++] = key;
            	}
            }
            
        }
        return Arrays.copyOfRange(arr, 0, i);        
    }
}