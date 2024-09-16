class LRUCache {
    Map<Integer, Integer> map;
    Queue<Integer> qu;
    int cap;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();//key -> val & val -> age
        this.qu = new LinkedList<>();
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            qu.remove(key);
            qu.add(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            qu.remove(key);
        }
        else if(qu.size() >= cap){
            int lru = qu.poll();
            map.remove(lru);
        }
        map.put(key,value);
        qu.add(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */