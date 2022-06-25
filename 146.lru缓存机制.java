/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int size;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.size = capacity;
    }
    
    public int get(int key) {
       return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
        
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
        return size() >= this.size;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

