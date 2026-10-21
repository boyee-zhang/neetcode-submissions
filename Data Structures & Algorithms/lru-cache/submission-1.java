class LRUCache {
    Queue<Integer> q;
    int curCapacity;
    Map<Integer,Integer> map;

    public LRUCache(int capacity) {
        q = new LinkedList<>();
        curCapacity = capacity;
        map = new HashMap<>();
    }
    

    public int get(int key) {
        //update queue 
        if(map.containsKey(key))
        {   
            q.remove(key);
            q.add(key);
            return map.get(key);
        }
        else
        {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        
        if(curCapacity > 0 && !map.containsKey(key))
        {
            map.put(key,value);
            q.add(key);
            curCapacity --;
        }
        else if(curCapacity > 0 && map.containsKey(key))
        {
            // remove elements from queue need O(N)
            map.put(key,value);
            q.remove(key);
            q.add(key);
            
        }
        else if(curCapacity <= 0 && map.containsKey(key))
        {   
            q.remove(key);
            map.put(key,value);
            q.add(key);
        }
        else
        {
            int removeKey = q.poll();
            map.remove(removeKey);

            map.put(key,value);
            q.add(key);
        }

    }
}
