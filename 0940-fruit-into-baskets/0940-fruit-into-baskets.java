class Solution {
    public int totalFruit(int[] fruits) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, n = fruits.length;
        int max = 0;
        while(r < n){
            int tree = fruits[r];
            map.put(tree, map.getOrDefault(tree, 0) + 1);   
            //shrink the window
            while(map.size() > 2){
                int tr = fruits[l];
                int val = map.get(tr);
                map.put(tr, val - 1);
                if(map.get(tr) == 0) map.remove(tr);
                l++;
            }
            if(map.size() <= 2)max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}