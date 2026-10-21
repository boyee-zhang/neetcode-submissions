class LRUCache {
    int totalCapacity;
    Map<Integer,Node> map;
    Node head;
    Node tail;

    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    
    
    public LRUCache(int capacity) {
        head = new Node(0,0);
        tail = new Node(0,0);
        head.prev = tail;
        tail.next = head;
        head.next = tail;
        tail.prev = head;

        totalCapacity = capacity;
        map = new HashMap<>();
    }
    
    public void addToHead(Node node)
    {   
        map.put(node.key,node);
        head.next.next.prev = node;
        node.next = head.next.next;
        head.next = node;
        node.prev = head;
    }

    public void deleteNode (Node node)
    {   
        node.prev.next = node.next;
        node.next.prev = node.prev;

        map.remove(node.key);
        System.out.println("Deleting: " + node.key);

        //return Node value
    }

    public void removeHead()
    {   
        System.out.println("Deleting to head: " + head.next.key);
        map.remove(head.next.key);

        if(head.next == tail) return;
        deleteNode(head.next);
    }

    public void addTail(Node node)
    {   
        map.put(node.key,node);

        tail.prev.next = node;
        node.prev = tail.prev;

        node.next = tail;
        tail.prev = node;

        System.out.println("Adding to tail: " + node.key);
    }

    public int get(int key) {
        //update queue 
        if(map.containsKey(key))
        {   
            Node node = map.get(key);
            deleteNode(node);
            addTail(node);
            return node.value;
        }
        else
        {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        
        if (map.containsKey(key)) {
        deleteNode(map.get(key));
    }

    // 2. 插入新节点（统一调用 addTail）
    Node newNode = new Node(key, value);
    addTail(newNode); // addTail 内部负责 map.put(key, node)

    // 3. 统一检查容量约束
    if (map.size() > totalCapacity) { 
        // 这里的 totalCapacity 是构造函数传进来的固定值
        removeHead(); // removeHead 内部负责 map.remove
    }

    }
}
